import org.junit.jupiter.api.Test

class Test {
    @Test
    fun utilObjectTestClassTest() {
        val clazz = utilObjectTestClass.checkBaseDefinition()
        // TODO: Delete the false flag in the final version
        utilObjectTestClass.checkFieldsDefinition(clazz, toCheckDeclaredFieldsSize = false)
        utilObjectTestClass.checkNoConstructors(clazz)
    }

    @Test
    fun utilObjectConstValuesTest() {
        val clazz = utilObjectTestClass.checkBaseDefinition()
        val instance = utilObjectTestClass.getObjectInstance(clazz)
        utilObjectTestClass.declaredFields.forEach { currentConst ->
            val field = clazz.declaredFields.find { it.name == currentConst.name }
                ?: error("Can not find the field ${currentConst.name}")
            field.isAccessible = true
            val currentValue = field.get(instance)
            val expectedValue = expectedVariablesValues[currentConst.name]
                ?: error("Can not find the value for the const ${currentConst.name}")
            assert(expectedValue == currentValue) { "The const ${currentConst.name} must be $expectedValue" }
        }
    }

    @Test
    fun keyCardTypeTestClassTest() {
        val clazz = keyCardTypeTestClass.checkBaseDefinition()
        keyCardTypeTestClass.checkFieldsDefinition(clazz, toCheckDeclaredFieldsSize = false)
        keyCardTypeTestClass.checkNoConstructors(clazz)
        keyCardTypeTestClass.checkEnumEntryDefinition(clazz)
    }

    @Test
    fun keyCardGeneratorTestClassTest() {
        val clazz = keyCardGeneratorTestClass.checkBaseDefinition()
        keyCardGeneratorTestClass.checkNoConstructors(clazz)
        keyCardGeneratorTestClass.checkDeclaredMethods(clazz)
    }
    @Test
    fun utilObjectExtendedTestClassTest() {
        val clazz = utilObjectTestClass.checkBaseDefinition()
        utilObjectTestClass.checkFieldsDefinition(clazz)
    }

    // Get utilObject, get
}