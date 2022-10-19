import cards from "../../assets/Kotlin_Alias_cover_teams.svg";
import {GameState} from "../GameScreen";
import {GameTeams} from "../../models/Team";
import axios from "axios";
import {alias} from "common-types";
import Team = alias.JsTeam;

type TeamsScreenProps = {
    gameStateSetter: (gs: GameState) => void
    gameTeamsSetter: (gt: GameTeams) => void
}

export default function TeamsScreen({gameStateSetter, gameTeamsSetter}: TeamsScreenProps) {
    function startGame(teamsNumber: number) {
        axios.post("/teams/generate", teamsNumber, {headers: {'Content-Type': 'application/json'}})
            .then((response) => {
                let teams = response.data as Array<Team>
                gameStateSetter(GameState.GAME)
                gameTeamsSetter(new GameTeams(teams.map((t) => new Team(t.id, t.points, t.name))))
            })
    }

    return (
        <div className="App-cards-container">
            <img src={cards} className="App-cards" alt="cards"/>
            <p className="App-top-margin App-no-bottom-margin">
                How many teams will play to the game?
            </p>
            <div className="App-buttons-container">
                <button className="App-button-base App-button-right-margin App-button-base-circle" onClick={() => {
                    startGame(1)
                }}>1
                </button>
                <button className="App-button-base App-button-base-circle App-button-right-margin" onClick={() => {
                    startGame(2)
                }}>2
                </button>
                <button className="App-button-base App-button-base-circle App-button-right-margin" onClick={() => {
                    startGame(3)
                }}>3
                </button>
                <button className="App-button-base App-button-base-circle" onClick={() => {
                    startGame(4)
                }}>4
                </button>
            </div>
        </div>
    );
}
