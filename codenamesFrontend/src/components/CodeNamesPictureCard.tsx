import {KeyCardType} from "../models/KeyCard";

type CodeNamesPictureProps = {
    cardType: KeyCardType
}

export default function CodeNamesPictureCard({cardType}: CodeNamesPictureProps) {
    switch (cardType) {
        case KeyCardType.PINK:
            return (<div className="App-card-container-base App-card-container-pink">
                <div></div>
            </div>)
        case KeyCardType.VIOLET:
            return (<div className="App-card-container-base App-card-container-violet">
                <div></div>
            </div>)
        case KeyCardType.GRAY:
            return (<div className="App-card-container-base App-card-container-gray">
                <div></div>
            </div>)
        case KeyCardType.BLACK:
            return (<div className="App-card-container-base App-card-container-black">
                <div></div>
            </div>)
    }
}