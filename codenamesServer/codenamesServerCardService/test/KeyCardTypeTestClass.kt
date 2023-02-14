import models.*

internal val keyCardTypeTestClass = TestClass(
    "KeyCardType",
    "jetbrains.kotlin.course.codenames.keyCard",
    classType = ClassType.ENUM,
    declaredFields = listOf(
        Variable(
            name = "number",
            javaType = "Int",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        )
    ),
    declaredEnumEntries = listOf(
        Variable(
            name = "Pink",
            javaType = "KeyCardType",
            visibility = Visibility.PUBLIC,
        ),
        Variable(
            name = "Violet",
            javaType = "KeyCardType",
            visibility = Visibility.PUBLIC,
        ),
        Variable(
            name = "Gray",
            javaType = "KeyCardType",
            visibility = Visibility.PUBLIC,
        ),
        Variable(
            name = "Black",
            javaType = "KeyCardType",
            visibility = Visibility.PUBLIC,
        )
    ),
)