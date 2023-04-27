import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.classes.ClassType
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod

internal val keyCardGeneratorTestClass = TestClass(
    "KeyCardGenerator",
    "jetbrains.kotlin.course.codenames.utils",
    classType = ClassType.SAM_INTERFACE,
    customMethods = listOf(
        TestMethod(
            "generateData",
            TestKotlinType(
                "List",
                abbreviation = "jetbrains.kotlin.course.codenames.keyCard.KeyCardCell"
            ),
            returnTypeJava = "List",
        ),
    ),
)
