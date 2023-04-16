import models.*

internal val statTestClass = TestClass(
    "Stat",
    "jetbrains.kotlin.course.card.trainer.stat",
    isDataClass = true,
    declaredFields = listOf(
        Variable(
            name = "knownBacks",
            javaType = "List",
            kotlinType = KotlinType("List", params = listOf("jetbrains.kotlin.course.card.trainer.card.Back")),
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
        Variable(
            name = "unknownBacks",
            javaType = "List",
            kotlinType = KotlinType("List", params = listOf("jetbrains.kotlin.course.card.trainer.card.Back")),
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
    ),
)
