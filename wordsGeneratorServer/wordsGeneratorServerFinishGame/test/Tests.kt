import commonTests.team.*
import jetbrains.kotlin.course.words.generator.util.words
import org.jetbrains.academy.test.system.models.classes.ConstructorGetter
import org.jetbrains.academy.test.system.models.classes.findClass
import org.jetbrains.academy.test.system.models.method.TestMethodInvokeData
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.reflect.Field

class Test {
    companion object {
        @JvmStatic
        fun isValidWordMethodData() = listOf(
            // keyWord, newWord, isValid
            Arguments.of("photomechanochemistry", "", false),
            Arguments.of("photomechanochemistry", "lalala", false),
            Arguments.of("photomechanochemistry", "photo", true),
            Arguments.of("photomechanochemistry", "photoooooooo", false),
            Arguments.of("photomechanochemistry", "photophoto", false),
        )
    }

    @Test
    fun gameResultsServiceTest() {
        val clazz = gameResultsServiceTestClass.checkBaseDefinition()
        gameResultsServiceCompanionTestClass.checkBaseDefinition()
        gameResultsServiceTestClass.checkFieldsDefinition(clazz, false)
        gameResultsServiceTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
            )
        )
        gameResultsServiceTestClass.checkDeclaredMethods(clazz)
    }

    @Test
    fun saveGameResultsMethodTest() {
        commonTests.results.saveGameResultsMethodTest(
            teamServiceTestClass,
            generateTeamsForOneRoundMethod,
            gameResultsServiceTestClass,
            saveGameResultsMethod,
            gameHistoryVariable,
            teamClassTestClass = teamClass
        )
    }

    @Test
    fun getAllGameResultsMethodTest() {
        commonTests.results.getAllGameResultsMethodTest(
            gameResultsServiceTestClass,
            getAllGameResultsMethod,
            gameHistoryVariable,
            teamServiceTestClass,
            generateTeamsForOneRoundMethod,
            saveGameResultsMethod,
        )
    }

    @ParameterizedTest
    @MethodSource("isValidWordMethodData")
    fun isValidWordMethodTest(keyWord: String, newWord: String, isValid: Boolean) {
        val invokeData = TestMethodInvokeData(wordServiceTestClass, isValidWordMethod)
        (wordServiceTestClass.invokeMethodWithArgs(
            args = arrayOf(keyWord, newWord),
            invokeData = invokeData,
        ) as? Boolean)?.let {
            assert(isValid == it) { "For the keyWord $keyWord and newWord $newWord the method ${isValidWordMethod.name} must return $isValid." }
        }
            ?: assert(false) { "The method ${isValidWordMethod.prettyString()} failed with keyWord $keyWord and newWord $newWord, but must return $isValid" }
    }

    @Test
    fun isNewWordMethodTest() {
        val invokeData = TestMethodInvokeData(wordServiceTestClass, isNewWordMethod)
        val previousWordsField = invokeData.clazz.declaredFields.find { it.name == previousWordsTestVariable.name }
            ?: error("Can not find the field ${previousWordsTestVariable.name}")
        previousWordsField.isAccessible = true
        val emptyResults = previousWordsField.get(invokeData.instance) as Map<*, *>
        assert(emptyResults.isEmpty()) { "After initialization of the class ${wordServiceTestClass.name} the field ${previousWordsTestVariable.name} must store an empty map." }

        val keyWord = "photomechanochemistry"
        val newWord = "photo"
        invokeData.invokeIsNewWordMethod(keyWord, newWord, true, "a new word")
        previousWordsField.checkPreviousWordsMap(
            invokeData,
            keyWord,
            1,
            "Try to add a new word $newWord with key $keyWord that was not exist, the expected size of previousWords[$keyWord] must be 1, but was"
        )
        invokeData.invokeIsNewWordMethod(keyWord, newWord, false, "an existing word")
        previousWordsField.checkPreviousWordsMap(
            invokeData,
            keyWord,
            1,
            "Try to add a new word $newWord with key $keyWord that was exist, the expected size of previousWords[$keyWord] must be 1, but was"
        )
        invokeData.invokeIsNewWordMethod(keyWord, newWord, false, "an existing word")
        previousWordsField.checkPreviousWordsMap(
            invokeData,
            keyWord,
            1,
            "Try to add a new word $newWord with key $keyWord that was exist, the expected size of previousWords[$keyWord] must be 1, but was"
        )
        invokeData.invokeIsNewWordMethod(keyWord, "$newWord$newWord", true, "a new word")
        previousWordsField.checkPreviousWordsMap(
            invokeData,
            keyWord,
            2,
            "Try to add a new word $newWord with key $keyWord that was not exist and the list of words was not empty, the expected size of previousWords[$keyWord] must be 2, but was"
        )
    }

    private fun Field.checkPreviousWordsMap(
        invokeData: TestMethodInvokeData,
        keyWord: String,
        expectedSize: Int,
        errorMessagePrefix: String
    ) {
        val previousWords = this.get(invokeData.instance)
        (previousWords as? Map<String, List<*>>)?.let {
            val actualSize = previousWords[keyWord]?.size ?: 0
            assert(expectedSize == actualSize) { "$errorMessagePrefix $actualSize!" }
        }
            ?: assert(false) { "Try to get previousWords field, it must have MutableMap<String, MutableList<Word>> type, but it does not!" }
    }

    private fun TestMethodInvokeData.invokeIsNewWordMethod(
        keyWord: String,
        newWord: String,
        expected: Boolean,
        errorMessageClarification: String
    ) {
        (wordServiceTestClass.invokeMethodWithArgs(
            args = arrayOf(keyWord, newWord),
            invokeData = this,
        ) as? Boolean)?.let {
            assert(expected == it) { "Try to call the ${isNewWordMethod.name} with the keyWord $keyWord and $errorMessageClarification in the map, it must return $expected" }
        }
            ?: assert(false) { "Try to call the ${isNewWordMethod.name} with the keyWord $keyWord and $errorMessageClarification, it must return $expected, but an unexpected error was occurred" }
    }

    @Test
    fun wordServiceTest() {
        val clazz = wordServiceTestClass.checkBaseDefinition()
        wordServiceCompanionTestClass.checkBaseDefinition()

        wordServiceTestClass.checkFieldsDefinition(clazz, false)
        wordServiceTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
            )
        )

        // Check numberOfWords value
        val instance = clazz.getConstructor().newInstance()
        val field = clazz.declaredFields.find { it.name == numberOfWordsTestVariable.name }
            ?: error("Can not find the field ${numberOfWordsTestVariable.name}")
        field.isAccessible = true
        val wordsInCardVariable = field.get(instance)
        assert(words.size == wordsInCardVariable as Int) { "The value of the field ${numberOfWordsTestVariable.name} must be ${words.size}." }

        wordServiceTestClass.checkDeclaredMethods(clazz)
    }

    @Test
    fun generateNextWordMethodTest() {
        val invokeData = TestMethodInvokeData(wordServiceTestClass, generateNextWordMethod)
        val generatedWords = mutableListOf<String>()
        var currentWordsSize = words.size
        repeat(words.size) {
            (wordServiceTestClass.invokeMethodWithoutArgs(
                invokeData,
            ) as? String)?.let { word ->
                val errorMessage =
                    "The method ${generateNextWordMethod.prettyString()} must generate new word each time and remove the generated word from the words list"
                assert(word !in generatedWords) { errorMessage }
                currentWordsSize--
                assert(words.size == currentWordsSize) { errorMessage }
            } ?: assert(false) { "The method ${generateNextWordMethod.prettyString()} must return a new Word" }
        }
    }

    @Test
    fun teamTeamServiceTest() {
        val clazz = teamServiceTestClass.checkBaseDefinition()
        teamServiceCompanionTestClass.checkBaseDefinition()
        teamServiceTestClass.checkFieldsDefinition(clazz, false)
        teamServiceTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
            )
        )
        teamServiceTestClass.checkDeclaredMethods(clazz)
    }

    @Test
    fun generateTeamsForOneRoundMethodTest() {
        val clazz = teamClass.findClass()
        resetIdCounter(clazz, idCounterVariable)
        generateTeamsForOneRoundMethodTest(
            teamServiceTestClass,
            generateTeamsForOneRoundMethod,
            getTeamsStorageMethod,
            customErrorMessage = "The `val teamsStorage = TODO(\"\")` was not added into `TeamService` or was added with an incorrect type or with an incorrect access modifier!"
        )
    }

    @Test
    fun teamClassTest() {
        val clazz = teamClass.checkBaseDefinition()
        teamClass.checkFieldsDefinition(clazz)
        val constructor = teamClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
                ConstructorGetter(defaultParameterTypes = listOf(Int::class.java)),
                ConstructorGetter(defaultParameterTypes = listOf(Int::class.java, Int::class.java)),
            )
        )

        resetIdCounter(clazz, idCounterVariable)
        // Check the name and id fields value
        checkNameAndIdFieldsValue(
            clazz,
            teamClass,
            getNameFromTeamMethod,
            getIdFromTeamMethod
        ) { constructor.newInstance() }
    }
}