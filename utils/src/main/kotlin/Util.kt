import Util.newLineSeparator
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets

object Util {
    val newLineSeparator: String = System.lineSeparator()
}

fun setSystemIn(input: List<String>? = null) = setSystemIn(input?.joinToString(newLineSeparator))

fun setSystemIn(input: String? = null) = input?.let {
    System.setIn(it.replaceLineSeparator().byteInputStream())
}

fun String.replaceLineSeparator() = this.lines().joinToString(newLineSeparator)

fun setSystemOut(): ByteArrayOutputStream {
    val baos = ByteArrayOutputStream()
    val ps = PrintStream(baos, true, StandardCharsets.UTF_8.name())
    System.setOut(ps)
    return baos
}

fun isSystemInEmpty() = String(System.`in`.readBytes()).isEmpty()

fun throwInternalCourseError(): Nothing = error("Internal course error!")

fun String.shortName() = this.split(".").last()
