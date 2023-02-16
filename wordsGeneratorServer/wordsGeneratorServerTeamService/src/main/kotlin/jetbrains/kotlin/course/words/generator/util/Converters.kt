package jetbrains.kotlin.course.words.generator.util

import alias.JsTeam
import jetbrains.kotlin.course.words.generator.results.GameJsResult
import jetbrains.kotlin.course.words.generator.results.GameResult
import jetbrains.kotlin.course.words.generator.team.Team

fun List<Team>.toArrayJsTeams(): List<JsTeam> = TODO("Not implemented yet")

fun Team.toJsTeam(): JsTeam = JsTeam(this.id, this.points, this.name)

fun GameJsResult.toGameResult(): GameResult = TODO("Not implemented yet")
