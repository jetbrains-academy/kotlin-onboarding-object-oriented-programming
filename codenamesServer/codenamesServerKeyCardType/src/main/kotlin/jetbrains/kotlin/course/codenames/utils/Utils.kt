package jetbrains.kotlin.course.codenames.utils

object Utils {
    private const val N = 5
    const val TOTAL_NUMBER = N * N
    const val PINK_CARDS_NUMBER = 8
    const val VIOLET_CARDS_NUMBER = 9
    const val GRAY_CARDS_NUMBER = 7
    const val BLACK_CARDS_NUMBER = 1

    init {
        require(PINK_CARDS_NUMBER + VIOLET_CARDS_NUMBER + GRAY_CARDS_NUMBER + BLACK_CARDS_NUMBER == TOTAL_NUMBER) { "The total number in the game must be: $TOTAL_NUMBER" }
    }
}
