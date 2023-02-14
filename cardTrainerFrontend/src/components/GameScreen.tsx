import StartScreen from "./screens/StartScreen";
import GameRoundScreen from "./screens/GameRoundScreen";

export enum GameState {
    START,
    GAME,
    // KEY_CARD,
    // GAME_STAT,
}

export type GameScreenProps = {
    state: GameState,
    gameStateSetter: (gs: GameState) => void,
}

export default function GameScreen({
                                       state,
                                       gameStateSetter,
                                   }: GameScreenProps) {
    switch (state) {
        case GameState.START: {
            return <StartScreen gameStateSetter={gameStateSetter}/>
        }
        case GameState.GAME: {
            return <GameRoundScreen
                gameStateSetter={gameStateSetter}
            />
        }
        // case GameState.KEY_CARD: {
        //     return <KeyCardScreen gameStateSetter={gameStateSetter} keyCard={keyCard} N={N}/>
        // }
        // case GameState.GAME_STAT: {
        //     return <GameStatisticsScreen gameStateSetter={gameStateSetter} gameCards={gameCards}/>
        // }
    }
}