import models.ConstructorGetter
import org.junit.jupiter.api.Test

class Test {
    // TODO: test randomCardGenerator,getNextCard and startNewGame
    @Test
    fun cardServiceTest() {
        val clazz = cardServiceTestClass.checkBaseDefinition()
        cardServiceCompanionTestClass.checkBaseDefinition()
        cardServiceTestClass.checkFieldsDefinition(clazz, false)
        cardServiceTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
            )
        )
        cardServiceTestClass.checkDeclaredMethods(clazz)
    }
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