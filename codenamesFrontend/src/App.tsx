import './App.css';
import './util/util'
import {useEffect, useState} from "react";
import GameScreen, {GameState} from "./components/GameScreen";
import {KeyCardModel} from "./models/KeyCard";
import {codenames} from "common-types";
import {CardState, GameCardModel} from "./models/GameCard";
import JsCodeNamesCard = codenames.JsCodeNamesCard;
import axios from "axios";

const N = 5
export const initCards = [
    new JsCodeNamesCard(1, "word 1"),
    new JsCodeNamesCard(2, "word 2"),
    new JsCodeNamesCard(3, "word 3"),
    new JsCodeNamesCard(4, "word 4"),
    new JsCodeNamesCard(5, "word 5"),
    new JsCodeNamesCard(6, "word 6"),
    new JsCodeNamesCard(7, "word 7"),
    new JsCodeNamesCard(8, "word 8"),
    new JsCodeNamesCard(9, "word 9"),
    new JsCodeNamesCard(10, "word 10"),
    new JsCodeNamesCard(11, "word 11"),
    new JsCodeNamesCard(12, "word 12"),
    new JsCodeNamesCard(13, "word 13"),
    new JsCodeNamesCard(14, "word 14"),
    new JsCodeNamesCard(15, "word 15"),
    new JsCodeNamesCard(16, "word 16"),
    new JsCodeNamesCard(17, "word 17"),
    new JsCodeNamesCard(18, "word 18"),
    new JsCodeNamesCard(19, "word 19"),
    new JsCodeNamesCard(20, "word 20"),
    new JsCodeNamesCard(21, "word 21"),
    new JsCodeNamesCard(22, "word 22"),
    new JsCodeNamesCard(23, "word 23"),
    new JsCodeNamesCard(24, "word 24"),
    new JsCodeNamesCard(25, "word 25"),
]

export function convertCards(cards: Array<JsCodeNamesCard>, keyCard: KeyCardModel | null) {
    return cards.map((card, index) => {
        return new GameCardModel(card, keyCard?.cards[index]!!, CardState.WORD)
        }
    )
}

export function initGame(
    keyCardSetter: (kc: KeyCardModel) => void,
    gameCardsSetter: (cards: Array<GameCardModel>) => void
) {
    axios.get("/keyCard/new").then((response) => {
        console.log(response)
        const keyCardCells = response.data as Array<number>
        const newKeyCard = new KeyCardModel(keyCardCells)
        keyCardSetter(newKeyCard)
        // TODO: call a server function to get new cards
        gameCardsSetter(convertCards(initCards, newKeyCard))
    })
}

function App() {
    let [gameState, gameStateSetter] = useState(GameState.START)
    let [keyCard, keyCardSetter] = useState<KeyCardModel | null>(null)
    let [gameCards, gameCardsSetter] = useState<Array<GameCardModel>>([])

    // Load initial data
    useEffect(() => {
        initGame(keyCardSetter, gameCardsSetter)
    }, []);

    return (<div className="App">
            <header className="App-header">
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

export default App;
