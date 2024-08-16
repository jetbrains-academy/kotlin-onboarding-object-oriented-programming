package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.JsTeam
import org.springframework.web.bind.annotation.*

typealias GameResult = String

// We can not use a typealias here because the Spring framework can not parse it
class GameJsResult : ArrayList<JsTeam>()

@RestController
@RequestMapping("/api/results/")
class GameResultsResource(val service: GameResultsService) {
    @CrossOrigin
    @PostMapping("/save")
    fun saveGameResults(@RequestBody result: GameJsResult): Unit = TODO("Not implemented yet")

    @CrossOrigin
    @GetMapping("/all")
    fun getAllGameResults() = service.getAllGameResults()
}
