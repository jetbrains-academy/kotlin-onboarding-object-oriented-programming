import {KeyCardType} from "../models/KeyCard";
import CodeNamesPictureCard from "./CodeNamesPictureCard";

type GameStatisticsItemProps = {
    cardType: KeyCardType,
    current: number,
    all: number,
}

export default function GameStatisticsItemScreen({cardType, current, all}: GameStatisticsItemProps) {
    return (
        <div className="App-game-stat-item-container">
            <CodeNamesPictureCard cardType={cardType}/>
            <div className="App-game-stat-item-amount">{current}/{all}</div>
        </div>
    )
}
