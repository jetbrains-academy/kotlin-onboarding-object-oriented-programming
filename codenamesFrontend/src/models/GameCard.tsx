import {codenames} from "common-types";
import JsCodeNamesCard = codenames.JsCodeNamesCard;
import {KeyCardType} from "./KeyCard";

export enum CardState {
    WORD,
    PICTURE,
}

export class GameCardModel {
    card: JsCodeNamesCard
    state: CardState
    type: KeyCardType

    constructor(card: JsCodeNamesCard, type: KeyCardType, state: CardState) {
        this.card = card
        this.state = state
        this.type = type
    }
}