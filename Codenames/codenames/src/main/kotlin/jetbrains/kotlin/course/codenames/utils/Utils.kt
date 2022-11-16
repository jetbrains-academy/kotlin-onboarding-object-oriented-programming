package jetbrains.kotlin.course.codenames.utils

typealias Identifier = Int

class IdentifierFactory(private var counter: Identifier = 0) {
    fun uniqueIdentifier(): Identifier = counter++
}

object Utils {
    private const val N = 5
    const val TOTAL_AMOUNT = N * N

    const val PINK_CARDS_NUMBER = 8
    const val VIOLET_CARDS_NUMBER = 9
    const val GRAY_CARDS_NUMBER = 7
    const val BLACK_CARDS_NUMBER = 1

    init {
        require(PINK_CARDS_NUMBER + VIOLET_CARDS_NUMBER + GRAY_CARDS_NUMBER + BLACK_CARDS_NUMBER == TOTAL_AMOUNT) { "The total amount in the game must be: $TOTAL_AMOUNT" }
    }
}
