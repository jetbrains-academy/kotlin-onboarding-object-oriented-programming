import cards from "../../assets/Kotlin_Alias_cover.svg";
import {GameState} from "../GameScreen";

type StartScreenProps = {
    gameStateSetter: (gs: GameState) => void
}

export default function StartScreen({gameStateSetter}: StartScreenProps) {
    return (
        <div className="App-cards-container">
            <img src={cards} className="App-cards" alt="cards"/>
            <div className="App-buttons-container App-display-flex">
                <button className="App-button-base App-button-start" onClick={() => gameStateSetter(GameState.TEAMS)} >Start</button>
                <button className="App-button-base App-big-button App-button-no-bg App-top-margin-small" onClick={() => gameStateSetter(GameState.STAT)} >Previous games results</button>
            </div>
        </div>
    );
}
