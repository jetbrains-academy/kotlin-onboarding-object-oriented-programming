import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.ClassType
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val expectedVariablesValues = mapOf(
    "N" to 5,
    "TOTAL_NUMBER" to 5 * 5,
    "PINK_CARDS_NUMBER" to 8,
    "VIOLET_CARDS_NUMBER" to 9,
    "GRAY_CARDS_NUMBER" to 7,
    "BLACK_CARDS_NUMBER" to 1,
)

internal val utilObjectTestClass = TestClass(
    "Utils",
    "jetbrains.kotlin.course.codenames.utils",
    classType = ClassType.OBJECT,
    declaredFields = listOf(
        TestVariable(
            name = "N",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAL,
        ),
        TestVariable(
            name = "TOTAL_NUMBER",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        TestVariable(
            name = "PINK_CARDS_NUMBER",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        TestVariable(
            name = "VIOLET_CARDS_NUMBER",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        TestVariable(
            name = "GRAY_CARDS_NUMBER",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        TestVariable(
            name = "BLACK_CARDS_NUMBER",
            javaType = "Int",
            isStatic = true,
            isConst = true,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        // Need for 4th task
        TestVariable(
            name = "previousAttempts",
            javaType = "List",
            isStatic = true,
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAL,
            kotlinType = TestKotlinType(
                "MutableList",
                abbreviation = "kotlin.collections.List<jetbrains.kotlin.course.codenames.keyCard.KeyCardCell>"
            ),
        ),
        TestVariable(
            name = "uniqueKeyCardGenerator",
            javaType = "KeyCardGenerator",
            isStatic = true,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        ),
)
