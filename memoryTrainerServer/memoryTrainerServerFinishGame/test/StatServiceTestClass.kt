import models.*

internal val historyVariable = Variable(
    name = "history",
    javaType = "List",
    kotlinType = KotlinType(
        "MutableList",
        params = listOf("jetbrains.kotlin.course.card.trainer.stat.Stat")
    ),
    // Because it is inside companion object
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAR,
    isStatic = true,
)

internal val getHistoryMethod = TestMethod(
    name = "getHistory",
    returnType = KotlinType(
        "List",
        params = listOf("jetbrains.kotlin.course.card.trainer.stat.Stat")
    ),
    returnTypeJava = "List",
)

internal val saveMethod = TestMethod(
    name = "save",
    returnType = KotlinType("Unit"),
    returnTypeJava = "void",
    arguments = listOf(
        Variable(
            name = "known",
            javaType = "List",
            kotlinType = KotlinType("List", params = listOf("kotlin.String")),
        ),
        Variable(
            name = "unknown",
            javaType = "List",
            kotlinType = KotlinType("List", params = listOf("kotlin.String")),
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