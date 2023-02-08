package jetbrains.kotlin.course.codenames.card

import jetbrains.kotlin.course.codenames.utils.Utils
import jetbrains.kotlin.course.codenames.utils.words
import org.springframework.stereotype.Service

@Service
class CardService {
    fun generateWordsCards(): List<Card> {
        require(words.size >= Utils.TOTAL_AMOUNT) { "Not enough words for the game!" }
        if (words.size < Utils.TOTAL_AMOUNT) {
            error("Not enough words for the game!")
        }
        val shuffledWords = words.shuffled()
        val cards = shuffledWords.take(Utils.TOTAL_AMOUNT).map {
            Card(
                WordCardData(it),
                CardState.Front,
            )
        }
        words = shuffledWords.drop(Utils.TOTAL_AMOUNT)
        return cards
    }
}
