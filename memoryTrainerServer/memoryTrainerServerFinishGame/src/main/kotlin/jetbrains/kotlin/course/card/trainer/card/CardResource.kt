package jetbrains.kotlin.course.card.trainer.card

import jetbrains.kotlin.course.card.trainer.util.JsCardTrainerModel
import jetbrains.kotlin.course.card.trainer.util.toJsCard
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cards/")
class CardResource(val service: CardService) {
    @CrossOrigin
    @GetMapping("/next")
    fun getNextCard(): JsCardTrainerModel = service.getNextCard().toJsCard()

    @CrossOrigin
    @GetMapping("/newGame")
    fun startNewGame(): JsCardTrainerModel = service.startNewGame().toJsCard()
}
