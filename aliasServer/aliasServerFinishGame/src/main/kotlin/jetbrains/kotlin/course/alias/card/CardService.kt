package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words
import org.springframework.stereotype.Service

@Service
class CardService {
    private val identifierFactory = IdentifierFactory()
    private val cards = generateCards()

    companion object {
        private const val WORDS_IN_CARD = 4
        val cardsAmount = words.size / WORDS_IN_CARD
    }

    private fun generateCards(): List<Card> = words.shuffled()
        .chunked(WORDS_IN_CARD)
        .take(cardsAmount)
        .map { Card(identifierFactory.uniqueIdentifier(), it.toWords()) }

    private fun List<String>.toWords() = map { Word(it) }

    fun getCardByIndex(index: Int): Card =
        cards.getOrNull(index) ?: error("The cards list does not have elements at the index $index")
}
