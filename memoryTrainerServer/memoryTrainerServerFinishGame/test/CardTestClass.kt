import models.*

internal val frontReturnKotlinType = KotlinType(
    "String",
    abbreviation = "jetbrains.kotlin.course.card.trainer.card.Front"
)

internal val backReturnKotlinType = KotlinType(
    "String",
    abbreviation = "jetbrains.kotlin.course.card.trainer.card.Back"
)

internal val cardTestClass = TestClass(
    "Card",
    "jetbrains.kotlin.course.card.trainer.card",
    isDataClass = true,
    declaredFields = listOf(
        Variable(
            name = "front",
            javaType = "String",
            kotlinType = frontReturnKotlinType,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
        Variable(
            name = "back",
            javaType = "String",
            kotlinType = backReturnKotlinType,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
    ),
)
