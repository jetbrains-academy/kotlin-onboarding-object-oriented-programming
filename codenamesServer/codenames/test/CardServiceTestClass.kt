import models.KotlinType
import models.TestClass
import models.TestMethod

internal val generateWordsCardsMethod = TestMethod(
    "generateWordsCards",
    KotlinType(
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