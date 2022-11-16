import {shuffle} from "../util/util";

export enum KeyCardType {
    PINK, // 8
    VIOLET, // 9
    GRAY, // 7
    BLACK, // 1
}

export const PINK_CARDS_NUMBER = 8
export const VIOLET_CARDS_NUMBER = 9
export const GRAY_CARDS_NUMBER = 7

export class KeyCardModel {
    cards: Array<KeyCardType>

    private addCards(type: KeyCardType, types: Array<KeyCardType>, N: number) {
        for (let i = 0; i < N; i++) {
            types.push(type);
        }
    }

    // TODO: init on the server
    constructor() {
        const cards: Array<KeyCardType> = [KeyCardType.BLACK];
        this.addCards(KeyCardType.PINK, cards, PINK_CARDS_NUMBER)
        this.addCards(KeyCardType.VIOLET, cards, VIOLET_CARDS_NUMBER)
        this.addCards(KeyCardType.GRAY, cards, GRAY_CARDS_NUMBER)
        this.cards = shuffle(cards)
    }
}