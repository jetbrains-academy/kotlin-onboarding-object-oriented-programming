import models.*

internal val getNextCardMethod = TestMethod(
    name = "getNextCard",
    returnType = KotlinType("jetbrains.kotlin.course.card.trainer.card.Card"),
    returnTypeJava = "Card",
)

internal val startNewGameMethod = TestMethod(
    name = "startNewGame",
    returnType = KotlinType("jetbrains.kotlin.course.card.trainer.card.Card"),
    returnTypeJava = "Card",
)

internal val generateNewCardsSequenceMethod = TestMethod(
    name = "generateNewCardsSequence",
    returnType = KotlinType(
        "List",
        params = listOf("jetbrains.kotlin.course.card.trainer.card.Card")
    ),
    returnTypeJava = "List",
    visibility = Visibility.PRIVATE
)

internal val cardsVariable = Variable(
    name = "cards",
    javaType = "List",
    kotlinType = KotlinType(
        "MutableList",
        params = listOf("jetbrains.kotlin.course.card.trainer.card.Card")
    ),
    // Because it is inside companion object
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAR,
    isStatic = true,
)

internal val cardServiceTestClass = TestClass(
    "CardService",
    "jetbrains.kotlin.course.card.trainer.card",
    declaredFields = listOf(
        Variable(
            name = "randomCardGenerator",
            javaType = "CardSequenceGenerator",
            kotlinType = KotlinType(
                "jetbrains.kotlin.course.card.trainer.card.CardSequenceGenerator",
            ),
            // Because it is inside companion object
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAL,
            isStatic = true,
        ),
        cardsVariable
    ),
    customMethods = listOf(
        getNextCardMethod,
        startNewGameMethod
    ),
)

internal val cardServiceCompanionTestClass = TestClass(
    "CardService\$Companion",
    "jetbrains.kotlin.course.card.trainer.card",
    customMethods = listOf(
        generateNewCardsSequenceMethod
    )
)
