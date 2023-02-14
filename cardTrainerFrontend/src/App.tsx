import './App.css';
import './util/util'
import {useEffect, useState} from "react";
import GameScreen, {GameState} from "./components/GameScreen";
import axios from "axios";
import {card} from "common-types";
import JsCardTrainerModel = card.trainer.JsCardTrainerModel;

export function newCard(
    cardSetter: (card: JsCardTrainerModel) => void,
    wordSetter: (card: String) => void,
    path: string = "/cards/next"
) {
    axios.get(path).then((response) => {
        let newCard = response.data as JsCardTrainerModel
        cardSetter(newCard)
        wordSetter(newCard.back)
    })
}

export function initGame(
    knownSetter: (known:  String[]) => void,
    unknownSetter: (unknown:  String[]) => void,
    cardSetter: (card: JsCardTrainerModel) => void,
    wordSetter: (card: String) => void
) {
    knownSetter([])
    unknownSetter([])
    newCard(cardSetter, wordSetter, "/cards/newGame")
}

function App() {
    let [gameState, gameStateSetter] = useState(GameState.START)
    let [currentCard, cardSetter] = useState<JsCardTrainerModel>(new JsCardTrainerModel(-1, "", ""))
    let [currentWord, wordSetter] = useState<String>(currentCard.back)

    let [known, knownSetter] = useState<String[]>([])
    let [unknown, unknownSetter] = useState<String[]>([])

    // Load initial data
    useEffect(() => {
        initGame(knownSetter, unknownSetter, cardSetter, wordSetter)
    }, []);

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
