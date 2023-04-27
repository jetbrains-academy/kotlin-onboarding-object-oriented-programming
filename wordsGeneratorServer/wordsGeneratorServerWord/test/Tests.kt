import commonTests.team.*
import jetbrains.kotlin.course.words.generator.util.words
import org.jetbrains.academy.test.system.models.classes.ConstructorGetter
import org.jetbrains.academy.test.system.models.classes.findClass
import org.jetbrains.academy.test.system.models.method.TestMethodInvokeData
import org.junit.jupiter.api.Test

class Test {
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
                val errorMessage = "The method ${generateNextWordMethod.prettyString()} must generate new word each time and remove the generated word from the words list"
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
        resetIdCounter(clazz)
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

        resetIdCounter(clazz)
        // Check the name and id fields value
        checkNameAndIdFieldsValue(
            clazz,
            teamClass,
            getNameFromTeamMethod,
            getIdFromTeamMethod
        ) { constructor.newInstance() }
    }

    private fun resetIdCounter(teamsClazz: Class<*>) {
        val idCounterField = teamsClazz.declaredFields.find { it.name == idCounterVariable.name }
            ?: error("Can not find the field ${idCounterVariable.name}")
        idCounterField.isAccessible = true
        idCounterField.set(teamsClazz, 0)
    }
}