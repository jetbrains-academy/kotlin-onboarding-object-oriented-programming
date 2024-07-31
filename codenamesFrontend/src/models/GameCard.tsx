import {CodeNamesCard} from "./CodeNamesCard";
import {KeyCardType} from "./KeyCard";

export enum CardState {
    WORD,
    PICTURE,
}

export class GameCardModel {
    card: CodeNamesCard
    state: CardState
    type: KeyCardType

    constructor(card: CodeNamesCard, type: KeyCardType, state: CardState) {
        this.card = card
        this.state = state
        this.type = type
    }
}