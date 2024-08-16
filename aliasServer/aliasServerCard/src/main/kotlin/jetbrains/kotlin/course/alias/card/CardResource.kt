package jetbrains.kotlin.course.alias.card

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cards/")
class CardResource(val service: CardService) {
    @CrossOrigin
    @GetMapping("/card")
    fun getCardByIndex(@RequestParam index: Int): JsCard = TODO("Not implemented yet")

    @CrossOrigin
    @GetMapping("/amount")
    fun getCardsAmount(): Int = TODO("Not implemented yet")
}

