package jetbrains.kotlin.course.codenames.keyCard

import jetbrains.kotlin.course.codenames.utils.toJsKeyCard
import org.springframework.web.bind.annotation.*

typealias KeyCard = String

@RestController
@RequestMapping("/api/keyCard/")
class KeyCardResource(val service: KeyCardService) {
    @CrossOrigin
    @GetMapping("/new")
    fun generateNewKeyCard() = service.generateKeyCard().toJsKeyCard()
}
