import models.ConstructorGetter
import org.junit.jupiter.api.Test

class Test {
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