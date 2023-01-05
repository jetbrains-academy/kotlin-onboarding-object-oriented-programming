import {KeyCardType} from "../models/KeyCard";

type KeyCardSquareProps = {
    cardType: KeyCardType
}

export default function KeyCardSquare({cardType}: KeyCardSquareProps) {
    switch (cardType) {
        case KeyCardType.PINK:
            return <div className="App-key-card-square App-key-card-square-pink"/>
        case KeyCardType.VIOLET:
            return <div className="App-key-card-square App-key-card-square-violet"/>
        case KeyCardType.GRAY:
            return <div className="App-key-card-square App-key-card-square-gray"/>
        case KeyCardType.BLACK:
            return <div className="App-key-card-square App-key-card-square-black"/>
    }
}