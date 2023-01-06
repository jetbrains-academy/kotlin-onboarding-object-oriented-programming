package jetbrains.kotlin.course.words.generator.word

import jetbrains.kotlin.course.words.generator.util.words
import org.springframework.stereotype.Service

@Service
class WordService {
    companion object {
        val numberOfWords = words.size
    }
    fun getNextWord(): Word {
        if (words.isEmpty()) {
            error("No words in the list")
        }
        return Word(words.removeFirst())
    }

    fun isValidWord(keyWord: String, newWord: String): Boolean {
        if (newWord.isEmpty()) {
            return false
        }
        val groupedKeyWord = groupByLetters(keyWord)
        val groupedNewWord = groupByLetters(newWord)
        return groupedNewWord.all { (c, n) -> groupedKeyWord[c] != null && groupedKeyWord[c]!! >= n }
    }

    private fun groupByLetters(s: String) = s.groupingBy { it }.eachCount()
}
