import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val getNextCardMethod = TestMethod(
    name = "getNextCard",
    returnType = TestKotlinType("jetbrains.kotlin.course.card.trainer.card.Card"),
    returnTypeJava = "Card",
)

internal val startNewGameMethod = TestMethod(
    name = "startNewGame",
    returnType = TestKotlinType("jetbrains.kotlin.course.card.trainer.card.Card"),
    returnTypeJava = "Card",
)

internal val generateNewCardsSequenceMethod = TestMethod(
    name = "generateNewCardsSequence",
    returnType = TestKotlinType(
        "List",
        params = listOf("jetbrains.kotlin.course.card.trainer.card.Card")
    ),
    returnTypeJava = "List",
    visibility = Visibility.PRIVATE
)

internal val cardsVariable = TestVariable(
    name = "cards",
    javaType = "List",
    kotlinType = TestKotlinType(
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
        TestVariable(
            name = "randomCardGenerator",
            javaType = "CardSequenceGenerator",
            kotlinType = TestKotlinType(
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
