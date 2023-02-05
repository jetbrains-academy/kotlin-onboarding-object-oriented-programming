package jetbrains.kotlin.course.words.generator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WordsGeneratorApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<WordsGeneratorApplication>(*args)
}

