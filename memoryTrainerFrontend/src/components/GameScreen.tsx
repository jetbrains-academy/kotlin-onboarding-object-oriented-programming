import StartScreen from "./screens/StartScreen";
import GameRoundScreen from "./screens/GameRoundScreen";
import React from "react";
import GameStatisticsScreen from "./screens/GameStatisticsScreen";
import {CardTrainerModel} from '../models/CardTrainer';

export enum GameState {
    START,
    GAME,
    GAME_STAT,
}

export type GameScreenProps = {
    state: GameState,
    gameStateSetter: (gs: GameState) => void,
    cardSetter: (card: CardTrainerModel) => void,
    currentCard: CardTrainerModel,
    wordSetter: (card: string) => void,
    currentWord: string,
    known: string[],
    knownSetter: (known:  string[]) => void,
    unknown: string[],
    unknownSetter: (known:  string[]) => void,
}

export default function GameScreen({
                                       state,
                                       gameStateSetter,
                                       cardSetter,
                                       currentCard,
                                       wordSetter,
                                       currentWord,
                                       known,
                                       knownSetter,
                                       unknown,
                                       unknownSetter
                                   }: GameScreenProps) {
    switch (state) {
        case GameState.START: {
            return <StartScreen
                gameStateSetter={gameStateSetter}
                cardSetter={cardSetter}
                wordSetter={wordSetter}
                knownSetter={knownSetter}
                unknownSetter={unknownSetter}
                currentWord={currentWord}
            />
        }
        case GameState.GAME: {
            return <GameRoundScreen
                gameStateSetter={gameStateSetter}
                cardSetter={cardSetter}
                currentCard={currentCard}
                wordSetter={wordSetter}
                currentWord={currentWord}
                known={known}
                knownSetter={knownSetter}
                unknown={unknown}
                unknownSetter={unknownSetter}
            />
        }
        case GameState.GAME_STAT: {
            return <GameStatisticsScreen
                gameStateSetter={gameStateSetter}
                known={known}
                unknown={unknown}
            />
        }
    }
}