package jetbrains.kotlin.course.words.generator.word

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/words/")
class WordResource(val service: WordService) {
    @CrossOrigin
    @GetMapping("/next")
    fun getNextWord(): String = service.generateNextWord().word

    @CrossOrigin
    @GetMapping("/amount")
    fun getWordsAmount(): Int = WordService.numberOfWords

    @CrossOrigin
    @GetMapping("/valid")
    fun isValid(@RequestParam keyWord: String, @RequestParam newWord: String): Boolean =
        service.isValidWord(keyWord, newWord)

    @CrossOrigin
    @GetMapping("/isNew")
    fun isNewWord(@RequestParam keyWord: String, @RequestParam newWord: String): Boolean =
        service.isNewWord(keyWord, newWord)
}