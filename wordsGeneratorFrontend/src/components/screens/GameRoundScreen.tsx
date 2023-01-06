import {GameState} from "../GameScreen";
import {SetStateAction, useState} from "react";

type GameRoundScreenProps = {
    gameStateSetter: (gs: GameState) => void
}

export default function GameRoundScreen({gameStateSetter}: GameRoundScreenProps) {
    function endGame() {
        // gameTeams.addPoints(roundPoints)
        // gameTeamsSetter(gameTeams)
        // gameStateSetter(GameState.END)
    }

    const [currentText, currentTextSetter] = useState('');
    const [updatedText, updatedTextSetter] = useState('');

    const handleChange = (event: { target: { value: SetStateAction<string>; }; }) => {
        currentTextSetter(event.target.value);
    };

    const handleKeyDown = (event: { key: string; }) => {
        if (event.key === 'Enter') {
            updatedTextSetter(currentText);
        }
    };

    // TODO: validate updatedText and show messages
    return (
        <div className="App-main-container">
            <p className="App-top-margin App-no-bottom-margin font-link-base App-game-word-p">
                Tetrahydrocanabinol
            </p>
            {/*<div className="App-input-container">*/}
            {/*    <input*/}
            {/*        type="text"*/}
            {/*        id="message"*/}
            {/*        name="message"*/}
            {/*        value={currentText}*/}
            {/*        defaultValue="Hello!"*/}
            {/*        onChange={handleChange}*/}
            {/*        onKeyDown={handleKeyDown}*/}
            {/*        className="App-input font-link-base"*/}
            {/*        placeholder="Input your word here.."*/}
            {/*    />*/}
            {/*    <p className="App-input-hint font-link-base">Please press Enter to check</p>*/}
            {/*</div>*/}

            <div className="App-input-container">
                <input
                    type="text"
                    id="message"
                    name="message"
                    value={currentText}
                    onChange={handleChange}
                    onKeyDown={handleKeyDown}
                    placeholder="Input your word here.."
                    className="App-input"
                />
                <div className="App-input-icon"></div>
                <p className="App-input-hint font-link-base">Please press Enter to check</p>
            </div>


            {/*<h2 className="font-link-base">Message: {currentText}</h2>*/}

            {/*<h2 className="font-link-base">Updated: {updatedText}</h2>*/}
            <div className="App-buttons-container App-teams-buttons-container">
                <button className="App-button-base App-game-button-base App-game-next-team-button"></button>
                <button className="App-button-base App-game-button-base App-game-new-round-button"></button>
                <button className="App-button-base App-game-button-base App-game-stat-button"></button>
                <button className="App-button-base App-game-button-base App-game-finish-button" onClick={
                    () => endGame()
                }></button>
            </div>
        </div>
    );
}
