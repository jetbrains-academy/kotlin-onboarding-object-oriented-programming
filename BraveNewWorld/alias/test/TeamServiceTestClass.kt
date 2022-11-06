import models.TestClass
import models.Variable
import models.VariableMutability
import models.Visibility

internal val teamServiceTestClass = TestClass(
    "TeamService",
    "jetbrains.kotlin.course.alias.team",
    declaredFields = listOf(
        Variable(
            name = "identifierFactory",
            javaType = "IdentifierFactory",
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAL,
        ),
        Variable(
            name = "teamsStorage",
            javaType = "Map",
            // Because it is inside companion object
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAL,
            isStatic = true,
        ),
    )
)
