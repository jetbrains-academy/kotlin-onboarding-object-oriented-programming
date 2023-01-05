import {GameState} from "../GameScreen";
import {KeyCardModel} from "../../models/KeyCard";
import KeyCard from "../KeyCard";

type KeyCardScreenProps = {
    gameStateSetter: (gs: GameState) => void
    keyCard: KeyCardModel | null
    N: number
}

export default function KeyCardScreen({gameStateSetter, keyCard, N}: KeyCardScreenProps) {
    return (<div className="App-container App-min-height">
        <KeyCard keyCard={keyCard} N={N}></KeyCard>
        <div className="App-buttons-container App-display-flex">
            <button className="App-button-base App-back-button" onClick={() => gameStateSetter(GameState.GAME)}>
            </button>
        </div>
    </div>)
}