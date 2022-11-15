import {KeyCardModel, KeyCardType} from "../models/KeyCard";
import KeyCardSquare from "./KeyCardSquare";

type KeyCardProps = {
    keyCard: KeyCardModel
    N: number
}

export default function KeyCard({keyCard, N}: KeyCardProps) {
    return (<div className="App-key-card-container">
        {
            keyCard.cards.chunk(N)?.map((row: Array<KeyCardType> | null, index: number) => (
                <div className="App-key-card-container-row">
                    {
                        row?.map((cardType, index) => (
                            <KeyCardSquare cardType={cardType}></KeyCardSquare>
                        ))
                    }
                </div>
            ))
        }
    </div>)
}
