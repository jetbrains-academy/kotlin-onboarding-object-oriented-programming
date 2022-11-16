import {KeyCardModel, KeyCardType} from "../models/KeyCard";
import KeyCardSquare from "./KeyCardSquare";

type KeyCardProps = {
    keyCard: KeyCardModel | null
    N: number
}

export default function KeyCard({keyCard, N}: KeyCardProps) {
    let id = 0
    return (<div className="App-key-card-container">
        {
            keyCard?.cards.chunk(N)?.map((row: Array<KeyCardType> | null, i: number) => (
                <div className="App-key-card-container-row" key={"Row" + id++}>
                    {
                        row?.map((cardType, j) => (
                            <KeyCardSquare cardType={cardType} key={"Cell" + (i * N + j)}></KeyCardSquare>
                        ))
                    }
                </div>
            ))
        }
    </div>)
}
