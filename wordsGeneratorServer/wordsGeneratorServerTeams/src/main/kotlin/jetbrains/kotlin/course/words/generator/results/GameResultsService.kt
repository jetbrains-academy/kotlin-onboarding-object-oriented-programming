package jetbrains.kotlin.course.words.generator.results

import jetbrains.kotlin.course.words.generator.team.Team
import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service
class GameResultsService {
    fun saveGameResults(result: GameResult): Unit = TODO("Not implemented yet")

    fun getAllGameResults(): List<GameResult> = TODO("Not implemented yet")
}
