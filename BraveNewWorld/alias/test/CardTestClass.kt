import models.*

internal val cardTestClass = TestClass(
    "Card1",
    "jetbrains.kotlin.course.alias.card",
    isDataClass = true,
    declaredFields = listOf(
        Variable(
            name = "id",
            javaType = "int",
            kotlinType = kotlinTypeIdentifier,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
        Variable(
            name = "words",
            javaType = "List",
            kotlinType = KotlinType(
                "List",
                abbreviation = "jetbrains.kotlin.course.alias.card.Word1",
                params = listOf(String())
            ),
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
    )
)
