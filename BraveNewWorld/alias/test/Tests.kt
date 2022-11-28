import jetbrains.kotlin.course.alias.util.words
import models.ConstructorGetter
import models.TestMethodInvokeData
import models.findMethod
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.reflect.InvocationTargetException

class Test {
    companion object {

        private val emptyList = emptyList<String>()
        private val listWithOneWord = listOf("dog")
        private val listWithSeveralWords = listOf("dog", "cat")

        private val expectedCardsListSize = words.size / 4
        private const val WORD = "Word"

        @JvmStatic
        fun toWordsMethodTestData() = listOf(
            // initial, expected
            Arguments.of(emptyList, emptyList.toListWithWordsString()),
            Arguments.of(listWithOneWord, listWithOneWord.toListWithWordsString()),
            Arguments.of(listWithSeveralWords, listWithSeveralWords.toListWithWordsString()),
        )

        private fun List<String>.toListWithWordsString() = "[${this.joinToString(", ") { "$WORD(word=$it)" }}]"

        private fun String.wordMatches() = Regex(WORD).findAll(this).toList().size

        private fun callGetCardByIndexMethod(invokeData: TestMethodInvokeData, index: Int) =
            cardServiceTestClass.invokeMethodWithArgs(
                args = arrayOf(index),
                invokeData = invokeData,
            ).toString()

        private fun callGenerateTeamsForOneRound(invokeData: TestMethodInvokeData, n: Int) =
            teamServiceTestClass.invokeMethodWithArgs(
                n,
                clazz = invokeData.clazz,
                instance = invokeData.instance,
                javaMethod = invokeData.method,
            )

        private fun callSaveGameResultsMethod(teams: Any, invokeData: TestMethodInvokeData): String {
            val field = invokeData.clazz.declaredFields.find { it.name == gameHistoryVariable.name }
                ?: error("Can not find the field ${gameHistoryVariable.name}")
            field.isAccessible = true

            // TODO: why gameResultsServiceTestClass.invokeMethodWithArgs does not work?
            invokeData.method.invoke(invokeData.instance, *arrayOf(teams))
            return field.get(invokeData.instance).toString()
        }
    }

