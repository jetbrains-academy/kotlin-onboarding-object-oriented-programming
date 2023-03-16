package jetbrains.kotlin.course.codenames.keyCard

import org.springframework.web.bind.annotation.*

typealias KeyCard = String

@RestController
@RequestMapping("/api/keyCard/")
class KeyCardResource(val service: KeyCardService) {
    @CrossOrigin
    @GetMapping("/new")
    fun generateNewKeyCard(): List<Int> = TODO("Not implemented yet")
}
