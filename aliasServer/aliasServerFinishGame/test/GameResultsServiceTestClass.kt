import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val getAllGameResultsMethod = TestMethod(
    name = "getAllGameResults",
    returnType = TestKotlinType(
        "List",
        abbreviation = "kotlin.collections.List<jetbrains.kotlin.course.alias.results.GameResult>"
    ),
    returnTypeJava = "List",
)

internal val saveGameResultsMethod = TestMethod(
    name = "saveGameResults",
    returnType = TestKotlinType("Unit"),
    returnTypeJava = "void",
    arguments = listOf(
        TestVariable(
            name = "result",
            javaType = "List",
            kotlinType = TestKotlinType(
                "List",
                params = listOf("jetbrains.kotlin.course.alias.results.GameResult")
            ),
        ),
    ),
)

internal val gameHistoryVariable = TestVariable(
    name = "gameHistory",
    javaType = "List",
    kotlinType = TestKotlinType(
        "List",
        params = listOf("jetbrains.kotlin.course.alias.results.GameResult")
    ),
    // Because it is inside companion object
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAL,
    isStatic = true,
)

internal val gameResultsServiceTestClass = TestClass(
    "GameResultsService",
    "jetbrains.kotlin.course.alias.results",
    declaredFields = listOf(
        gameHistoryVariable,
    ),
    customMethods = listOf(
        getAllGameResultsMethod,
        saveGameResultsMethod,
    ),
)

internal val gameResultsServiceCompanionTestClass = TestClass(
    "GameResultsService\$Companion",
    "jetbrains.kotlin.course.alias.results",
)