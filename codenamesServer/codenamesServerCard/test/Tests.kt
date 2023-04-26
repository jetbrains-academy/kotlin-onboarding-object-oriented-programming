import models.ConstructorGetter
import models.TestClass
import models.findClass
import models.findMethod
import org.junit.jupiter.api.Test
import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.lang.reflect.Method

class Test {
    @Test
    fun cardStateTestClassTest() {
        val clazz = cardStateTestClass.checkBaseDefinition()
        cardStateTestClass.checkFieldsDefinition(clazz, toCheckDeclaredFieldsSize = false)
        cardStateTestClass.checkNoConstructors(clazz)
        cardStateTestClass.checkEnumEntryDefinition(clazz)
    }

    @Test
    fun cardTestClassTest() {
        val clazz = cardTestClass.checkBaseDefinition()
        cardTestClass.checkFieldsDefinition(clazz)

        val cardDataClazz = cardDataInterfaceTestClass.checkBaseDefinition()
        val cardStateClazz = cardStateTestClass.checkBaseDefinition()
        keyCardTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(parameterTypes = listOf(cardDataClazz, cardStateClazz)),
            )
        )
    }

    @Test
    fun cardDataInterfaceTestClassTest() {
        cardDataInterfaceTestClass.checkBaseDefinition()
    }

    @Test
    fun wordCardDataTestClassTest() {
        val clazz = wordCardDataTestClass.checkBaseDefinition()
        wordCardDataTestClass.checkFieldsDefinition(clazz)
    }

    @Test
    fun keyCardServiceTestClassTest() {
        val clazz = keyCardServiceTestClass.checkBaseDefinition()
        keyCardServiceTestClass.checkDeclaredMethods(clazz)
        val constructor = keyCardTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
            )
        )

        // Check the generateKeyCard method
        val method = clazz.methods.findMethod(generateKeyCardMethod)
        checkKeyCard(clazz, method, constructor, keyCardServiceTestClass)
    }

    private fun String.countMatches(pattern: String): Int {
        return this.split(pattern)
            .dropLastWhile { it.isEmpty() }
            .toTypedArray().size - 1
    }

    @Test
    fun keyCardTestClassTest() {
        val clazz = keyCardTestClass.checkBaseDefinition()
        keyCardTestClass.checkFieldsDefinition(clazz)
        val constructor = keyCardTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
                ConstructorGetter(defaultParameterTypes = listOf(List::class.java)),
            )
        )

        // Check the cells field value
        val method = clazz.methods.findMethod(getCellsFromKeyCardMethod)
        checkKeyCard(clazz, method, constructor, keyCardTestClass)
    }

    private fun checkKeyCard(
        clazz: Class<*>,
        method: Method,
        constructor: Constructor<*>,
        testClass: TestClass,
    ) {
        val previousCards = mutableListOf<String>()
        repeat(100) {
            val instance = try {
                constructor.newInstance()
            } catch (e: Exception) {
                assert(false) { "Can not create an instance of the class ${testClass.getFullName()}" }
            }
            val keyCard = testClass.invokeMethodWithoutArgs(clazz, instance, method).toString()
            assert(keyCard !in previousCards) { "You need to generate different key cards" }

            val cells = mapOf(
                "Violet" to expectedVariablesValues["VIOLET_CARDS_NUMBER"],
                "Pink" to expectedVariablesValues["PINK_CARDS_NUMBER"],
                "Black" to expectedVariablesValues["BLACK_CARDS_NUMBER"],
                "Gray" to expectedVariablesValues["GRAY_CARDS_NUMBER"],
            )
            cells.forEach { (type, number) ->
                assert(keyCard.countMatches("KeyCardCell(type=$type)") == number) { "The generated key card must have $number with the $type type" }
            }
            previousCards.add(keyCard)
        }
    }

    @Test
    fun utilObjectExtendedTestClassTest() {
        val clazz = utilObjectTestClass.checkBaseDefinition()
        utilObjectTestClass.checkFieldsDefinition(clazz)
    }

    @Test
    fun keyCardGeneratorTestClassTest() {
        val clazz = keyCardGeneratorTestClass.checkBaseDefinition()
        keyCardGeneratorTestClass.checkNoConstructors(clazz)
        keyCardGeneratorTestClass.checkDeclaredMethods(clazz)
    }

    @Test
    fun keyCardTypeTestClassTest() {
        val clazz = keyCardTypeTestClass.checkBaseDefinition()
        keyCardTypeTestClass.checkFieldsDefinition(clazz, toCheckDeclaredFieldsSize = false)
        keyCardTypeTestClass.checkNoConstructors(clazz)
        keyCardTypeTestClass.checkEnumEntryDefinition(clazz)
    }

    @Test
    fun utilObjectTestClassTest() {
        val clazz = utilObjectTestClass.checkBaseDefinition()
        utilObjectTestClass.checkFieldsDefinition(clazz, toCheckDeclaredFieldsSize = false)
        utilObjectTestClass.checkNoConstructors(clazz)
    }

    @Test
    fun utilObjectConstValuesTest() {
        val clazz = utilObjectTestClass.checkBaseDefinition()
        val instance = utilObjectTestClass.getObjectInstance(clazz)
        expectedVariablesValues.forEach { (name, expectedValue) ->
            val field = clazz.declaredFields.find { it.name == name }
                ?: error("Can not find the field $name")
            field.isAccessible = true
            val currentValue = field.get(instance)
            assert(expectedValue == currentValue) { "The const $name must be $expectedValue" }
        }
    }
}