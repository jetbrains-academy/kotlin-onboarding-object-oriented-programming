import {GameState} from "../GameScreen";
import {KeyCardModel} from "../../models/KeyCard";
import {GameCardModel} from "../../models/GameCard";
import CodeNamesCard from "../Card";
import {initGame} from "../../App";

type GameRoundScreenProps = {
    gameStateSetter: (gs: GameState) => void
    gameCards: Array<GameCardModel>
    N: number

    keyCardSetter: (kc: KeyCardModel) => void
    gameCardsSetter: (cards: Array<GameCardModel>) => void
}

let id = 0

export default function GameRoundScreen({
                                            gameStateSetter,
                                            gameCards,
                                            N,
                                            keyCardSetter,
                                            gameCardsSetter
                                        }: GameRoundScreenProps) {
    return (<div className="App-container App-min-height">
            <div className="App-cards-container App-flex-direction-row">
                {gameCards?.chunk(N)?.map((row: Array<GameCardModel> | null, i: number) => (
                    <div className="App-cards-container-row" key={"Key:" + id++}>
                        {row?.map((card, j) => (<CodeNamesCard
                                gameCard={card}
                                gameCardsSetter={gameCardsSetter}
                                gameCards={gameCards}
                                index={i * N + j}
                                key={"Row:" + i + "Column:" + j}
                            />))}
                    </div>))}
            </div>
            <div className="App-buttons-container">
                <button className="App-button-base App-game-show-key-card"
                        onClick={() => gameStateSetter(GameState.KEY_CARD)}>
                </button>
                <button className="App-button-base App-game-finish-game" onClick={() => {
                    initGame(keyCardSetter, gameCardsSetter)
                    gameStateSetter(GameState.START)
                }}>
                </button>
                <button className="App-button-base App-game-stats" onClick={() => {
                    gameStateSetter(GameState.GAME_STAT)
                }}>
                </button>
            </div>
        </div>)
}
