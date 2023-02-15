import models.*

internal val kotlinTypeIdentifier = KotlinType("Int", "jetbrains.kotlin.course.card.trainer.util")

internal val uniqueIdentifierMethod = TestMethod(
    name = "uniqueIdentifier",
    returnType = kotlinTypeIdentifier,
    returnTypeJava = "int",
)

internal val identifierFactoryClass = TestClass(
    "IdentifierFactory",
    "jetbrains.kotlin.course.card.trainer.util",
    declaredFields = listOf(
        Variable(
            name = "counter",
            javaType = "int",
            kotlinType = kotlinTypeIdentifier,
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAR,
        ),
    ),
    customMethods = listOf(uniqueIdentifierMethod),
)
