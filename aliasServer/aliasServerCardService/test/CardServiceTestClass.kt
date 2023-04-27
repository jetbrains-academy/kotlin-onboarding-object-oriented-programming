import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val getCardByIndexMethod = TestMethod(
    name = "getCardByIndex",
    returnType = TestKotlinType("Card"),
    returnTypeJava = "Card",
    arguments = listOf(
        TestVariable(
            name = "index",
            javaType = "int",
        )
    )
)

internal val toWordsMethod = TestMethod(
    name = "toWords",
    returnType = TestKotlinType("List", params = listOf("jetbrains.kotlin.course.alias.card.Word")),
    returnTypeJava = "List",
    arguments = listOf(
        TestVariable(
            name = "this",
            javaType = "List",
        ),
    ),
    visibility = Visibility.PRIVATE,
)

internal val generateCardsMethod = TestMethod(
    name = "generateCards",
    returnType = TestKotlinType("List", params = listOf("jetbrains.kotlin.course.alias.card.Card")),
    returnTypeJava = "List",
    visibility = Visibility.PRIVATE,
)

internal val getCardsAmountMethod = TestMethod(
    name = "access\$getCardsAmount\$cp",
    returnType = TestKotlinType("Int"),
    returnTypeJava = "Int",
    visibility = Visibility.PRIVATE,
)

internal val wordsInCardTestVariable = TestVariable(
    name = "WORDS_IN_CARD",
    javaType = "Int",
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAL,
    isConst = true,
    isStatic = true,
)

internal val cardsVariable = TestVariable(
    name = "cards",
    javaType = "List",
    kotlinType = TestKotlinType(
        "List",
        abbreviation = "jetbrains.kotlin.course.alias.card.Card"
    ),
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAL,
)

internal val cardServiceTestClass = TestClass(
    "CardService",
    "jetbrains.kotlin.course.alias.card",
    declaredFields = listOf(
        TestVariable(
            name = "identifierFactory",
            javaType = "IdentifierFactory",
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAL,
        ),
        cardsVariable,
        wordsInCardTestVariable,
        TestVariable(
            name = "cardsAmount",
            javaType = "Int",
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAL,
            isStatic = true,
        ),
    ),
    customMethods = listOf(
        getCardByIndexMethod,
        toWordsMethod,
        generateCardsMethod,
    ),
)

internal val cardServiceCompanionTestClass = TestClass(
    "CardService\$Companion",
    "jetbrains.kotlin.course.alias.card",
)