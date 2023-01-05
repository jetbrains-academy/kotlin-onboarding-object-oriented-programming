import {CardState, GameCardModel} from "../models/GameCard";
import {useState} from "react";
import CodeNamesPictureCard from "./CodeNamesPictureCard";

type CodeNamesCardProps = {
    gameCard: GameCardModel

    gameCardsSetter: (cards: Array<GameCardModel>) => void
    index: number
    gameCards: Array<GameCardModel>
}

export default function CodeNamesCard({gameCard, gameCardsSetter, index, gameCards}: CodeNamesCardProps) {
    let [currentGameCard, gameCardSetter] = useState(gameCard)
    if (currentGameCard.state === CardState.WORD) {
        // TODO: click on the whole button, not only on the text
        return (<div className="App-card-container-base App-card-container-word" onClick={() => {
            const newCard = new GameCardModel(currentGameCard.card, currentGameCard.type, CardState.PICTURE)
            gameCardSetter(newCard)
            gameCards[index] = newCard
            gameCardsSetter(gameCards)
        }}>
            <div>{currentGameCard.card?.word}</div>
        </div>)
    }
    return <CodeNamesPictureCard cardType={currentGameCard.type}/>
}
