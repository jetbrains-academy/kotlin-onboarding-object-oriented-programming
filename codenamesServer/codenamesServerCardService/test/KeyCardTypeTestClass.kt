import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.ClassType
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val keyCardTypeTestClass = TestClass(
    "KeyCardType",
    "jetbrains.kotlin.course.codenames.keyCard",
    classType = ClassType.ENUM,
    declaredFields = listOf(
        TestVariable(
            name = "number",
            javaType = "Int",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        )
    ),
    declaredEnumEntries = listOf(
        TestVariable(
            name = "Pink",
            javaType = "KeyCardType",
            visibility = Visibility.PUBLIC,
        ),
        TestVariable(
            name = "Violet",
            javaType = "KeyCardType",
            visibility = Visibility.PUBLIC,
        ),
        TestVariable(
            name = "Gray",
            javaType = "KeyCardType",
            visibility = Visibility.PUBLIC,
        ),
        TestVariable(
            name = "Black",
            javaType = "KeyCardType",
            visibility = Visibility.PUBLIC,
        )
    ),
)
