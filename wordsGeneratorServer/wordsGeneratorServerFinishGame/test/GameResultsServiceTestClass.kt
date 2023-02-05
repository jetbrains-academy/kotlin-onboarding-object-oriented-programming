import models.*

internal val getAllGameResultsMethod = TestMethod(
    name = "getAllGameResults",
    returnType = KotlinType(
        "List",
        abbreviation = "kotlin.collections.List<jetbrains.kotlin.course.words.generator.results.GameResult>"
    ),
    returnTypeJava = "List",
)

internal val saveGameResultsMethod = TestMethod(
    name = "saveGameResults",
    returnType = KotlinType("Unit"),
    returnTypeJava = "void",
    arguments = listOf(
        Variable(
            name = "result",
            javaType = "List",
            kotlinType = KotlinType(
                "List",
                params = listOf("jetbrains.kotlin.course.words.generator.results.GameResult")
            ),
        ),
    ),
)

internal val gameHistoryVariable = Variable(
    name = "gameHistory",
    javaType = "List",
    kotlinType = KotlinType(
        "List",
        params = listOf("jetbrains.kotlin.course.words.generator.results.GameResult")
    ),
    // Because it is inside companion object
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAL,
    isStatic = true,
)

internal val gameResultsServiceTestClass = TestClass(
    "GameResultsService",
    "jetbrains.kotlin.course.words.generator.results",
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
    "jetbrains.kotlin.course.words.generator.results",
)