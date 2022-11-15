import {shuffle} from "../util/util";

export enum KeyCardType {
    PINK, // 8
    VIOLET, // 9
    GRAY, // 7
    BLACK, // 1
}

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
        this.addCards(KeyCardType.PINK, cards, 8)
        this.addCards(KeyCardType.VIOLET, cards, 9)
        this.addCards(KeyCardType.GRAY, cards, 7)
        this.cards = shuffle(cards)
    }
}