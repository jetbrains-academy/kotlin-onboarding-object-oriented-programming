export enum KeyCardType {
    PINK, // 8
    VIOLET, // 9
    GRAY, // 7
    BLACK, // 1
}

export const PINK_CARDS_NUMBER = 8
export const VIOLET_CARDS_NUMBER = 9
export const GRAY_CARDS_NUMBER = 7

export class KeyCardModel {
    cards: Array<KeyCardType>

    constructor(keyCardCells: Array<number>) {
        this.cards = keyCardCells.map((key, index) => {
            switch (key) {
                case 0: return KeyCardType.PINK;
                case 1: return KeyCardType.VIOLET;
                case 2: return KeyCardType.GRAY;
                case 3: return KeyCardType.BLACK;
            }
            return KeyCardType.BLACK
        })
    }
}