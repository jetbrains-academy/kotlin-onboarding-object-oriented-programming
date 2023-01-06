import StartScreen from "./screens/StartScreen";
import TeamsScreen from "./screens/TeamsScreen";

export enum GameState {
    START,
    TEAMS,
}

export type GameScreenProps = {
    state: GameState,
    gameStateSetter: (gs: GameState) => void,
}

export default function GameScreen({state, gameStateSetter}: GameScreenProps) {
    switch (state) {
        case GameState.START: {
            return <StartScreen gameStateSetter={gameStateSetter}/>
        }
        case GameState.TEAMS: {
            return <TeamsScreen gameStateSetter={gameStateSetter}/>
        }
    }
}
