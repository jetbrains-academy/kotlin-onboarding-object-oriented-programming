import org.jetbrains.academy.test.system.models.classes.ConstructorGetter
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun cardSequenceGeneratorTestClassTest() {
        val clazz = cardSequenceGeneratorTestClass.checkBaseDefinition()
        cardSequenceGeneratorTestClass.checkNoConstructors(clazz)
        cardSequenceGeneratorTestClass.checkDeclaredMethods(clazz)
    }

    @Test
    fun cardTestClassTest() {
        val clazz = cardTestClass.checkBaseDefinition()
        cardTestClass.checkFieldsDefinition(clazz)

        cardTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(
                    parameterTypes = listOf(String::class.java, String::class.java),
                    toAddDefaultConstructorMarker=true
                ),
            )
        )
    }
}