package jetbrains.kotlin.course.codenames.utils

import jetbrains.kotlin.course.codenames.keyCard.KeyCardCell
import jetbrains.kotlin.course.codenames.keyCard.KeyCardType

fun interface KeyCardGenerator {
    fun generateData(): List<KeyCardCell>
}

object Utils {
    private const val N = 5
    const val TOTAL_NUMBER = N * N
    const val PINK_CARDS_NUMBER = 8
    const val VIOLET_CARDS_NUMBER = 9
    const val GRAY_CARDS_NUMBER = 7
    const val BLACK_CARDS_NUMBER = 1

    private val previousAttempts: MutableList<List<KeyCardCell>> = mutableListOf()

    val uniqueKeyCardGenerator = KeyCardGenerator {
        var inPreviousAttempts: Boolean
        var currentAttempt: List<KeyCardCell>
        do {
            currentAttempt = KeyCardType.values().map { type ->
                List(type.number) { KeyCardCell(type) }
            }.flatten().shuffled()
            inPreviousAttempts = currentAttempt in previousAttempts
        } while (inPreviousAttempts)
        previousAttempts.add(currentAttempt)
        currentAttempt
    }

    init {
        require(PINK_CARDS_NUMBER + VIOLET_CARDS_NUMBER + GRAY_CARDS_NUMBER + BLACK_CARDS_NUMBER == TOTAL_NUMBER) { "The total number in the game must be: $TOTAL_NUMBER" }
    }
}