    @Test
    fun identifierFactoryClassTest() {
        val clazz = identifierFactoryClass.checkBaseDefinition()
        identifierFactoryClass.checkFieldsDefinition(clazz)
        identifierFactoryClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
                ConstructorGetter(defaultParameterTypes = listOf(Int::class.java)),
            )
        )
        identifierFactoryClass.checkDeclaredMethods(clazz)
    }

    @Test
    fun uniqueIdentifierMethodTest() {
        val invokeData = TestMethodInvokeData(identifierFactoryClass, uniqueIdentifierMethod)
        for (i in 0..100) {
            val id =
                identifierFactoryClass.invokeMethodWithoutArgs(invokeData.clazz, invokeData.instance, invokeData.method)
            assert(id == i) { "The ${uniqueIdentifierMethod.name} works incorrect. Try to get id $i-th time, it should be $i, but was $id" }
        }
    }

    @Test
    fun teamClassTest() {
        val clazz = teamClass.checkBaseDefinition()
        teamClass.checkFieldsDefinition(clazz)
        val constructor = teamClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(
                    parameterTypes = listOf(Int::class.java),
                    defaultParameterTypes = listOf(Int::class.java),
                )
            )
        )
        // Check the name field value
        val method = clazz.methods.findMethod(getNameFromTeamMethod)
        for (i in 0..100) {
            val instance = try {
                constructor.newInstance(i, 0, 0, null)
            } catch (e: Exception) {
                assert(false) { "Can not create an instance of the class ${teamClass.getFullName()} with id = $i" }
            }
            val name = teamClass.invokeMethodWithoutArgs(clazz, instance, method)
            val teamName = "Team#${i + 1}"
            assert(teamName == name) { "For the team with id $i the name must be $teamName" }
        }
    }

    @Test
    fun teamTeamServiceTest() {
        val clazz = teamServiceTestClass.checkBaseDefinition()
        teamServiceCompanionTestClass.checkBaseDefinition()
        teamServiceTestClass.checkFieldsDefinition(clazz, false)
        val identifierFactoryClazz = identifierFactoryClass.getJavaClass()
        teamServiceTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
                ConstructorGetter(defaultParameterTypes = listOf(identifierFactoryClazz)),
            )
        )
        teamServiceTestClass.checkDeclaredMethods(clazz)
    }

    @Test
    fun generateTeamsForOneRoundMethodTest() {
        val invokeData = TestMethodInvokeData(teamServiceTestClass, generateTeamsForOneRoundMethod)
        val n = 5
        val teamsStorageMethod = invokeData.clazz.methods.findMethod(getTeamsStorageMethod)
        val teamsStorageSb = StringBuilder()
        repeat(n) {
            val teams = callGenerateTeamsForOneRound(invokeData, n)
            val expected = teamsOutput(it * n, n)
            assert(expected == teams.toString()) { "${generateTeamsForOneRoundMethod.name} must return $expected for teamsNumber = $n and $it-th attempt." }
            if (it > 0) {
                teamsStorageSb.append(", ")
            }
            teamsStorageSb.append(generateTeamsStringRepresentation(it * n, n, true).joinToString(", "))
            val teamsStorageRes = teamServiceTestClass.invokeMethodWithoutArgs(
                clazz = invokeData.clazz,
                instance = invokeData.instance,
                javaMethod = teamsStorageMethod
            ).toString()
            val expectedTeamsStorage = "{$teamsStorageSb}"
            assert(expectedTeamsStorage == teamsStorageRes) { "You need to save generated teams into the teamsStorage after each generation." }
        }
    }

    private fun generateTeamsStringRepresentation(startId: Int, n: Int, toAddId: Boolean = false): List<String> {
        var id = startId
        val teams = mutableListOf<String>()
        repeat(n) {
            val prefix = if (toAddId) {
                "$id="
            } else {
                ""
            }
            teams.add("${prefix}Team(id=$id, points=0)")
            id++
        }
        return teams
    }

    private fun teamsOutput(startId: Int, n: Int) =
        "[${generateTeamsStringRepresentation(startId, n).joinToString(", ")}]"

    @Test
    fun cardTest() {
        val clazz = cardTestClass.checkBaseDefinition()
        cardTestClass.checkFieldsDefinition(clazz)
        val constructor = cardTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(
                    parameterTypes = listOf(Int::class.java, List::class.java),
                )
            )
        )
        // Just check if the constructor works well
        // Unfortunately we can not check the type of the argument, because we don't have them at runtime
        constructor.newInstance(1, listOf("dog"))
    }

    @Test
    fun cardServiceTest() {
        val clazz = cardServiceTestClass.checkBaseDefinition()
        cardServiceCompanionTestClass.checkBaseDefinition()

        cardServiceTestClass.checkFieldsDefinition(clazz, false)
        val identifierFactoryClazz = identifierFactoryClass.getJavaClass()
        cardServiceTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
                ConstructorGetter(defaultParameterTypes = listOf(identifierFactoryClazz)),
            )
        )

        // Check WORDS_IN_CARD and cardsAmount values
        val instance = clazz.getConstructor().newInstance()
        val getCardsAmountJavaMethod = clazz.methods.findMethod(getCardsAmountMethod)
        val field = clazz.declaredFields.find { it.name == wordsInCardTestVariable.name }
            ?: error("Can not find the field ${wordsInCardTestVariable.name}")
        field.isAccessible = true
        val wordsInCardVariable = field.get(instance)
        assert(4 == wordsInCardVariable as Int) { "The value of the field ${wordsInCardTestVariable.name} must be 4." }
        val cardsAmount = identifierFactoryClass.invokeMethodWithoutArgs(clazz, instance, getCardsAmountJavaMethod)
        val expectedCardsAmount = words.size / wordsInCardVariable
        assert(expectedCardsAmount == cardsAmount as Int) { "The value in the field cardsAmount must be calculated as: words.size / WORDS_IN_CARD" }

        cardServiceTestClass.checkDeclaredMethods(clazz)
    }

    @ParameterizedTest
    @MethodSource("toWordsMethodTestData")
    fun toWordsMethodTest(words: List<String>, expected: String) {
        val invokeData = TestMethodInvokeData(cardServiceTestClass, toWordsMethod)
        val actualWords = cardServiceTestClass.invokeMethodWithArgs(
            args = arrayOf(words),
            invokeData = invokeData,
            isPrivate = true,
        ).toString()
        assert(expected == actualWords) { "For the list $words the method ${toWordsMethod.name} must return $expected." }
    }

    @Test
    fun generateCardsMethodTest() {
        val invokeData = TestMethodInvokeData(cardServiceTestClass, generateCardsMethod)
        (cardServiceTestClass.invokeMethodWithoutArgs(
            invokeData,
            isPrivate = true,
        ) as? ArrayList<*>)?.let { cards ->
            assert(expectedCardsListSize == cards.size) { "The method $generateCardsMethod must return a list of Cards with $expectedCardsListSize items." }
            cards.forEachIndexed { id, item ->
                val strItem = item.toString()
                // This method will be called during the class initialization, so we need to shift all ids
                assert((id + expectedCardsListSize).toString() in strItem) { "Each card must have an unique identifier." }
                assert(4 == strItem.wordMatches()) { "Each card must have only four words." }
            }
        } ?: assert(false) { "The method $generateCardsMethod must return a list of Cards" }
    }

    @Test
    fun getCardByIndexMethodTest() {
        val invokeData = TestMethodInvokeData(cardServiceTestClass, getCardByIndexMethod)
        assertThrows<InvocationTargetException>("\"The method ${getCardByIndexMethod.name} must throw an exception for index = -1.") {
            callGetCardByIndexMethod(invokeData, -1)
        }
        for (i in 0 until expectedCardsListSize) {
            try {
                val card = callGetCardByIndexMethod(invokeData, i)
                assert("id=$i" in card) { "The generated card at the position $i in the cards list must have id = $i." }
                assert(4 == card.wordMatches()) { "Each card must have only four words." }
            } catch (e: InvocationTargetException) {
                assert(false) { "The method ${getCardByIndexMethod.name} must not throw any exceptions for index = $i." }
            }
        }
    }

    @Test
    fun gameResultsServiceTest() {
        val clazz = gameResultsServiceTestClass.checkBaseDefinition()
        gameResultsServiceCompanionTestClass.checkBaseDefinition()
        gameResultsServiceTestClass.checkFieldsDefinition(clazz, false)
        cardServiceTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
            )
        )
        gameResultsServiceTestClass.checkDeclaredMethods(clazz)
    }

    @Test
    fun saveGameResultsMethodTest() {
        val teamInvokeData = TestMethodInvokeData(teamServiceTestClass, generateTeamsForOneRoundMethod)
        val teams = callGenerateTeamsForOneRound(teamInvokeData, 4)
        val gameResultsInvokeData = TestMethodInvokeData(gameResultsServiceTestClass, saveGameResultsMethod)
        assert(
            "$teams" in callSaveGameResultsMethod(
                teams,
                gameResultsInvokeData
            )
        ) { "Try to save the game results for the teams: $teams, but they are not in the ${gameHistoryVariable.name} field." }
    }

    @Test
    fun getAllGameResultsMethodTest() {
        val invokeData = TestMethodInvokeData(gameResultsServiceTestClass, getAllGameResultsMethod)
        val field = invokeData.clazz.declaredFields.find { it.name == gameHistoryVariable.name }
            ?: error("Can not find the field ${gameHistoryVariable.name}")
        field.isAccessible = true
        val emptyResults = field.get(invokeData.instance) as ArrayList<*>
        assert(emptyResults.size == 0) { "After initialization of the class ${gameResultsServiceTestClass.name} the field ${gameHistoryVariable.name} must store an empty list." }
        val reversedEmptyResults = gameResultsServiceTestClass.invokeMethodWithoutArgs(invokeData)
        assert("${emptyResults.reversed()}" == "$reversedEmptyResults") { "Try to call the ${getAllGameResultsMethod.name} on an empty list, but got $reversedEmptyResults" }

        val teamInvokeData = TestMethodInvokeData(teamServiceTestClass, generateTeamsForOneRoundMethod)
        val teams = callGenerateTeamsForOneRound(teamInvokeData, 3)
        val gameResultsInvokeData = TestMethodInvokeData(gameResultsServiceTestClass, saveGameResultsMethod)
        callSaveGameResultsMethod(teams, gameResultsInvokeData)
        val notEmptyResults = field.get(invokeData.instance) as ArrayList<*>
        val reversedNotEmptyResults = gameResultsServiceTestClass.invokeMethodWithoutArgs(invokeData)
        assert("${notEmptyResults.reversed()}" == "$reversedNotEmptyResults") { "Try to call the ${getAllGameResultsMethod.name} on the $notEmptyResults list, got $reversedNotEmptyResults" }
    }
}