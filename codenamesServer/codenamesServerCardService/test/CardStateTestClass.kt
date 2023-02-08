import models.ClassType
import models.TestClass
import models.Variable
import models.Visibility

internal val cardStateTestClass = TestClass(
    "CardState",
    "jetbrains.kotlin.course.codenames.card",
    classType = ClassType.ENUM,
    declaredEnumEntries = listOf(
        Variable(
            name = "Front",
            javaType = "CardState",
            visibility = Visibility.PUBLIC,
        ),
        Variable(
            name = "Back",
            javaType = "CardState",
            visibility = Visibility.PUBLIC,
        ),
    ),
)
