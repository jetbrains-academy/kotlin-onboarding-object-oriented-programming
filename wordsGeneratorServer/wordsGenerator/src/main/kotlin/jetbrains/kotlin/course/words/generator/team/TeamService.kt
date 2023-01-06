package jetbrains.kotlin.course.words.generator.team

import jetbrains.kotlin.course.words.generator.util.Identifier
import jetbrains.kotlin.course.words.generator.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class TeamService {
    companion object {
        val teamsStorage = mutableMapOf<Identifier, Team>()
    }

    private val identifierFactory = IdentifierFactory()

    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val teams = List(teamsNumber) { Team(identifierFactory.uniqueIdentifier()) }
        teams.forEach { teamsStorage.putIfAbsent(it.id, it) }
        return teams
    }
}
