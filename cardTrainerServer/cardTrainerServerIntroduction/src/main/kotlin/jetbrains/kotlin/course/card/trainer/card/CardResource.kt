package jetbrains.kotlin.course.card.trainer.card

import card.trainer.JsCardTrainerModel
import org.springframework.web.bind.annotation.*

typealias Card = String

@RestController
@RequestMapping("/api/cards/")
class CardResource(val service: CardService) {
    @CrossOrigin
    @GetMapping("/next")
    fun getNextCard(): JsCardTrainerModel = TODO("Not implemented yet")

    @CrossOrigin
    @GetMapping("/newGame")
    fun startNewGame(): JsCardTrainerModel = TODO("Not implemented yet")
}
