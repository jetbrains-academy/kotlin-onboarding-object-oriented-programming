package jetbrains.kotlin.course.codenames.card

interface CardData
data class WordCardData(val word: String): CardData

enum class CardState {
    Front,
    Back,
}

data class Card(
    val data: CardData,
    val state: CardState,
)
