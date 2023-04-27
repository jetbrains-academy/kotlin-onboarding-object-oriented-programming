import commonTests.team.*
import org.jetbrains.academy.test.system.models.classes.ConstructorGetter
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun teamClassTest() {
        val clazz = teamClass.checkBaseDefinition()
        teamClass.checkFieldsDefinition(clazz)
        val constructor = teamClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
                ConstructorGetter(defaultParameterTypes = listOf(Int::class.java)),
                ConstructorGetter(defaultParameterTypes = listOf(Int::class.java, Int::class.java)),
            )
        )

        resetIdCounter(clazz)
        // Check the name and id fields value
        checkNameAndIdFieldsValue(
            clazz,
            teamClass,
            getNameFromTeamMethod,
            getIdFromTeamMethod
        ) { constructor.newInstance() }
    }

    private fun resetIdCounter(teamsClazz: Class<*>) {
        val idCounterField = teamsClazz.declaredFields.find { it.name == idCounterVariable.name }
            ?: error("Can not find the field ${idCounterVariable.name}")
        idCounterField.isAccessible = true
        idCounterField.set(teamsClazz, 0)
    }
}