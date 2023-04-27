import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val frontReturnKotlinType = TestKotlinType(
    "String",
    abbreviation = "jetbrains.kotlin.course.card.trainer.card.Front"
)

internal val backReturnKotlinType = TestKotlinType(
    "String",
    abbreviation = "jetbrains.kotlin.course.card.trainer.card.Back"
)

internal val cardTestClass = TestClass(
    "Card",
    "jetbrains.kotlin.course.card.trainer.card",
    isDataClass = true,
    declaredFields = listOf(
        TestVariable(
            name = "front",
            javaType = "String",
            kotlinType = frontReturnKotlinType,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
        TestVariable(
            name = "back",
            javaType = "String",
            kotlinType = backReturnKotlinType,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
    ),
)
