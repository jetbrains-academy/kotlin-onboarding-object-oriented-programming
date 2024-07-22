package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service
class GameResultsService {
    companion object {
        val gameHistory: MutableList<GameResult> = mutableListOf()
    }

    fun saveGameResults(result: GameResult) {
        require(result.isNotEmpty()) { "Internal error! Game result is empty!" }
        require(result.all { it.id in TeamService.teamsStorage.keys }) { "Internal error! Unknown team was received!" }
        gameHistory.add(result)
    }

    // It's necessary to specify return type explicitly, so kotlin-reflect gets it right
    fun getAllGameResults(): List<GameResult> = gameHistory.reversed()
}
