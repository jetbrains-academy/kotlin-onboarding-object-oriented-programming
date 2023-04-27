import org.jetbrains.academy.test.system.models.classes.ConstructorGetter
import org.jetbrains.academy.test.system.models.method.TestMethodInvokeData
import org.junit.jupiter.api.Test

class Test {
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