import {GameState} from "../GameScreen";
import {card} from "common-types";
import JsCardTrainerModel = card.trainer.JsCardTrainerModel;
import {initGame, newCard} from "../../App";

type GameRoundScreenProps = {
    gameStateSetter: (gs: GameState) => void,
    cardSetter: (card: JsCardTrainerModel) => void,
    currentCard: JsCardTrainerModel,
    wordSetter: (card: String) => void,
    currentWord: String,
    known: String[],
    knownSetter: (known: String[]) => void,
    unknown: String[],
    unknownSetter: (known: String[]) => void,
}

export default function GameRoundScreen({
                                            gameStateSetter,
                                            cardSetter,
                                            currentCard,
                                            wordSetter,
                                            currentWord,
                                            known,
                                            knownSetter,
                                            unknown,
                                            unknownSetter
                                        }: GameRoundScreenProps) {
    return (
        <div className="App-cards-container App-min-height">
            <div className="App-card" onClick={() => {
                if (currentCard.back === currentWord) {
                    wordSetter(currentCard.front)
                } else if (currentCard.front === currentWord) {
                    wordSetter(currentCard.back)
                }
            }}>
                <p className="App-card-p font-link-base">
                    <pre className="font-link-base App-card-pre">{currentWord}</pre>
                </p>
            </div>
            <div className="App-buttons-container">
                <button className="App-button-base App-game-dont-know" onClick={() => {
                    unknown.push(currentCard.back)
                    unknownSetter(unknown)
                    newCard(cardSetter, wordSetter)
                }}>
                </button>
                <button className="App-button-base App-game-know" onClick={() => {
                    known.push(currentCard.back)
                    knownSetter(known)
                    newCard(cardSetter, wordSetter)
                }}>
                </button>
            </div>
            <div className="App-buttons-container">
                <button className="App-button-base App-game-stats" onClick={() => {
                    gameStateSetter(GameState.GAME_STAT)
                }}>
                </button>
                <button className="App-button-base App-game-finish-game" onClick={() => {
                    initGame(knownSetter, unknownSetter, cardSetter, wordSetter)
                    gameStateSetter(GameState.START)
                }}>
                </button>
            </div>
        </div>
    );
}
