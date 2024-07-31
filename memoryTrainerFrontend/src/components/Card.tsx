import {CardTrainerModel} from '../models/CardTrainer';

type CardProps = {
    currentCard: CardTrainerModel,
    wordSetter: (card: string) => void,
    currentWord: string,
}

export default function Card({currentCard, wordSetter, currentWord}: CardProps) {
    function changeWord() {
        if (currentCard.back === currentWord) {
            wordSetter(currentCard.front)
        } else if (currentCard.front === currentWord) {
            wordSetter(currentCard.back)
        }
    }

    let classNames = currentCard.back === currentWord ? "App-card" : "App-card App-card-front"
    return(
        <div className={classNames} onClick={() => { changeWord() }}>
            <p className="App-card-p font-link-base">
                <pre className="font-link-base App-card-pre">{currentWord}</pre>
            </p>
        </div>
    )
}