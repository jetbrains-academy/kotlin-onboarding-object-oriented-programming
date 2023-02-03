package jetbrains.kotlin.course.alias.results

import org.springframework.stereotype.Service

typealias GameResult = String

@Service
class GameResultsService {
    fun saveGameResults(result: GameResult): Unit = TODO("Not implemented yet")

    fun getAllGameResults(): Unit = TODO("Not implemented yet")
}

