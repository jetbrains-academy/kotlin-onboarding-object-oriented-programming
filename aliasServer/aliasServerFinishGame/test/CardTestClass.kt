import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val cardTestClass = TestClass(
    "Card",
    "jetbrains.kotlin.course.alias.card",
    isDataClass = true,
    declaredFields = listOf(
        TestVariable(
            name = "id",
            javaType = "int",
            kotlinType = kotlinTypeIdentifier,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
        TestVariable(
            name = "words",
            javaType = "List",
            kotlinType = TestKotlinType(
                "List",
                abbreviation = "jetbrains.kotlin.course.alias.card.Word",
                params = listOf("String")
            ),
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
    )
)
