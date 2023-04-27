import commonTests.team.*
import models.ConstructorGetter
import models.findClass
import org.junit.jupiter.api.Test

class Test {
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