package jetbrains.kotlin.course.card.trainer.card

import jetbrains.kotlin.course.card.trainer.util.IdentifierFactory

@JvmInline
value class Front(val capital: String)

@JvmInline
value class Back(val country: String)

data class Card(
    val front: Front,
    val back: Back,
    val id: Int = idFactory.uniqueIdentifier(),
) {
    companion object {
        private val idFactory = IdentifierFactory()
    }
}

fun interface CardSequenceGenerator {
    fun generateCards(): List<Card>
}
