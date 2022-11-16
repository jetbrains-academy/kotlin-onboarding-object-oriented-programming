package jetbrains.kotlin.course.codenames.card

import jetbrains.kotlin.course.codenames.utils.Identifier

@JvmInline
value class Word(val word: String)

enum class CardState {
    Word,
    Picture,
}

data class Card(
    val id: Identifier,
    val word: Word,
    val state: CardState,
)