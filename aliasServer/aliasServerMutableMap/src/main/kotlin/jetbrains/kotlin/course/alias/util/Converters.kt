package jetbrains.kotlin.course.alias.util

import alias.JsTeam
import jetbrains.kotlin.course.alias.team.Team

fun Team.toJsTeam(): JsTeam = JsTeam(this.id, this.points, this.name)
