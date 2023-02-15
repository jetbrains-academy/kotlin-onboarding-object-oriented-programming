import models.ClassType
import models.KotlinType
import models.TestClass
import models.TestMethod

internal val cardSequenceGeneratorTestClass = TestClass(
    "CardSequenceGenerator",
    "jetbrains.kotlin.course.card.trainer.card",
    classType = ClassType.SAM_INTERFACE,
    customMethods = listOf(
        TestMethod(
            "generateCards",
            KotlinType(
                "List",
                params = listOf("jetbrains.kotlin.course.card.trainer.card.Card")
            ),
            returnTypeJava = "List",
        ),
    ),
)
