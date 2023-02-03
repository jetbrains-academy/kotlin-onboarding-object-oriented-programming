package jetbrains.kotlin.course.codenames.keyCard

import jetbrains.kotlin.course.codenames.utils.Utils
import jetbrains.kotlin.course.codenames.utils.Utils.BLACK_CARDS_NUMBER
import jetbrains.kotlin.course.codenames.utils.Utils.GRAY_CARDS_NUMBER
import jetbrains.kotlin.course.codenames.utils.Utils.PINK_CARDS_NUMBER
import jetbrains.kotlin.course.codenames.utils.Utils.VIOLET_CARDS_NUMBER

enum class KeyCardType(val amount: Int) {
    Pink(PINK_CARDS_NUMBER),
    Violet(VIOLET_CARDS_NUMBER),
    Gray(GRAY_CARDS_NUMBER),
    Black(BLACK_CARDS_NUMBER),
}

@JvmInline
value class KeyCardCell(val type: KeyCardType)

data class KeyCard(
    val cells: List<KeyCardCell> = Utils.uniqueKeyCardGenerator.generateData()
)
