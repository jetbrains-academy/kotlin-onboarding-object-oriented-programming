package jetbrains.kotlin.course.card.trainer.card

@JvmInline
value class Front(val capital: String)

@JvmInline
value class Back(val country: String)

data class Card(
    val front: Front,
    val back: Back,
)
