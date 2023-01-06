import StartScreen from "./screens/StartScreen";
import TeamsScreen from "./screens/TeamsScreen";
import GameRoundScreen from "./screens/GameRoundScreen";
import React, {useState} from "react";
import {GameTeams} from "../models/Team";
import PreviousGamesScreen from "./screens/PreviousGamesScreen";
import EndScreen from "./screens/EndScreen";

export enum GameState {
    START,
    TEAMS,
    GAME,
    STAT,
    END,
}

export type GameScreenProps = {
    state: GameState,
    gameStateSetter: (gs: GameState) => void,
}

export default function GameScreen({state, gameStateSetter}: GameScreenProps) {
    let [gameTeams, gameTeamsSetter] = useState<GameTeams>(new GameTeams([]))
    switch (state) {
        case GameState.START: {
            return <StartScreen gameStateSetter={gameStateSetter}/>
        }
        case GameState.TEAMS: {
            return <TeamsScreen gameStateSetter={gameStateSetter} gameTeamsSetter={gameTeamsSetter}/>
        }
        case GameState.GAME: {
            return <GameRoundScreen gameStateSetter={gameStateSetter}
                                    gameTeams={gameTeams}
                                    gameTeamsSetter={gameTeamsSetter}/>
        }
        case GameState.STAT: {
            return <PreviousGamesScreen gameStateSetter={gameStateSetter}/>
        }
        case GameState.END: {
            return <EndScreen gameStateSetter={gameStateSetter} gameTeams={gameTeams}/>
        }
    }
}
