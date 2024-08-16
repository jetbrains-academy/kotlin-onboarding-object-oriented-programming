package jetbrains.kotlin.course.words.generator.team

import jetbrains.kotlin.course.words.generator.team.JsTeam
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/teams/")
class TeamResource(val service: TeamService) {
    @CrossOrigin
    @PostMapping("/generate")
    fun generateTeamsForOneRound(@RequestBody number: Int): List<JsTeam> = TODO("Not implemented yet")
}
