package jetbrains.kotlin.course.card.trainer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MemoryTrainerApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<MemoryTrainerApplication>(*args)
}

