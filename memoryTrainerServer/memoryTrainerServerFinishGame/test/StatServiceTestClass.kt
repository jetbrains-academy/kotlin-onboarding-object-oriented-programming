import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val historyVariable = TestVariable(
    name = "history",
    javaType = "List",
    kotlinType = TestKotlinType(
        "MutableList",
        params = listOf("jetbrains.kotlin.course.card.trainer.stat.Stat")
    ),
    // Because it is inside companion object
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAL,
    isStatic = true,
)

internal val getHistoryMethod = TestMethod(
    name = "getHistory",
    returnType = TestKotlinType(
        "List",
        params = listOf("jetbrains.kotlin.course.card.trainer.stat.Stat")
    ),
    returnTypeJava = "List",
)

internal val saveMethod = TestMethod(
    name = "save",
    returnType = TestKotlinType("Unit"),
    returnTypeJava = "void",
    arguments = listOf(
        TestVariable(
            name = "known",
            javaType = "List",
            kotlinType = TestKotlinType("List", params = listOf("kotlin.String")),
        ),
        TestVariable(
            name = "unknown",
            javaType = "List",
            kotlinType = TestKotlinType("List", params = listOf("kotlin.String")),
        )
    )
)


internal val statServiceTestClass = TestClass(
    "StatService",
    "jetbrains.kotlin.course.card.trainer.stat",
    declaredFields = listOf(
        historyVariable
    ),
    customMethods = listOf(
        getHistoryMethod,
        saveMethod
    ),
)

internal val statServiceCompanionTestClass = TestClass(
    "StatService\$Companion",
    "jetbrains.kotlin.course.card.trainer.stat"
)