import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val wordCardDataTestClass = TestClass(
    "WordCardData",
    "jetbrains.kotlin.course.codenames.card",
    isDataClass = true,
    declaredFields = listOf(
        TestVariable(
            name = "word",
            javaType = "String",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        )
    ),
    interfaces = listOf(
        cardDataInterfaceTestClass,
    ),
)
