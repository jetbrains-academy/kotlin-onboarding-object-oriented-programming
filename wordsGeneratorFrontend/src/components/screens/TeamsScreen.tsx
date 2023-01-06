import {GameState} from "../GameScreen";
import {useState} from "react";

type TeamsScreenProps = {
    gameStateSetter: (gs: GameState) => void
}

export default function TeamsScreen({gameStateSetter}: TeamsScreenProps) {
    const [teamsNumber, teamsNumberSettler] = useState(1);
    const baseClasses = "App-teams-p-number-border App-teams-p-number-border-small-padding-right"

    return (
        <div className="App-main-container">
            <p className="App-top-margin App-no-bottom-margin font-link-bold App-teams-p ">
                How many teams will play to the game?
            </p>
            <div className="App-teams-number-container">
                {/* eslint-disable-next-line eqeqeq */}
                <p className={teamsNumber === 1 ? baseClasses + " App-teams-p-number-border-active" : baseClasses} onClick={() => teamsNumberSettler(1)}>
                    <p className="App-teams-p-number font-link-base">One</p></p>
                <p className={teamsNumber === 2 ? baseClasses + " App-teams-p-number-border-active" : baseClasses} onClick={() => teamsNumberSettler(2)}>
                    <p className="App-teams-p-number font-link-base">Two</p></p>
                <p className={teamsNumber === 3 ? baseClasses + " App-teams-p-number-border-active" : baseClasses} onClick={() => teamsNumberSettler(3)}>
                    <p className="App-teams-p-number font-link-base">Three</p></p>
                <p className={teamsNumber === 4 ? baseClasses + " App-teams-p-number-border-active" : baseClasses} onClick={() => teamsNumberSettler(4)}>
                    <p className="App-teams-p-number font-link-base">Four</p></p>
            </div>
            <div className="App-buttons-container App-teams-buttons-container">
                <button className="App-button-base App-teams-button-base App-teams-button-back" onClick={() => gameStateSetter(GameState.START)}></button>
                <button className="App-button-base App-teams-button-base App-teams-button-next" onClick={() => gameStateSetter(GameState.GAME)}></button>
            </div>
        </div>
    );
}
