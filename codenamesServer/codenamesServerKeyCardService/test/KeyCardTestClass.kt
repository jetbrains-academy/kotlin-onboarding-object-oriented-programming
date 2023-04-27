import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val cellsReturnKotlinType = TestKotlinType(
    "List",
    abbreviation = "jetbrains.kotlin.course.codenames.keyCard.KeyCardCell"
)

internal val getCellsFromKeyCardMethod = TestMethod(
    name = "getCells",
    returnType = cellsReturnKotlinType,
    returnTypeJava = "List",
)

internal val keyCardTestClass = TestClass(
    "KeyCard",
    "jetbrains.kotlin.course.codenames.keyCard",
    isDataClass = true,
    declaredFields = listOf(
        TestVariable(
            name = "cells",
            javaType = "List",
            kotlinType = cellsReturnKotlinType,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        )
    ),
)