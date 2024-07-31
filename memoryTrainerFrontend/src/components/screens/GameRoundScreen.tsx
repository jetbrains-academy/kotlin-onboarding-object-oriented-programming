import {GameState} from "../GameScreen";
import {CardTrainerModel} from '../../models/CardTrainer';
import {initGame, newCard} from "../../App";
import Card from "../Card";
import axios from "axios";

type GameRoundScreenProps = {
    gameStateSetter: (gs: GameState) => void,
    cardSetter: (card: CardTrainerModel) => void,
    currentCard: CardTrainerModel,
    wordSetter: (card: string) => void,
    currentWord: string,
    known: string[],
    knownSetter: (known: string[]) => void,
    unknown: string[],
    unknownSetter: (known: string[]) => void,
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
    function saveResults() {
        let body = {
            known: known,
            unknown: unknown,
        }
        axios.post("/stat/save", body).then((response) => {
            console.log("Stat was saved!")
            console.log(response)
            initGame(knownSetter, unknownSetter, cardSetter, wordSetter)
            gameStateSetter(GameState.START)
        })
    }

    return (
        <div className="App-cards-container App-min-height">
            <Card
                currentCard={currentCard}
                wordSetter={wordSetter}
                currentWord={currentWord}
            />
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
                    saveResults()
                }}>
                </button>
            </div>
        </div>
    );
}
