package jetbrains.kotlin.course.words.generator.word

import org.springframework.web.bind.annotation.*

typealias Word = String

@RestController
@RequestMapping("/api/words/")
class WordResource(val service: WordService) {
    @CrossOrigin
    @GetMapping("/next")
    fun getNextWord(): String = TODO("Not implemented yet")

    @CrossOrigin
    @GetMapping("/amount")
    fun getWordsAmount(): Int = TODO("Not implemented yet")

    @CrossOrigin
    @GetMapping("/valid")
    fun isValid(@RequestParam keyWord: String, @RequestParam newWord: String): Boolean =
        service.isValidWord(keyWord, newWord)

    @CrossOrigin
    @GetMapping("/isNew")
    fun isNewWord(@RequestParam keyWord: String, @RequestParam newWord: String): Boolean =
        service.isNewWord(keyWord, newWord)
}
