import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.ClassType
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.variable.TestVariable

internal val cardStateTestClass = TestClass(
    "CardState",
    "jetbrains.kotlin.course.codenames.card",
    classType = ClassType.ENUM,
    declaredEnumEntries = listOf(
        TestVariable(
            name = "Front",
            javaType = "CardState",
            visibility = Visibility.PUBLIC,
        ),
        TestVariable(
            name = "Back",
            javaType = "CardState",
            visibility = Visibility.PUBLIC,
        ),
    ),
)
