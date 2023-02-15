package jetbrains.kotlin.course.card.trainer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CardTrainerApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<CardTrainerApplication>(*args)
}

