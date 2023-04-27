import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.classes.ClassType
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod

internal val cardSequenceGeneratorTestClass = TestClass(
    "CardSequenceGenerator",
    "jetbrains.kotlin.course.card.trainer.card",
    classType = ClassType.SAM_INTERFACE,
    customMethods = listOf(
        TestMethod(
            "generateCards",
            TestKotlinType(
                "List",
                params = listOf("jetbrains.kotlin.course.card.trainer.card.Card")
            ),
            returnTypeJava = "List",
        ),
    ),
)
