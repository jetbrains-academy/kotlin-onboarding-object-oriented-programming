import {GameState} from "../GameScreen";
import StatColumn from "../StatColumn";

type GameStatisticsProps = {
    gameStateSetter: (gs: GameState) => void,
    known: String[],
    unknown: String[],
}

export default function GameStatisticsScreen({gameStateSetter, known, unknown}: GameStatisticsProps) {
    if (known.length === 0 && unknown.length === 0) {
        return (
            <div className="App-container App-min-height">
                <h3 className="App-game-stat font-link-base">
                    Game statistics
                </h3>
                <p className="font-link-base App-game-stat-column-p">You have not tried to guess capitals :(</p>

                <div className="App-buttons-container">
                    <button className="App-button-base App-back-button"
                            onClick={() => gameStateSetter(GameState.GAME)}>
                    </button>
                </div>
            </div>
        )
    }
    return (
        <div className="App-container App-min-height">
            <h3 className="App-game-stat font-link-base">
                Game statistics
            </h3>
            <div className="App-game-stat-container">
                <StatColumn
                    words={unknown}
                    title={"I don't know"}
                />
                <StatColumn
                    words={known}
                    title={"I know"}
                />
            </div>

            <div className="App-buttons-container">
                <button className="App-button-base App-back-button"
                        onClick={() => gameStateSetter(GameState.GAME)}>
                </button>
            </div>
        </div>
    )
}

