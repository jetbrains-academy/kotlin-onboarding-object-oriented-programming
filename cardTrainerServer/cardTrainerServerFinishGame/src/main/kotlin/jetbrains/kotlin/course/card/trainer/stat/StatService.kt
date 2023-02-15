package jetbrains.kotlin.course.card.trainer.stat

import jetbrains.kotlin.course.card.trainer.card.Back
import org.springframework.stereotype.Service

@Service
class StatService {
    companion object {
        private val history: MutableList<Stat> = mutableListOf()
    }

    fun getHistory() = history.reversed()

    fun save(known: List<String>, unknown: List<String>) {
        history.add(
            Stat(
                known.map { Back((it)) },
                unknown.map { Back((it)) },
            )
        )
    }
}