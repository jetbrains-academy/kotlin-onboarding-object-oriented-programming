import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val generateTeamsForOneRoundMethod = TestMethod(
    name = "generateTeamsForOneRound",
    returnType = TestKotlinType("List", params = listOf(teamClass.getFullName())),
    returnTypeJava = "List",
    arguments = listOf(
        TestVariable(
            name = "teamsNumber",
            javaType = "int",
        )
    )
)

internal val getTeamsStorageMethod = TestMethod(
    name = "access\$getTeamsStorage\$cp",
    returnType = TestKotlinType("Map"),
    returnTypeJava = "Map",
)

internal val teamServiceTestClass = TestClass(
    "TeamService",
    "jetbrains.kotlin.course.alias.team",
    declaredFields = listOf(
        TestVariable(
            name = "identifierFactory",
            javaType = "IdentifierFactory",
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAL,
        ),
        TestVariable(
            name = "teamsStorage",
            javaType = "Map",
            // Because it is inside companion object
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAL,
            isStatic = true,
        ),
    ),
    customMethods = listOf(generateTeamsForOneRoundMethod),
)

internal val teamServiceCompanionTestClass = TestClass(
    "TeamService\$Companion",
    "jetbrains.kotlin.course.alias.team",
)