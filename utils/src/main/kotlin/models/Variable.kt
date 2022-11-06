package models

import throwInternalCourseError
import java.io.File
import java.lang.reflect.Field
import kotlin.reflect.KProperty
import kotlin.reflect.KType
import kotlin.reflect.jvm.javaType
import kotlin.reflect.jvm.kotlinProperty

enum class VariableMutability(val key: String) {
    VAL("val"),
    VAR("var"),
}

data class KotlinType(
    val type: String,
    val abbreviation: String? = null,
    val isNullable: Boolean = false,
) {
    fun getTypePrettyString() = abbreviation ?: type
}

data class Variable(
    val name: String,
    val javaType: String,
    val value: String? = null,
    val kotlinType: KotlinType? = null,
    val visibility: Visibility? = null,
    val mutability: VariableMutability? = null,
    val isInPrimaryConstructor: Boolean = false,
    ) {
    private fun getTypePrettyString() = kotlinType?.getTypePrettyString() ?: javaType

    fun prettyString(): String {
        val currentMutability = mutability?.key ?: ""
        val prefix = visibility?.let {
            "${visibility.key} $currentMutability "
        } ?: ""
        return "$prefix$name: ${getTypePrettyString()}"
    }

    fun checkField(field: Field) {
        val kotlinProp = field.kotlinProperty ?: error("Can not find Kotlin property for the field ${this.prettyString()}")
        assert(kotlinProp.name == name) { "The field name must be: $name" }
        val visibility = kotlinProp.visibility?.name?.lowercase()
        val visibilityErrorMessage = this.visibility?.let {
            "The visibility of the field $name must be ${it.key}"
        } ?: "The filed $name should not have any modifiers"
        assert(visibility == this.visibility?.key) { visibilityErrorMessage }
        val mutability = kotlinProp.getVariableMutability()
        val mutabilityErrorMessage = this.mutability?.let {
            "The field $name must be ${it.key}"
        } ?: "The filed $name should not have val or var key words"
        assert(mutability == this.mutability) { mutabilityErrorMessage }
        kotlinProp.returnType.checkType(kotlinType, javaType, "the field $name")
    }
}

fun KProperty<*>.getVariableMutability(): VariableMutability? {
    val strRepresentation = this.toString()
    if (VariableMutability.VAL.key in strRepresentation) {
        return VariableMutability.VAL
    }
    if (VariableMutability.VAR.key in strRepresentation) {
        return VariableMutability.VAR
    }
    return null
}

fun Variable.variableDefTemplateBase() = "val ${this.name} = ${this.value}"

fun Variable.variableDefTemplateWithType() = "val ${this.name}: ${this.javaType} = ${this.value}"

fun Variable.isVariableExist(fileContent: String): Boolean {
    val baseDef = variableDefTemplateBase()
    val defWithType = variableDefTemplateWithType()
    if (!(baseDef in fileContent || defWithType in fileContent)) {
        error(
            "The code should contains a definition of the ${this.name} variable! " +
                    "Please, add <$baseDef> or <$defWithType> code in your solution."
        )
    }
    return true
}

fun checkListOfVariables(sourceCodeFile: File, variables: List<Variable>) {
    if (sourceCodeFile.exists()) {
        val content = sourceCodeFile.readText()
        for (variable in variables) {
            assert(variable.isVariableExist(content))
        }
    } else {
        // TODO: log some errors?
        throwInternalCourseError()
    }
}