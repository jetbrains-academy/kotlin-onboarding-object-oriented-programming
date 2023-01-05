import {GameState} from "../GameScreen";
import {CardState, GameCardModel} from "../../models/GameCard";
import {GRAY_CARDS_NUMBER, KeyCardType, PINK_CARDS_NUMBER, VIOLET_CARDS_NUMBER} from "../../models/KeyCard";
import GameStatisticsItemScreen from "../GameStatisticsItem";

type GameStatisticsProps = {
    gameStateSetter: (gs: GameState) => void
    gameCards: Array<GameCardModel>
}

function currentAmount(gameCards: Array<GameCardModel>, type: KeyCardType) {
    return gameCards.filter(function(element){
        return element.type === type && element.state === CardState.PICTURE;
    }).length
}

export default function GameStatisticsScreen({gameStateSetter, gameCards}: GameStatisticsProps) {
    return (
        <div className="App-container App-min-height">
            <h3 className="App-game-stat font-link-base">
                Game statistics
            </h3>
            <div className="App-game-stat-container">
                <GameStatisticsItemScreen
                    cardType={KeyCardType.VIOLET}
                    all={VIOLET_CARDS_NUMBER}
                    current={currentAmount(gameCards, KeyCardType.VIOLET)}
                />
                <GameStatisticsItemScreen
                    cardType={KeyCardType.PINK}
                    all={PINK_CARDS_NUMBER}
                    current={currentAmount(gameCards, KeyCardType.PINK)}
                />
            </div>
            <div className="App-game-stat-container">
                <GameStatisticsItemScreen
                    cardType={KeyCardType.GRAY}
                    all={GRAY_CARDS_NUMBER}
                    current={currentAmount(gameCards, KeyCardType.GRAY)}
                />
                <GameStatisticsItemScreen
                    cardType={KeyCardType.BLACK}
                    all={1}
                    current={currentAmount(gameCards, KeyCardType.BLACK)}
                />
            </div>
            <div className="App-buttons-container">
                <button className="App-button-base App-back-button"
                        onClick={() => gameStateSetter(GameState.GAME)}>
                </button>
            </div>
        </div>
    )
}

