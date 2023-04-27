import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod

internal val generateKeyCardMethod = TestMethod(
    "generateKeyCard",
    TestKotlinType(
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
