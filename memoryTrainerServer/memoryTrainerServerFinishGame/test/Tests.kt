import jetbrains.kotlin.course.card.trainer.util.countries
import org.jetbrains.academy.test.system.models.classes.ConstructorGetter
import org.jetbrains.academy.test.system.models.method.TestMethodInvokeData
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.reflect.Field
import kotlin.jvm.internal.DefaultConstructorMarker

class Test {
    @Test
    fun statTestClassTest() {
        val clazz = statTestClass.checkBaseDefinition()
        statTestClass.checkFieldsDefinition(clazz)

        statTestClass.checkConstructors(
            clazz, listOf(
                ConstructorGetter(
                    parameterTypes = listOf(List::class.java, List::class.java),
                ),
            )
        )
    }

    @Test
    fun statServiceTestClassTest() {
        val clazz = statServiceTestClass.checkBaseDefinition()
        statServiceCompanionTestClass.checkBaseDefinition()
        statServiceTestClass.checkFieldsDefinition(clazz, false)
        statServiceTestClass.checkConstructors(
            clazz, listOf(
                ConstructorGetter(),
            )
        )
        statServiceTestClass.checkDeclaredMethods(clazz)
    }

    @Test
    fun saveMethodTest() {
        val invokeData = TestMethodInvokeData(statServiceTestClass, saveMethod)
        val historyField = getField(invokeData, historyVariable.name)

        val n = 100
        repeat(n) {
            val (known, unknown) = invokeSaveMethod(invokeData)
            val historyRes = historyField.get(invokeData.instance).toString()
            val knownFields = known.convertToBack()
            assert(knownFields.all { it in historyRes }) { "Try to call ${saveMethod.name} method with input data: known = $known and unknown = $unknown. All countries should be in ${historyVariable.name} after this call, but they were not" }
            val unknownFields = unknown.convertToBack()
            assert(unknownFields.all { it in historyRes }) { "Try to call ${saveMethod.name} method with input data: known = $known and unknown = $unknown. All countries should be in ${historyVariable.name} after this call, but they were not" }
            val stat = convertToStat(known, unknown)
            assert(stat in historyRes) { { "Try to call ${saveMethod.name} method with input data: known = $known and unknown = $unknown. The stat $stat should be in ${historyVariable.name} after this call, but it was not" } }
        }
    }

    private fun List<String>.convertToBack() = map { "Back(country=$it)" }

