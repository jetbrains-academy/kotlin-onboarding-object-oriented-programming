import models.*

internal val kotlinTypeWord= KotlinType("String", params = listOf("jetbrains.kotlin.course.words.generator.word.Word"))

internal val numberOfWordsTestVariable = Variable(
    name = "numberOfWords",
    javaType = "Int",
    // Because it is inside companion object
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAL,
    isStatic = true,
)

internal val previousWordsTestVariable = Variable(
    name = "previousWords",
    javaType = "Map",
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAL,
    isStatic = true,
)

internal val generateNextWordMethod = TestMethod(
    name = "generateNextWord",
    returnType = kotlinTypeWord,
    returnTypeJava = "String",
    hasGeneratedPartInName = true,
)

internal val isValidWordMethod = TestMethod(
    name = "isValidWord",
    returnType = KotlinType("Boolean"),
    returnTypeJava = "Boolean",
    arguments = listOf(
        Variable(
            name = "keyWord",
            javaType = "String",
        ),
        Variable(
            name = "newWord",
            javaType = "String",
        )
    )
)

internal val isNewWordMethod = TestMethod(
    name = "isNewWord",
    returnType = KotlinType("Boolean"),
    returnTypeJava = "Boolean",
    arguments = listOf(
        Variable(
            name = "keyWord",
            javaType = "String",
        ),
        Variable(
            name = "newWord",
            javaType = "String",
        )
    )
)

internal val wordServiceTestClass = TestClass(
    "WordService",
    "jetbrains.kotlin.course.words.generator.word",
    declaredFields = listOf(
        numberOfWordsTestVariable,
        previousWordsTestVariable,
    ),
    customMethods = listOf(
        generateNextWordMethod,
        isValidWordMethod,
        isNewWordMethod,
    ),
)

internal val wordServiceCompanionTestClass = TestClass(
    "WordService\$Companion",
    "jetbrains.kotlin.course.words.generator.word",
)
