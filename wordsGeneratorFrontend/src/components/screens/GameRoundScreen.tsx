import {GameState} from "../GameScreen";
import {SetStateAction, useEffect, useState} from "react";
import {GameTeams} from "../../models/Team";
import axios from "axios";

type GameRoundScreenProps = {
    gameStateSetter: (gs: GameState) => void
    gameTeamsSetter: (gt: GameTeams) => void
    gameTeams: GameTeams
}

type WordState = {
    index: number;
    word: String | null;
}

const initialHelp = 'Please press Enter to check'

export default function GameRoundScreen({gameStateSetter, gameTeams, gameTeamsSetter}: GameRoundScreenProps) {
    let [currentWordState, wordSetter] = useState<WordState>({index: -1, word: null})
    let [maxIndex, maxIndexSetter] = useState<number>(-1)
    let [roundPoints, roundPointsSetter] = useState<number>(0)

    // TODO: check the previous attempts??
    let [helpText, helpTextSetter] = useState(initialHelp)

    function nextWord() {
        if (maxIndex != null && currentWordState.index < maxIndex) {
            axios.get(`/words/next`).then((response) => {
                let newWord = response.data as String
                wordSetter({index: currentWordState.index + 1, word: newWord})
            })
        }
        if (currentWordState.index >= maxIndex) {
            endGame()
        }
    }

    // Load initial data
    useEffect(() => {
        axios.get("/words/amount").then((response) => {
            maxIndex = response.data as number;
            maxIndexSetter(maxIndex)
            nextWord();
        })
    }, []);

    function endGame() {
        gameTeams.addPoints(roundPoints)
        gameTeamsSetter(gameTeams)
        gameStateSetter(GameState.END)
    }

    function updateInput() {
        nextWord()
        roundPointsSetter(0)
        updatedTextSetter('')
        currentTextSetter('')
        helpTextSetter(initialHelp)
    }

    const [currentText, currentTextSetter] = useState('');
    const [updatedText, updatedTextSetter] = useState('');

    const handleChange = (event: { target: { value: SetStateAction<string>; }; }) => {
        currentTextSetter(event.target.value);
    };

    const handleKeyDown = (event: { key: string; }) => {
        if (event.key === 'Enter') {
            updatedTextSetter(currentText);
            axios.get(`/words/valid?keyWord=${currentWordState.word}&newWord=${currentText}`).then((response) => {
                let isValid = response.data as Boolean
                if (isValid) {
                    roundPointsSetter(roundPoints + 1)
                    helpTextSetter('Hooray! Correct word!')
                } else {
                    if (roundPoints - 1 < 0) {
                        roundPointsSetter(0)
                    } else {
                        roundPointsSetter(roundPoints - 1)
                    }
                    helpTextSetter('Sorry this word is wrong :(')
                }
                console.log(isValid)
            })
        }
    };

    // TODO: validate updatedText and show messages
    return (
        <div className="App-main-container">
            <p className="App-game-current-team font-link-base">
                Current team: {gameTeams.teams[gameTeams.currentTeamIndex].name}
            </p>

            <p className="App-top-margin App-no-bottom-margin font-link-base App-game-word-p">
                {currentWordState.word}
            </p>

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
                <p className="App-input-hint font-link-base">{helpText}</p>
            </div>

            <div className="App-buttons-container App-teams-buttons-container">
                <button className="App-button-base App-game-button-base App-game-next-team-button" onClick={
                    () => {
                        gameTeams.nextTeam(roundPoints)
                        updateInput()
                    }
                }
                ></button>
                <button className="App-button-base App-game-button-base App-game-new-round-button" onClick={
                    () => {
                        gameTeams.addPoints(roundPoints)
                        updateInput()
                    }
                }></button>
                {/*<button className="App-button-base App-game-button-base App-game-stat-button" onClick={() => gameStateSetter(GameState.STAT)}></button>*/}
                <button className="App-button-base App-game-button-base App-game-finish-button" onClick={
                    () => endGame()
                }></button>
            </div>
        </div>
    );
}
