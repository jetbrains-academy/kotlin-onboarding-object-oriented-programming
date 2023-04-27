import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val kotlinTypeWord = TestKotlinType("String", params = listOf("jetbrains.kotlin.course.words.generator.word.Word"))

internal val numberOfWordsTestVariable = TestVariable(
    name = "numberOfWords",
    javaType = "Int",
    // Because it is inside companion object
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAL,
    isStatic = true,
)

internal val previousWordsTestVariable = TestVariable(
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
    returnType = TestKotlinType("Boolean"),
    returnTypeJava = "Boolean",
    arguments = listOf(
        TestVariable(
            name = "keyWord",
            javaType = "String",
        ),
        TestVariable(
            name = "newWord",
            javaType = "String",
        )
    )
)

internal val isNewWordMethod = TestMethod(
    name = "isNewWord",
    returnType = TestKotlinType("Boolean"),
    returnTypeJava = "Boolean",
    arguments = listOf(
        TestVariable(
            name = "keyWord",
            javaType = "String",
        ),
        TestVariable(
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
