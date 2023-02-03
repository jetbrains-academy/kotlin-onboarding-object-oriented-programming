package jetbrains.kotlin.course.codenames.card

import jetbrains.kotlin.course.codenames.utils.Utils.TOTAL_AMOUNT
import jetbrains.kotlin.course.codenames.utils.words
import org.springframework.stereotype.Service

@Service
class CardService {
    fun generateWordsCards(): List<Card> {
        if (words.size < TOTAL_AMOUNT) {
            error("Not enough words for the game!")
        }
        val shuffledWords = words.shuffled()
        val cards = shuffledWords.take(TOTAL_AMOUNT).map {
            Card(
                WordCardData(it),
                CardState.Data,
            )
        }
        words = shuffledWords.drop(TOTAL_AMOUNT)
        return cards
    }
}