    private fun convertToStat(known: List<String>, unknown: List<String>) =
        "Stat(knownBacks=[${known.convertToBack().joinToString(", ")}], unknownBacks=[${
            unknown.convertToBack().joinToString(", ")
        }])"


    private fun invokeSaveMethod(invokeData: TestMethodInvokeData): Pair<List<String>, List<String>> {
        val shuffled = countries.values.shuffled()
        val known = shuffled.take(5)
        val unknown = shuffled.takeLast(5)
        invokeData.method.invoke(invokeData.instance, known, unknown)
        return Pair(known, unknown)
    }

    @Test
    fun getHistoryMethodTest() {
        val saveInvokeData = TestMethodInvokeData(statServiceTestClass, saveMethod)

        val invokeData = TestMethodInvokeData(statServiceTestClass, getHistoryMethod)
        var history = invokeData.method.invoke(invokeData.instance).toString()
        assert(history == "[]") { "For empty ${historyVariable.name} ${getHistoryMethod.name} method should return an empty list" }

        val n = 100
        val actualHistory = mutableListOf<String>()
        repeat(n) {
            val (known, unknown) = invokeSaveMethod(saveInvokeData)
            val stat = convertToStat(known, unknown)
            actualHistory.add(stat)

            history = invokeData.method.invoke(invokeData.instance).toString()
            assert(
                actualHistory.reversed().toString() == history
            ) { "${getHistoryMethod.name} method should return a reversed list of ${historyVariable.name}" }
        }
    }

    @Test
    fun cardServiceTest() {
        val clazz = cardServiceTestClass.checkBaseDefinition()
        val companion = cardServiceCompanionTestClass.checkBaseDefinition()
        cardServiceCompanionTestClass.checkDeclaredMethods(companion)
        cardServiceTestClass.checkFieldsDefinition(clazz, false)
        cardServiceTestClass.checkConstructors(
            clazz, listOf(
                ConstructorGetter(),
            )
        )
        cardServiceTestClass.checkDeclaredMethods(clazz)
    }

    private fun getField(invokeData: TestMethodInvokeData, name: String): Field {
        val field = invokeData.clazz.declaredFields.find { it.name == name }
        assert(field != null) { "Can not find field ${cardsVariable.name}" }
        field!!.isAccessible = true
        return field
    }

    @Test
    fun getNextCardMethodTest() {
        val invokeData = TestMethodInvokeData(cardServiceTestClass, getNextCardMethod)
        val cardsField = getField(invokeData, cardsVariable.name)

        val n = countries.size
        val previousCards = mutableListOf<String>()

        var cardsRes = cardsField.get(invokeData.instance).toString()
        assert(cardsRes.parseCards().size - 1 == countries.size) { "The initial number of cards in ${cardsVariable.name} should be the same with the number of pairs in the countries map" }
        repeat(n) { i ->
            val card = cardServiceTestClass.invokeMethodWithoutArgs(
                clazz = invokeData.clazz,
                instance = invokeData.instance,
                javaMethod = invokeData.method,
            ).toString()
            assert(card !in previousCards) { "${getNextCardMethod.name} should return new card each call" }
            previousCards.add(card)

            cardsRes = cardsField.get(invokeData.instance).toString()
            assert(cardsRes.parseCards().size == countries.size - i) { "After each call of ${getNextCardMethod.name} you need to drop one card from ${cardsVariable.name}" }
        }
        cardsRes = cardsField.get(invokeData.instance).toString()
        assert(cardsRes == "[]") { "If we run ${getNextCardMethod.name} $n times the list of cards in ${cardsVariable.name} should be empty" }

        assertThrows<java.lang.reflect.InvocationTargetException>("You need to throw an error if ${cardsVariable.name} is empty and you try to run ${getNextCardMethod.name} method") {
            cardServiceTestClass.invokeMethodWithoutArgs(
                clazz = invokeData.clazz,
                instance = invokeData.instance,
                javaMethod = invokeData.method,
            ).toString()
        }
    }

    private fun String.parseCards() = drop(1).dropLast(1).split("Card(")

    @Test
    fun randomCardGeneratorMethodTest() {
        val constructor = DefaultConstructorMarker::class.java.declaredConstructors.first()
        constructor.isAccessible = true
        val defaultConstructorMarkerInstance = constructor.newInstance()

        val invokeData = TestMethodInvokeData(
            cardServiceCompanionTestClass,
            generateNewCardsSequenceMethod,
            constructorArgumentsTypes = listOf(DefaultConstructorMarker::class.java),
            constructorArguments = listOf(defaultConstructorMarkerInstance)
        )
        val previousSequences = mutableListOf<String>()
        val n = 100
        repeat(n) {
            val cardsSequence = cardServiceCompanionTestClass.invokeMethodWithoutArgs(
                clazz = invokeData.clazz,
                instance = invokeData.instance,
                javaMethod = invokeData.method,
                isPrivate = true
            ).toString()
            assert(cardsSequence !in previousSequences) { "You need to generate different card sequences with ${generateNewCardsSequenceMethod.name} method" }
            previousSequences.add(cardsSequence)
            val cards = cardsSequence.parseCards()
            assert(cards.size - 1 == countries.keys.size) { "The number of generated card sequence should be the same with the number of pairs in the countries maps" }
            assert(cards.toSet().size == cards.size) { "All pairs in the generated card sequence should be different" }
        }
    }

    @Test
    fun startNewGameMethodTest() {
        val invokeData = TestMethodInvokeData(cardServiceTestClass, startNewGameMethod)
        val cardsField = getField(invokeData, cardsVariable.name)

        val previousSequences = mutableListOf<String>()
        val n = 100
        repeat(n) {
            cardServiceTestClass.invokeMethodWithoutArgs(
                clazz = invokeData.clazz,
                instance = invokeData.instance,
                javaMethod = invokeData.method,
            ).toString()

            val cardsRes = cardsField.get(invokeData.instance).toString()
            assert(cardsRes !in previousSequences) { "You need to generate different card sequences with ${generateNewCardsSequenceMethod.name} method when call ${startNewGameMethod.name} method" }
            previousSequences.add(cardsRes)
            assert(cardsRes.parseCards().size == countries.keys.size) { "When you call ${startNewGameMethod.name} you need to drop one card from ${cardsVariable.name}" }
        }

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
            clazz, listOf(
                ConstructorGetter(
                    parameterTypes = listOf(String::class.java, String::class.java),
                    toAddDefaultConstructorMarker = true
                ),
            )
        )
    }
}
