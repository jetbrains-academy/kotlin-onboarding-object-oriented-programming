import StartScreen from "./screens/StartScreen";
import GameRoundScreen from "./screens/GameRoundScreen";
import {KeyCardModel} from "../models/KeyCard";
import KeyCardScreen from "./screens/KeyCardScreen";
import {GameCardModel} from "../models/GameCard";
import GameStatisticsScreen from "./screens/GameStatisticsScreen";

export enum GameState {
    START,
    GAME,
    KEY_CARD,
    GAME_STAT,
}

export type GameScreenProps = {
    state: GameState,
    gameStateSetter: (gs: GameState) => void,
    keyCard: KeyCardModel | null,
    gameCards: Array<GameCardModel>,
    N: number,

    keyCardSetter: (kc: KeyCardModel) => void,
    gameCardsSetter: (cards: Array<GameCardModel>) => void,
}

export default function GameScreen({
                                       state,
                                       gameStateSetter,
                                       keyCard,
                                       gameCards,
                                       N,
                                       keyCardSetter,
                                       gameCardsSetter
                                   }: GameScreenProps) {
    switch (state) {
        case GameState.START: {
            return <StartScreen
                gameStateSetter={gameStateSetter}
                keyCardSetter={keyCardSetter}
                gameCardsSetter={gameCardsSetter}
                keyCard={keyCard}
            />
        }
        case GameState.GAME: {
            return <GameRoundScreen
                gameStateSetter={gameStateSetter}
                gameCards={gameCards}
                N={N}
                keyCardSetter={keyCardSetter}
                gameCardsSetter={gameCardsSetter}
            />
        }
        case GameState.KEY_CARD: {
            return <KeyCardScreen gameStateSetter={gameStateSetter} keyCard={keyCard} N={N}/>
        }
        case GameState.GAME_STAT: {
            return <GameStatisticsScreen gameStateSetter={gameStateSetter} gameCards={gameCards}/>
        }
    }
}