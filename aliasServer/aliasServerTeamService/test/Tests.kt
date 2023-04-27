import commonTests.team.checkNameAndIdFieldsValue
import org.jetbrains.academy.test.system.models.classes.ConstructorGetter
import org.jetbrains.academy.test.system.models.method.TestMethodInvokeData
import org.junit.jupiter.api.Test

class Test {
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
        commonTests.team.generateTeamsForOneRoundMethodTest(
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
                ConstructorGetter(
                    parameterTypes = listOf(Int::class.java),
                    defaultParameterTypes = listOf(Int::class.java),
                )
            )
        )
        // Check the name field value
        checkNameAndIdFieldsValue(
            clazz,
            teamClass,
            getNameFromTeamMethod,
        ) { i: Int -> constructor.newInstance(i, 0, 0, null) }
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
}