package jetbrains.kotlin.course.words.generator.team

import jetbrains.kotlin.course.words.generator.util.Identifier

data class Team(
    val id: Identifier,
    var points: Int = 0,
) {
    val name: String = "Team#${id + 1}"
}
