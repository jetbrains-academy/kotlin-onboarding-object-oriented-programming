import {GameState} from "../GameScreen";

type StartScreenProps = {
    gameStateSetter: (gs: GameState) => void
}

export default function StartScreen({gameStateSetter}: StartScreenProps) {
    return (
        <div className="App-container">
            {/*<img src={cards} className="App-cards" alt="cards"/>*/}
            <div className="App-buttons-container App-display-flex">
                <button className="App-button-base App-button-start" onClick={() => gameStateSetter(GameState.GAME)} >Start</button>
            </div>
        </div>
    );
}

