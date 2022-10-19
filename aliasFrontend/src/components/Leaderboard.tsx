import {alias} from "common-types";
import Team = alias.JsTeam;

type LeaderboardProps = {
    teams: Array<Team>
}

export default function Leaderboard({teams}: LeaderboardProps) {
    return (<div className="App-container">
        <h3>
            The leaderboard:
        </h3>
        <div className="App-container App-container-min-height">
            {
                teams.map((team, index) => (
                    <p key={team.id + 1} className="App-no-top-margin">
                        {index + 1} place: {team.name} ({team.points} points)
                    </p>
                ))
            }
        </div>
    </div>)
}