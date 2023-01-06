import StartScreen from "./screens/StartScreen";
import TeamsScreen from "./screens/TeamsScreen";
import GameRoundScreen from "./screens/GameRoundScreen";

export enum GameState {
    START,
    TEAMS,
    GAME,
    // END,
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
        case GameState.GAME: {
            return <GameRoundScreen gameStateSetter={gameStateSetter}/>
        }
    }
}
