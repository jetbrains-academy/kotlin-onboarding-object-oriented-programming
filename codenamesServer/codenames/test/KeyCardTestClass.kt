import models.*

internal val cellsReturnKotlinType = KotlinType(
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
        Variable(
            name = "cells",
            javaType = "List",
            kotlinType = cellsReturnKotlinType,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        )
    ),
)