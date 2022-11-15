import {useState} from "react";
import StartScreen from "./screens/StartScreen";
import GameRoundScreen from "./screens/GameRoundScreen";
import {KeyCardModel} from "../models/KeyCard";
import {codenames} from "common-types";
import JsCodeNamesCard = codenames.JsCodeNamesCard;
import KeyCardScreen from "./screens/KeyCardScreen";

export enum GameState {
    START,
    GAME,
    KEY_CARD,
}

export type GameScreenProps = {
    state: GameState,
    gameStateSetter: (gs: GameState) => void,
    keyCard: KeyCardModel,
    cards: Array<JsCodeNamesCard>,
    N: number,

    keyCardSetter: (kc: KeyCardModel) => void,
}

export default function GameScreen({state, gameStateSetter, keyCard, cards, N, keyCardSetter}: GameScreenProps) {
    switch (state) {
        case GameState.START: {
            return <StartScreen gameStateSetter={gameStateSetter}/>
        }
        case GameState.GAME: {
            return <GameRoundScreen
                gameStateSetter={gameStateSetter}
                keyCard={keyCard}
                cards={cards}
                N={N}
                keyCardSetter={keyCardSetter}
            />
        }
        case GameState.KEY_CARD: {
            return <KeyCardScreen gameStateSetter={gameStateSetter} keyCard={keyCard} N={N}/>
        }
    }
}