import {GameState} from "../GameScreen";
import {KeyCardModel} from "../../models/KeyCard";
import KeyCard from "../KeyCard";

type KeyCardScreenProps = {
    gameStateSetter: (gs: GameState) => void
    keyCard: KeyCardModel
    N: number
}

export default function KeyCardScreen({gameStateSetter, keyCard, N}: KeyCardScreenProps) {
    return (<div className="App-container">
        <KeyCard keyCard={keyCard} N={N}></KeyCard>
        <div className="App-buttons-container App-display-flex">
            <button className="App-button-base" onClick={() => gameStateSetter(GameState.GAME)}>Hide the key card
            </button>
        </div>
    </div>)
}