import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val getNameFromTeamMethod = TestMethod(
    name = "getName",
    returnType = TestKotlinType("String"),
    returnTypeJava = "string",
)

internal val getPointsTeamMethod = TestMethod(
    name = "getPoints",
    returnType = TestKotlinType("Int"),
    returnTypeJava = "int",
)

internal val teamClass = TestClass(
    "Team",
    "jetbrains.kotlin.course.alias.team",
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
        )
    ),
)