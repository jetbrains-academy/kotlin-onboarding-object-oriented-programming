package jetbrains.kotlin.course.card.trainer.stat

import jetbrains.kotlin.course.card.trainer.card.Back

data class Stat(
    val knownBacks: List<Back>,
    val unknownBacks: List<Back>,
)
