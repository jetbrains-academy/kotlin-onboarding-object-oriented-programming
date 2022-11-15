import {codenames} from "common-types";
import Card = codenames.JsCodeNamesCard;
import {KeyCardType} from "../models/KeyCard";

export enum CardState {
    WORD,
    PICTURE,
}

type CodeNamesCardProps = {
    card: Card | null
    type: KeyCardType
    state: CardState
}

export default function CodeNamesCard({card, type, state}: CodeNamesCardProps) {
    return (<div className="App-card-container">
        <div>{card?.word}</div>
    </div>)
}