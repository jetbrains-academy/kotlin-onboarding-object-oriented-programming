package jetbrains.kotlin.course.alias.card

data class JsCard(
    val id: Int,
    val words: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JsCard

        if (id != other.id) return false
        if (!words.contentEquals(other.words)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + words.contentHashCode()
        return result
    }
}
