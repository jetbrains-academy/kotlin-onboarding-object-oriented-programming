import models.findMethod
import org.junit.jupiter.api.Test
import java.lang.Exception

class Test {
    @Test
    fun identifierFactoryClassTest() {
        val clazz = identifierFactoryClass.checkBaseDefinition()
        identifierFactoryClass.checkFieldsDefinition(clazz)
        identifierFactoryClass.checkConstructorWithDefaultArguments(
            clazz,
            defaultParameterTypes = listOf(Int::class.java)
        )
        identifierFactoryClass.checkDeclaredMethods(clazz)
    }

    @Test
    fun uniqueIdentifierMethodTest() {
        val clazz = identifierFactoryClass.getJavaClass()
        val method = identifierFactoryClass.findMethod(clazz, uniqueIdentifierMethod)
        val instance = clazz.getConstructor().newInstance()
        for(i in 0..100) {
            val id = identifierFactoryClass.invokeMethodWithoutArgs(clazz, instance, method)
            assert(id == i) { "The ${uniqueIdentifierMethod.name} works incorrect. Try to get id $i-th time, it should be $i, but was $id" }
        }
    }

    @Test
    fun teamClassTest() {
        val clazz = teamClass.checkBaseDefinition()
        teamClass.checkFieldsDefinition(clazz)
        val constructor = teamClass.checkConstructorWithDefaultArguments(
            clazz,
            parameterTypes = listOf(Int::class.java),
            defaultParameterTypes = listOf(Int::class.java)
        )
        // Check the name field value
        constructor?.let {
            val method = clazz.methods.findMethod(getNameFromTeamMethod)
            for(i in 0..100) {
                val instance = try {
                    it.newInstance(i, 0, 0, null)
                } catch (e: Exception) {
                    assert(false) { "Can not create an instance of the class ${teamClass.getFullName()} with id = $i" }
                }
                val name = teamClass.invokeMethodWithoutArgs(clazz, instance, method)
                val teamName = "Team#${i + 1}"
                assert(teamName == name) { "For the team with id $i the name must be $teamName" }
            }

        }
    }
}