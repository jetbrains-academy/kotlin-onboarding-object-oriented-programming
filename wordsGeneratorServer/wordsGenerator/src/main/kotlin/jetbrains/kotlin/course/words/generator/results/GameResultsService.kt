package jetbrains.kotlin.course.words.generator.results

import jetbrains.kotlin.course.words.generator.team.Team
import jetbrains.kotlin.course.words.generator.team.TeamService
import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service
class GameResultsService {
    companion object {
        val gameHistory = mutableListOf<GameResult>()
    }

    fun saveGameResults(result: GameResult) {
        require(result.isNotEmpty()) { "Internal error! Game result is empty!" }
        require(result.all { it.id in TeamService.teamsStorage.keys }) { "Internal error! Unknown team was received!" }
        gameHistory.add(result)
    }

    fun getAllGameResults() = gameHistory.reversed()
}