package card.trainer

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@OptIn(ExperimentalJsExport::class)
@JsExport
data class JsCardTrainerModel(
    val front: String,
    val back: String,
)
