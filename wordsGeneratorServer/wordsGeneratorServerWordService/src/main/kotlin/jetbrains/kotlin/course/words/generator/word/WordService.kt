package jetbrains.kotlin.course.words.generator.word

import jetbrains.kotlin.course.words.generator.util.words
import org.springframework.stereotype.Service

@Service
class WordService {
    companion object {
        val numberOfWords = words.size
        private val previousWords = mutableMapOf<String, MutableList<Word>>()
    }
    fun generateNextWord(): Word {
        if (words.isEmpty()) {
            error("No words in the list")
        }
        return Word(words.removeFirst())
    }

    fun isValidWord(keyWord: String, newWord: String): Boolean {
        if (newWord.isEmpty()) {
            return false
        }
        val groupedKeyWord = keyWord.groupByLetters()
        val groupedNewWord = newWord.groupByLetters()
        return groupedNewWord.all { (c, n) -> groupedKeyWord[c] != null && groupedKeyWord[c]!! >= n }
    }

    fun isNewWord(keyWord: String, newWord: String) =
        previousWords.putIfAbsent(keyWord, mutableListOf(Word(newWord)))?.let { words ->
            val word = Word(newWord)
            (word !in words).also {
                if (it)  {
                    words.add(word)
                }
            }
        } ?: true

    private fun String.groupByLetters() = this.groupingBy { it }.eachCount()
}
