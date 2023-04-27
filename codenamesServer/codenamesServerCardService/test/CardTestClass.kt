import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val cardTestClass = TestClass(
    "Card",
    "jetbrains.kotlin.course.codenames.card",
    isDataClass = true,
    declaredFields = listOf(
        TestVariable(
            name = "data",
            javaType = "CardData",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
        TestVariable(
            name = "state",
            javaType = "CardState",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
    ),
)