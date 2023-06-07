import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val kotlinTypeIdentifier = TestKotlinType("Int", "jetbrains.kotlin.course.words.generator.team.Identifier")

internal val getNameFromTeamMethod = TestMethod(
    name = "getName",
    returnType = TestKotlinType("String"),
    returnTypeJava = "string",
)

internal val getIdFromTeamMethod = TestMethod(
    name = "getId",
    returnType = kotlinTypeIdentifier,
    returnTypeJava = "Int",
)

internal val idCounterVariable = TestVariable(
    name = "idCounter",
    javaType = "Int",
    kotlinType = kotlinTypeIdentifier,
    // Because it is inside companion object
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAR,
    isStatic = true,
)

internal val teamClass = TestClass(
    "Team",
    "jetbrains.kotlin.course.words.generator.team",
    isDataClass = true,
    declaredFields = listOf(
        TestVariable(
            name = "id",
            javaType = "int",
            kotlinType = kotlinTypeIdentifier,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
        TestVariable(
            name = "points",
            javaType = "int",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAR,
            isInPrimaryConstructor = true,
        ),
        TestVariable(
            name = "name",
            javaType = "string",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        idCounterVariable
    ),
)
