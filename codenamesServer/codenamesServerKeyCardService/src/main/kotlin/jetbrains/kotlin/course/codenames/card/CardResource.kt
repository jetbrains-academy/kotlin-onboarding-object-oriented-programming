package jetbrains.kotlin.course.codenames.card

import codenames.JsCodeNamesCard
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

typealias Card = String

@RestController
@RequestMapping("/api/cards/")
class CardResource(val service: CardService) {
    @CrossOrigin
    @GetMapping("/generate")
    fun generateWordsCards(): List<JsCodeNamesCard> = TODO("Not implemented yet")
}
