import commonTests.team.checkNameAndIdFieldsValue
import models.*
import org.junit.jupiter.api.Test

class Test {
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