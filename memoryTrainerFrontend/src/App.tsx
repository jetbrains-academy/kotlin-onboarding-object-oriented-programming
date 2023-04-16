import './App.css';
import './util/util'
import {useEffect, useState} from "react";
import GameScreen, {GameState} from "./components/GameScreen";
import axios from "axios";
import {card} from "common-types";
import JsCardTrainerModel = card.trainer.JsCardTrainerModel;

export function newCard(
    cardSetter: (card: JsCardTrainerModel) => void,
    wordSetter: (card: string) => void,
    path: string = "/cards/next"
) {
    axios.get(path).then((response) => {
        let newCard = response.data as JsCardTrainerModel
        cardSetter(newCard)
        wordSetter(newCard.back)
    })
}

export function initGame(
    knownSetter: (known:  string[]) => void,
    unknownSetter: (unknown:  string[]) => void,
    cardSetter: (card: JsCardTrainerModel) => void,
    wordSetter: (card: string) => void,
) {
    knownSetter([])
    unknownSetter([])
    newCard(cardSetter, wordSetter, "/cards/newGame")
}

function App() {
    let [gameState, gameStateSetter] = useState(GameState.START)
    let [currentCard, cardSetter] = useState<JsCardTrainerModel>(new JsCardTrainerModel(-1, "", ""))
    let [currentWord, wordSetter] = useState<string>(currentCard.back)

    let [known, knownSetter] = useState<string[]>([])
    let [unknown, unknownSetter] = useState<string[]>([])

    switch (gameState) {
        case GameState.START: {
            return (<div className="App">
                <header className="App-header-base App-header-black">
                    <GameScreen state={gameState}
                                gameStateSetter={gameStateSetter}
                                cardSetter={cardSetter}
                                currentCard={currentCard}
                                wordSetter={wordSetter}
                                currentWord={currentWord}
                                known={known}
                                knownSetter={knownSetter}
                                unknown={unknown}
                                unknownSetter={unknownSetter}
                    />
                </header>
            </div>);
        }
        default: {
            return (<div className="App">
                <header className="App-header-base App-header-white">
                    <GameScreen state={gameState}
                                gameStateSetter={gameStateSetter}
                                cardSetter={cardSetter}
                                currentCard={currentCard}
                                wordSetter={wordSetter}
                                currentWord={currentWord}
                                known={known}
                                knownSetter={knownSetter}
                                unknown={unknown}
                                unknownSetter={unknownSetter}
                    />
                </header>
            </div>);
        }
    }
}

export default App;
