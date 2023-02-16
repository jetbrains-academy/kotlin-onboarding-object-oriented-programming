import logo from "../../assets/logo.svg";
import {GameState} from "../GameScreen";
import {initGame} from "../../App";
import {KeyCardModel} from "../../models/KeyCard";
import {GameCardModel} from "../../models/GameCard";

type StartScreenProps = {
    gameStateSetter: (gs: GameState) => void,
    keyCardSetter: (kc: KeyCardModel) => void,
    gameCardsSetter: (cards: Array<GameCardModel>) => void,
    keyCard: KeyCardModel | null
}

export default function StartScreen({gameStateSetter, keyCardSetter, gameCardsSetter, keyCard}: StartScreenProps) {
    return (
        <div className="App-cards-container App-min-height">
            <img src={logo} className="App-covers" alt="covers"/>
            <p className="App-big-name font-link-bold">Codenames</p>
            <p className="App-small-name font-link-base">by Kotlin Course</p>
            <div className="App-buttons-container App-display-flex">
                <button className="App-button-base App-button-start" onClick={() => {
                    initGame(keyCardSetter, gameCardsSetter)
                    if (keyCard != null) {
                        gameStateSetter(GameState.GAME)
                    }
                }
                }></button>
            </div>
        </div>
    );
}

