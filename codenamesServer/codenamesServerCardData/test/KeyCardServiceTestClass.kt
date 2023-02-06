import models.KotlinType
import models.TestClass
import models.TestMethod

internal val generateKeyCardMethod = TestMethod(
    "generateKeyCard",
    KotlinType(
        "KeyCard",
    ),
)

internal val keyCardServiceTestClass = TestClass(
    "KeyCardService",
    "jetbrains.kotlin.course.codenames.keyCard",
    customMethods = listOf(
        generateKeyCardMethod,
    ),
)
