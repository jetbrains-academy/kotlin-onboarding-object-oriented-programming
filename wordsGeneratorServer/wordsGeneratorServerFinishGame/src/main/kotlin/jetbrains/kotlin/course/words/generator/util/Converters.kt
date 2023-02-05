package jetbrains.kotlin.course.words.generator.util

import alias.JsTeam
import jetbrains.kotlin.course.words.generator.results.GameJsResult
import jetbrains.kotlin.course.words.generator.results.GameResult
import jetbrains.kotlin.course.words.generator.team.Team
import jetbrains.kotlin.course.words.generator.team.TeamService

fun List<Team>.toArrayJsTeams() = this.map { it.toJsTeam() }.toTypedArray()

fun Team.toJsTeam(): JsTeam = JsTeam(this.id, this.points, this.name)

fun GameJsResult.toGameResult(): GameResult = this.map {
    val team = TeamService.teamsStorage[it.id] ?: error("Internal error! Unknown team with id: ${it.id} was received!")
    team.points = it.points
    team
}
