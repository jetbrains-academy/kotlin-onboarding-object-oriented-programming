import models.*

internal val expectedVariablesValues = mapOf(
    "N" to 5,
    "TOTAL_NUMBER" to 5 * 5,
    "PINK_CARDS_NUMBER" to 8,
    "VIOLET_CARDS_NUMBER" to 9,
    "GRAY_CARDS_NUMBER" to 7,
    "BLACK_CARDS_NUMBER" to 1,
)

internal val utilObjectTestClass = TestClass(
    "Utils",
    "jetbrains.kotlin.course.codenames.utils",
    classType = ClassType.OBJECT,
    declaredFields = listOf(
        Variable(
            name = "N",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAL,
        ),
        Variable(
            name = "TOTAL_NUMBER",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        Variable(
            name = "PINK_CARDS_NUMBER",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        Variable(
            name = "VIOLET_CARDS_NUMBER",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        Variable(
            name = "GRAY_CARDS_NUMBER",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        Variable(
            name = "BLACK_CARDS_NUMBER",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),

    ),
)