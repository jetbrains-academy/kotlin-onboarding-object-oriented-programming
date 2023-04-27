import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val statTestClass = TestClass(
    "Stat",
    "jetbrains.kotlin.course.card.trainer.stat",
    isDataClass = true,
    declaredFields = listOf(
        TestVariable(
            name = "knownBacks",
            javaType = "List",
            kotlinType = TestKotlinType("List", params = listOf("jetbrains.kotlin.course.card.trainer.card.Back")),
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
        TestVariable(
            name = "unknownBacks",
            javaType = "List",
            kotlinType = TestKotlinType("List", params = listOf("jetbrains.kotlin.course.card.trainer.card.Back")),
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
    ),
)
