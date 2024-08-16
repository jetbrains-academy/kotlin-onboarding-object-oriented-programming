import './App.css';
import './util/util'
import {useEffect, useState} from "react";
import GameScreen, {GameState} from "./components/GameScreen";
import {KeyCardModel} from "./models/KeyCard";
import {CardState, GameCardModel, CodeNamesCard} from "./models/GameCard";
import axios from "axios";

const N = 5

export function convertCards(cards: Array<CodeNamesCard>, keyCard: KeyCardModel | null) {
    return cards.map((card, index) => {
        return new GameCardModel(card, keyCard?.cards[index]!!, CardState.WORD)
        }
    )
}

export async function generateCards() {
    return axios.get("/cards/generate").then((response) => {
        return response.data as Array<CodeNamesCard>
    })
}

export function initGame(
    keyCardSetter: (kc: KeyCardModel) => void,
    gameCardsSetter: (cards: Array<GameCardModel>) => void
) {
    axios.get("/keyCard/new").then(async (response) => {
        const keyCardCells = response.data as Array<number>
        const newKeyCard = new KeyCardModel(keyCardCells)
        keyCardSetter(newKeyCard)
        gameCardsSetter(convertCards(await generateCards(), newKeyCard))
    })
}

function App() {
    let [gameState, gameStateSetter] = useState(GameState.START)
    let [keyCard, keyCardSetter] = useState<KeyCardModel | null>(null)
    let [gameCards, gameCardsSetter] = useState<Array<GameCardModel>>([])
    
    switch (gameState) {
        case GameState.START: {
            return (<div className="App">
                <header className="App-header-base App-header-black">
                    <GameScreen state={gameState}
                                gameStateSetter={gameStateSetter}
                                keyCard={keyCard}
                                gameCards={gameCards}
                                N={N}
                                keyCardSetter={keyCardSetter}
                                gameCardsSetter={gameCardsSetter}
                    />
                </header>
            </div>);
        }
        default: {
            return (<div className="App">
                <header className="App-header-base App-header-white">
                    <GameScreen state={gameState}
                                gameStateSetter={gameStateSetter}
                                keyCard={keyCard}
                                gameCards={gameCards}
                                N={N}
                                keyCardSetter={keyCardSetter}
                                gameCardsSetter={gameCardsSetter}
                    />
                </header>
            </div>);
        }
    }
}

export default App;
