package jetbrains.kotlin.course.alias.util

import jetbrains.kotlin.course.alias.team.JsTeam
import jetbrains.kotlin.course.alias.team.Team

fun Team.toJsTeam(): JsTeam = JsTeam(this.id, this.points, this.name)
