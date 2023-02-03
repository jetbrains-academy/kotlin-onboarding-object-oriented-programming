package jetbrains.kotlin.course.codenames

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CodenamesApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<CodenamesApplication>(*args)
}
