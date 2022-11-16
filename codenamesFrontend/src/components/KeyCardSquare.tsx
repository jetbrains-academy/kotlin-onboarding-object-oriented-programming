import {KeyCardType} from "../models/KeyCard";
import pinkSquare from "../assets/pink_square.svg";
import violetSquare from "../assets/violet_square.svg";
import graySquare from "../assets/gray_square.svg";
import blackSquare from "../assets/black_square.svg";

type KeyCardSquareProps = {
    cardType: KeyCardType
}

export default function KeyCardSquare({cardType}: KeyCardSquareProps) {
    switch (cardType) {
        case KeyCardType.PINK:
            return <img src={pinkSquare} className="App-key-card-square" alt="pink"/>
        case KeyCardType.VIOLET:
            return <img src={violetSquare} className="App-key-card-square" alt="violet"/>
        case KeyCardType.GRAY:
            return <img src={graySquare} className="App-key-card-square" alt="gray"/>
        case KeyCardType.BLACK:
            return <img src={blackSquare} className="App-key-card-square" alt="black"/>
    }
}