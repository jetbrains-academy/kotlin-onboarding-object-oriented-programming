package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.Identifier

@JvmInline
value class Word(val word: String)

data class Card(
    val id: Identifier,
    val words: List<Word>
)
