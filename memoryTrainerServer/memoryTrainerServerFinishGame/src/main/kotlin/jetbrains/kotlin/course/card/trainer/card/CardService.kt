package jetbrains.kotlin.course.card.trainer.card

import jetbrains.kotlin.course.card.trainer.util.countries
import org.springframework.stereotype.Service

@Service
class CardService {
    companion object {
        private val randomCardGenerator = CardSequenceGenerator {
            countries.map { (capital, country) -> Card(Front(capital), Back(country)) }.shuffled()
        }

        private var cards = generateNewCardsSequence()

        private fun generateNewCardsSequence() = randomCardGenerator.generateCards().toMutableList()
    }

    fun getNextCard(): Card {
        require(cards.isNotEmpty()) { "The cards list is empty!" }
        return cards.removeFirst()
    }

    fun startNewGame(): Card {
        cards = generateNewCardsSequence()
        return getNextCard()
    }
}
