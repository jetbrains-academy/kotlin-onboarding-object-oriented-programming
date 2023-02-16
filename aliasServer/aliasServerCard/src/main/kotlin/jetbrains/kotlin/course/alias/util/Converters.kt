package jetbrains.kotlin.course.alias.util

import alias.JsCard
import alias.JsTeam
import jetbrains.kotlin.course.alias.card.Card
import jetbrains.kotlin.course.alias.team.Team

fun Card.toJsCard(): JsCard = TODO("Not implemented yet")

fun Team.toJsTeam(): JsTeam = JsTeam(this.id, this.points, this.name)

fun List<Team>.toArrayJsTeams(): List<JsTeam> = TODO("Not implemented yet")
