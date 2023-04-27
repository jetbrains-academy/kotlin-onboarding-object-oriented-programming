import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod

internal val generateWordsCardsMethod = TestMethod(
    "generateWordsCards",
    TestKotlinType(
        "List",
        abbreviation = "jetbrains.kotlin.course.codenames.card.Card",
    ),
)

internal val cardServiceTestClass = TestClass(
    "CardService",
    "jetbrains.kotlin.course.codenames.card",
    customMethods = listOf(
        generateWordsCardsMethod
    ),
)