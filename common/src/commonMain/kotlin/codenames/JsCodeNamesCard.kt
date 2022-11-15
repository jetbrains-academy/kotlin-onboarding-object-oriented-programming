@file:Suppress("unused")

package codenames

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@OptIn(ExperimentalJsExport::class)
@JsExport
data class JsCodeNamesCard(
    val id: Int,
    val word: String,
)
