package jetbrains.kotlin.course.card.trainer.util

typealias Identifier = Int

class IdentifierFactory(private var counter: Identifier = 0) {
    fun uniqueIdentifier(): Identifier = counter++
}
