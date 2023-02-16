package jetbrains.kotlin.course.words.generator.team

import org.springframework.stereotype.Service

typealias Team = String

@Service
class TeamService {
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> = TODO("Not implemented yet")
}
