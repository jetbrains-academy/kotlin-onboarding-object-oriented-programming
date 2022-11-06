package models

import java.lang.reflect.Modifier
import java.lang.reflect.Type
import kotlin.reflect.KType
import kotlin.reflect.jvm.javaType

enum class Visibility(val key: String) {
    PUBLIC("public"),
    PRIVATE("private"),
    ;
}

private fun KType.checkNullability(kotlinType: KotlinType, errorMessagePrefix: String) {
    val nullablePrefix = if (!kotlinType.isNullable) "" else "not"
    assert(this.isMarkedNullable == kotlinType.isNullable) { "Error, $errorMessagePrefix must be $nullablePrefix nullable" }
}

private fun KType.getAbbreviation(): String? {
    val separator = " /*"
    val strRepresentation = this.toString()
    if (separator !in strRepresentation) {
        return null
    }
    return strRepresentation.split(separator).first()
}

private fun KType.checkAbbreviation(abbreviation: String, errorMessagePrefix: String) {
    val abr = this.getAbbreviation()
    assert(abr != null) { "You need to create a value class or a type alias $abbreviation and use it as the return type for $errorMessagePrefix" }
    assert(abr!! == abbreviation) { "The return type for $errorMessagePrefix must be $abbreviation" }
}

fun KType.checkType(
    kotlinType: KotlinType?,
    javaType: String,
    errorMessagePrefix: String,
    toCheckJavaType: Boolean = true
) {
    kotlinType?.let {
        this.checkNullability(kotlinType, errorMessagePrefix)
        it.abbreviation?.let { abr ->
            this.checkAbbreviation(abr, errorMessagePrefix)
        }
    }
    if (toCheckJavaType) {
        val message = "The return type of $errorMessagePrefix must be $javaType"
        // We have a parametrized type
        if ("<" in this.javaType.toString()) {
            val type = kotlinType?.getTypePrettyString() ?: javaType
            assert(type.lowercase() in this.javaType.toString().lowercase()) { message }
        } else {
            assert(this.javaType.getShortName() == javaType.lowercase()) { message }
        }
    }
}

fun Type.getShortName() = this.toString().lowercase().split(".").last()

fun Class<*>.getDeclaredFieldsWithoutCompanion() = this.declaredFields.filter { it.name != "Companion" }

fun Int.getVisibility(): Visibility? {
    if (Modifier.isPublic(this)) {
        return Visibility.PUBLIC
    }
    if (Modifier.isPrivate(this)) {
        return Visibility.PRIVATE
    }
    return null
}