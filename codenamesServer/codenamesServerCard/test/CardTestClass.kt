import models.TestClass
import models.Variable
import models.VariableMutability
import models.Visibility

internal val cardTestClass = TestClass(
    "Card",
    "jetbrains.kotlin.course.codenames.card",
    isDataClass = true,
    declaredFields = listOf(
        Variable(
            name = "data",
            javaType = "CardData",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
        Variable(
            name = "state",
            javaType = "CardState",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
    ),
)