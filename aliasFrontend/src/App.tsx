import './App.css';
import './util/util'
import {useState} from "react";
import GameScreen, {GameState} from "./components/GameScreen";

function App() {
    let [gameState, gameStateSetter] = useState(GameState.START)

    return (<div className="App">
            <header className="App-header">
                <GameScreen state={gameState}
                            gameStateSetter={gameStateSetter}
                />
            </header>
        </div>);
}

export default App;
