import models.*

internal val kotlinTypeIdentifier = KotlinType("Int", "jetbrains.kotlin.course.words.generator.team.Identifier")

internal val getNameFromTeamMethod = TestMethod(
    name = "getName",
    returnType = KotlinType("String"),
    returnTypeJava = "string",
)

internal val getIdFromTeamMethod = TestMethod(
    name = "getId",
    returnType = kotlinTypeIdentifier,
    returnTypeJava = "Int",
)

internal val idCounterVariable = Variable(
    name = "idCounter",
    javaType = "Int",
    kotlinType = kotlinTypeIdentifier,
    // Because it is inside companion object
    visibility = Visibility.PRIVATE,
    mutability = VariableMutability.VAL,
    isStatic = true,
)

internal val teamClass = TestClass(
    "Team",
    "jetbrains.kotlin.course.words.generator.team",
    isDataClass = true,
    declaredFields = listOf(
        Variable(
            name = "id",
            javaType = "int",
            kotlinType = kotlinTypeIdentifier,
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        ),
        Variable(
            name = "points",
            javaType = "int",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAR,
            isInPrimaryConstructor = true,
        ),
        Variable(
            name = "name",
            javaType = "string",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
        ),
        idCounterVariable
    ),
)