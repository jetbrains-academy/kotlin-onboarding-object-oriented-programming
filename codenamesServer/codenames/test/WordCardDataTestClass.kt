import models.TestClass
import models.Variable
import models.VariableMutability
import models.Visibility

internal val wordCardDataTestClass = TestClass(
    "WordCardData",
    "jetbrains.kotlin.course.codenames.card",
    isDataClass = true,
    declaredFields = listOf(
        Variable(
            name = "word",
            javaType = "String",
            visibility = Visibility.PUBLIC,
            mutability = VariableMutability.VAL,
            isInPrimaryConstructor = true,
        )
    ),
    interfaces = listOf(
        cardDataInterfaceTestClass,
    ),
)