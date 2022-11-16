import {GameState} from "../GameScreen";
import {KeyCardModel} from "../../models/KeyCard";
import {GameCardModel} from "../../models/GameCard";
import CodeNamesCard from "../Card";
import {convertCards, initCards} from "../../App";

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
    return (<div className="App-container">
            <div className="App-cards-container">
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
                <button className="App-button-base App-button-start App-button-no-bg"
                        onClick={() => gameStateSetter(GameState.KEY_CARD)}>Show the key card
                </button>
                <button className="App-button-base App-button-start App-button-no-bg" onClick={() => {
                    gameStateSetter(GameState.GAME_STAT)
                }}>Show game statistics
                </button>
            </div>
        <div className="App-buttons-container">
            <button className="App-button-base App-button-start App-no-top-margin" onClick={() => {
                const newKeyCard = new KeyCardModel()
                keyCardSetter(newKeyCard)
                gameStateSetter(GameState.START)
                // TODO: call a server function to get new cards
                gameCardsSetter(convertCards(initCards, newKeyCard))
            }}>Finish the game
            </button>
        </div>
        </div>)
}
