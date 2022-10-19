package jetbrains.kotlin.course.alias.util

typealias Identifier = Int

class IdentifierFactory(private var counter: Int = 0) {
    fun uniqueIdentifier(): Identifier = counter++
}

// Create typealias Identifier, IdentifierFactory class and uniqueIdentifier function
// create data class Team
// add companion object into TeamService and implement to make the teams screen alive
// create Word and Card classes
// implement CardService
// implement GameResultsService