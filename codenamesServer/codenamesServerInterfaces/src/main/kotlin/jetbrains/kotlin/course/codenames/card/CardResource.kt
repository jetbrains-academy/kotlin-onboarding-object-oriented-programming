package jetbrains.kotlin.course.codenames.card

import jetbrains.kotlin.course.codenames.utils.toJsCards
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cards/")
class CardResource(val service: CardService) {
    @CrossOrigin
    @GetMapping("/generate")
    fun generateWordsCards() = service.generateWordsCards().toJsCards()
}
