package jetbrains.kotlin.course.words.generator.word

import jetbrains.kotlin.course.words.generator.util.words
import org.springframework.stereotype.Service

@Service
class WordService {
    companion object {
        val numberOfWords = words.size
    }
    fun generateNextWord(): Word {
        if (words.isEmpty()) {
            error("No words in the list")
        }
        return Word(words.removeFirst())
    }

    fun isValidWord(keyWord: String, newWord: String): Boolean = TODO("Not implemented yet")

    fun isNewWord(keyWord: String, newWord: String): Boolean = TODO("Not implemented yet")
}
