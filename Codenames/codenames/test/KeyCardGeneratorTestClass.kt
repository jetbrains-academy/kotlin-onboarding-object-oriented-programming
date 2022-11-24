import models.ClassType
import models.KotlinType
import models.TestClass
import models.TestMethod

internal val keyCardGeneratorTestClass = TestClass(
    "KeyCardGenerator",
    "jetbrains.kotlin.course.codenames.utils",
    classType = ClassType.SAM_INTERFACE,
    customMethods = listOf(
        TestMethod(
            "generateData",
            KotlinType(
                "List",
                abbreviation = "jetbrains.kotlin.course.codenames.keyCard.KeyCardCell"
            ),
            returnTypeJava = "List",
        ),
    ),
)