import {GameState} from "../GameScreen";
import {useState} from "react";
import {card} from "common-types";
import JsCardTrainerModel = card.trainer.JsCardTrainerModel;

type GameRoundScreenProps = {
    gameStateSetter: (gs: GameState) => void
}

export default function GameRoundScreen({gameStateSetter}: GameRoundScreenProps) {
    let [currentCard, cardSetter] = useState<JsCardTrainerModel>(new JsCardTrainerModel(-1, "London", "United\nKingdom"))
    let [currentWord, wordSetter] = useState<String>(currentCard.back)

    return (
        <div className="App-cards-container App-min-height">
            <div className="App-card" onClick={() => {
                if (currentCard.back === currentWord) {
                    wordSetter(currentCard.front)
                } else if (currentCard.front === currentWord) {
                    wordSetter(currentCard.back)
                }
            }}>
                <p className="App-card-p font-link-base"><pre className="font-link-base App-card-pre">{currentWord}</pre></p>
            </div>
            <div className="App-buttons-container">
                <button className="App-button-base App-game-dont-know" onClick={() => {
                    // gameStateSetter(GameState.GAME_STAT)
                }}>
                </button>
                <button className="App-button-base App-game-know" onClick={() => {
                    // initGame(keyCardSetter, gameCardsSetter)
                }}>
                </button>
            </div>
            <div className="App-buttons-container">
                <button className="App-button-base App-game-stats" onClick={() => {
                    // gameStateSetter(GameState.GAME_STAT)
                }}>
                </button>
                <button className="App-button-base App-game-finish-game" onClick={() => {
                    // initGame(keyCardSetter, gameCardsSetter)
                    gameStateSetter(GameState.START)
                }}>
                </button>
            </div>
        </div>
    );
}
