import {GameState} from "../GameScreen";
import {codenames} from "common-types";
import CodeNamesCard, {CardState} from "../Card";
import {KeyCardModel} from "../../models/KeyCard";
import JsCodeNamesCard = codenames.JsCodeNamesCard;

type GameRoundScreenProps = {
    gameStateSetter: (gs: GameState) => void
    keyCard: KeyCardModel
    cards: Array<JsCodeNamesCard>
    N: number

    keyCardSetter: (kc: KeyCardModel) => void
}

export default function GameRoundScreen({gameStateSetter, keyCard, cards, N, keyCardSetter}: GameRoundScreenProps) {
    return (
        <div className="App-container">
            <div className="App-cards-container">
                {
                    cards?.chunk(N)?.map((row: Array<JsCodeNamesCard> | null, i: number) => (
                        <div className="App-cards-container-row">
                            {
                                row?.map((card, j) => (
                                    <CodeNamesCard card={card} type={keyCard.cards[i * j]}
                                                   state={CardState.WORD}></CodeNamesCard>
                                ))
                            }
                        </div>
                    ))
                }
            </div>
            <div className="App-buttons-container">
                <button className="App-button-base App-button-start"
                        onClick={() => gameStateSetter(GameState.KEY_CARD)}>Show the key card
                </button>
                <button className="App-button-base App-button-start" onClick={() => {
                    keyCardSetter(new KeyCardModel())
                    // TODO: update cards
                    gameStateSetter(GameState.START)
                }
                }>Finish the game
                </button>
            </div>
        </div>
    )
}
