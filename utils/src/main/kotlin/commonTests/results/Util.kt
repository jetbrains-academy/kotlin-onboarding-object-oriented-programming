package commonTests.results

import commonTests.team.callGenerateTeamsForOneRound
import models.TestClass
import models.TestMethod
import models.TestMethodInvokeData
import models.Variable

@Suppress("SpreadOperator", "ForbiddenComment")
fun callSaveGameResultsMethod(teams: Any, invokeData: TestMethodInvokeData, gameHistoryVariable: Variable): String {
    val field = invokeData.clazz.declaredFields.find { it.name == gameHistoryVariable.name }
        ?: error("Can not find the field ${gameHistoryVariable.name}")
    field.isAccessible = true
    // TODO: why gameResultsServiceTestClass.invokeMethodWithArgs does not work?
    invokeData.method.invoke(invokeData.instance, *arrayOf(teams))
    return field.get(invokeData.instance).toString()
}

fun saveGameResultsMethodTest(
    teamServiceTestClass: TestClass,
    generateTeamsForOneRoundMethod: TestMethod,
    gameResultsServiceTestClass: TestClass,
    saveGameResultsMethod: TestMethod,
    gameHistoryVariable: Variable,
) {
    val teamInvokeData = TestMethodInvokeData(teamServiceTestClass, generateTeamsForOneRoundMethod)
    val teams = teamServiceTestClass.callGenerateTeamsForOneRound(teamInvokeData, 4)
    val gameResultsInvokeData = TestMethodInvokeData(gameResultsServiceTestClass, saveGameResultsMethod)
    assert(
        "$teams" in callSaveGameResultsMethod(
            teams,
            gameResultsInvokeData,
            gameHistoryVariable,
        )
    ) { "Try to save the game results for the teams: $teams, but they are not in the ${gameHistoryVariable.name} field." }
}

@Suppress("LongParameterList", "MaxLineLength")
fun getAllGameResultsMethodTest(
    gameResultsServiceTestClass: TestClass,
    getAllGameResultsMethod: TestMethod,
    gameHistoryVariable: Variable,
    teamServiceTestClass: TestClass,
    generateTeamsForOneRoundMethod: TestMethod,
    saveGameResultsMethod: TestMethod,
) {
    val invokeData = TestMethodInvokeData(gameResultsServiceTestClass, getAllGameResultsMethod)
    val field = invokeData.clazz.declaredFields.find { it.name == gameHistoryVariable.name }
        ?: error("Can not find the field ${gameHistoryVariable.name}")
    field.isAccessible = true
    val emptyResults = field.get(invokeData.instance) as ArrayList<*>
    assert(emptyResults.size == 0) { "After initialization of the class ${gameResultsServiceTestClass.name} the field ${gameHistoryVariable.name} must store an empty list." }
    val reversedEmptyResults = gameResultsServiceTestClass.invokeMethodWithoutArgs(invokeData)
    assert("${emptyResults.reversed()}" == "$reversedEmptyResults") { "Try to call the ${getAllGameResultsMethod.name} on an empty list, but got $reversedEmptyResults" }

    val teamInvokeData = TestMethodInvokeData(teamServiceTestClass, generateTeamsForOneRoundMethod)
    val teams = teamServiceTestClass.callGenerateTeamsForOneRound(teamInvokeData, 3)
    val gameResultsInvokeData = TestMethodInvokeData(gameResultsServiceTestClass, saveGameResultsMethod)
    callSaveGameResultsMethod(teams, gameResultsInvokeData, gameHistoryVariable)
    val notEmptyResults = field.get(invokeData.instance) as ArrayList<*>
    val reversedNotEmptyResults = gameResultsServiceTestClass.invokeMethodWithoutArgs(invokeData)
    assert("${notEmptyResults.reversed()}" == "$reversedNotEmptyResults") { "Try to call the ${getAllGameResultsMethod.name} on the $notEmptyResults list, got $reversedNotEmptyResults" }
}
