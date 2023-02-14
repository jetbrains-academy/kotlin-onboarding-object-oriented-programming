package jetbrains.kotlin.course.card.trainer.stat

import org.springframework.web.bind.annotation.*

// We can not use a typealias here because the Spring framework can not parse it
class RoundStat : ArrayList<String>()

@RestController
@RequestMapping("/api/stat/")
class StatResource(val service: StatService) {
    @CrossOrigin
    @PostMapping("/save")
    fun saveGameResults(
        @RequestBody known: RoundStat,
        @RequestBody unknown: RoundStat
    ) = service.save(known, unknown)

    @CrossOrigin
    @GetMapping("/history")
    fun getAllGameResults() = service.getHistory()
}