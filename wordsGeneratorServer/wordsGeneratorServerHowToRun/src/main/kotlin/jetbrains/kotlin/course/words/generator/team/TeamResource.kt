package jetbrains.kotlin.course.words.generator.team

import jetbrains.kotlin.course.words.generator.util.toArrayJsTeams
import org.springframework.web.bind.annotation.*

typealias Team = String

@RestController
@RequestMapping("/api/teams/")
class TeamResource(val service: TeamService) {
    @CrossOrigin
    @PostMapping("/generate")
    fun generateTeamsForOneRound(@RequestBody number: Int) =
        service.generateTeamsForOneRound(number).toArrayJsTeams()
}
