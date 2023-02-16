import commonTests.team.callGenerateTeamsForOneRound
import jetbrains.kotlin.course.card.trainer.util.countries
import models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import kotlin.jvm.internal.DefaultConstructorMarker

class Test {
    @Test
    fun cardServiceTest() {
        val clazz = cardServiceTestClass.checkBaseDefinition()
        val companion = cardServiceCompanionTestClass.checkBaseDefinition()
        cardServiceCompanionTestClass.checkDeclaredMethods(companion)
        cardServiceTestClass.checkFieldsDefinition(clazz, false)
        cardServiceTestClass.checkConstructors(
            clazz,
            listOf(
                ConstructorGetter(),
            )
        )
        cardServiceTestClass.checkDeclaredMethods(clazz)
    }

    private fun getCardsField(invokeData: TestMethodInvokeData): Field {
        val cardsField = invokeData.clazz.declaredFields.find { it.name == cardsVariable.name }
        assert(cardsField != null) { "Can not find field ${cardsVariable.name}" }
        cardsField!!.isAccessible = true
        return cardsField
    }

    @Test
    fun getNextCardMethodTest() {
        val invokeData = TestMethodInvokeData(cardServiceTestClass, getNextCardMethod)
        val cardsField = getCardsField(invokeData)

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
        val cardsField = getCardsField(invokeData)

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
