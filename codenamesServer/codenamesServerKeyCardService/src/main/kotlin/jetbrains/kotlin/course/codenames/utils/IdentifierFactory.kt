package jetbrains.kotlin.course.codenames.utils

typealias Identifier = Int

class IdentifierFactory(private var counter: Identifier = 0) {
    fun uniqueIdentifier(): Identifier = counter++
}
