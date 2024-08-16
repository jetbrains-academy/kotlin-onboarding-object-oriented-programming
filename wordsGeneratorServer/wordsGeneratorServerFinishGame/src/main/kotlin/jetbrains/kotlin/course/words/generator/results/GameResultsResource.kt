package jetbrains.kotlin.course.words.generator.results

import jetbrains.kotlin.course.words.generator.util.toGameResult
import org.springframework.web.bind.annotation.*
import jetbrains.kotlin.course.words.generator.team.JsTeam

// We can not use a typealias here because the Spring framework can not parse it
class GameJsResult : ArrayList<JsTeam>()

@RestController
@RequestMapping("/api/results/")
class GameResultsResource(val service: GameResultsService) {
    @CrossOrigin
    @PostMapping("/save")
    fun saveGameResults(@RequestBody result: GameJsResult) = service.saveGameResults(result.toGameResult())

    @CrossOrigin
    @GetMapping("/all")
    fun getAllGameResults() = service.getAllGameResults()
}
