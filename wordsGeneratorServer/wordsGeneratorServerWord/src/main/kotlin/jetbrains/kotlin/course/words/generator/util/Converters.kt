package jetbrains.kotlin.course.words.generator.util

import alias.JsTeam
import jetbrains.kotlin.course.words.generator.team.Team

fun Team.toJsTeam(): JsTeam = JsTeam(this.id, this.points, this.name)
