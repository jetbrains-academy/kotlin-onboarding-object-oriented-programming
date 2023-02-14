import './App.css';
import './util/util'
import {useEffect, useState} from "react";
import GameScreen, {GameState} from "./components/GameScreen";
import axios from "axios";

function App() {
    let [gameState, gameStateSetter] = useState(GameState.START)
    // let [keyCard, keyCardSetter] = useState<KeyCardModel | null>(null)
    // let [gameCards, gameCardsSetter] = useState<Array<GameCardModel>>([])
    //
    // // Load initial data
    // useEffect(() => {
    //     initGame(keyCardSetter, gameCardsSetter)
    // }, []);

    switch (gameState) {
        case GameState.START: {
            return (<div className="App">
                <header className="App-header-base App-header-black">
                    <GameScreen state={gameState}
                                gameStateSetter={gameStateSetter}
                    />
                </header>
            </div>);
        }
        default: {
            return (<div className="App">
                <header className="App-header-base App-header-white">
                    <GameScreen state={gameState}
                                gameStateSetter={gameStateSetter}
                    />
                </header>
            </div>);
        }
    }
}

export default App;
