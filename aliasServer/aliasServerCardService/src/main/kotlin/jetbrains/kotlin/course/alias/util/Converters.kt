package jetbrains.kotlin.course.alias.util

import jetbrains.kotlin.course.alias.card.Card
import jetbrains.kotlin.course.alias.card.JsCard
import jetbrains.kotlin.course.alias.team.JsTeam
import jetbrains.kotlin.course.alias.team.Team

fun Card.toJsCard(): JsCard = JsCard(this.id, this.words.map { it.word }.toTypedArray())

fun Team.toJsTeam(): JsTeam = JsTeam(this.id, this.points, this.name)

fun List<Team>.toArrayJsTeams() = this.map { it.toJsTeam() }.toTypedArray()
