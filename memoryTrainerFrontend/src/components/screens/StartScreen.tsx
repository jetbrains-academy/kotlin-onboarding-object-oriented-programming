import logo from "../../assets/logo.svg";
import {GameState} from "../GameScreen";
import {initGame} from "../../App";
import {card} from "common-types";
import JsCardTrainerModel = card.trainer.JsCardTrainerModel;

type StartScreenProps = {
    gameStateSetter: (gs: GameState) => void,
    knownSetter: (known: string[]) => void,
    unknownSetter: (known: string[]) => void,
    cardSetter: (card: JsCardTrainerModel) => void,
    wordSetter: (card: string) => void,
    currentWord: string,
}

export default function StartScreen({
                                        gameStateSetter,
                                        knownSetter,
                                        unknownSetter,
                                        cardSetter,
                                        wordSetter,
                                        currentWord
                                    }: StartScreenProps) {
    return (
        <div className="App-cards-container App-min-height">
            <img src={logo} className="App-covers" alt="covers"/>
            <p className="App-big-name font-link-bold">Memory Trainer</p>
            <p className="App-small-name font-link-base">by Kotlin Course</p>
            <div className="App-buttons-container App-display-flex">
                <button className="App-button-base App-button-start" onClick={() => {
                    initGame(knownSetter, unknownSetter, cardSetter, wordSetter)
                    if (currentWord != '') {
                        gameStateSetter(GameState.GAME)
                    }
                }
                }></button>
            </div>
        </div>
    );
}

