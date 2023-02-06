import org.junit.jupiter.api.Test
class Test {
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
        utilObjectTestClass.checkFieldsDefinition(clazz)
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