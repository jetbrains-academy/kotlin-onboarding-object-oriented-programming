import org.jetbrains.academy.test.system.models.TestKotlinType
import org.jetbrains.academy.test.system.models.Visibility
import org.jetbrains.academy.test.system.models.classes.TestClass
import org.jetbrains.academy.test.system.models.method.TestMethod
import org.jetbrains.academy.test.system.models.variable.TestVariable
import org.jetbrains.academy.test.system.models.variable.VariableMutability

internal val kotlinTypeIdentifier = TestKotlinType("Int", "jetbrains.kotlin.course.alias.util.Identifier")

internal val uniqueIdentifierMethod = TestMethod(
    name = "uniqueIdentifier",
    returnType = kotlinTypeIdentifier,
    returnTypeJava = "int",
)

internal val identifierFactoryClass = TestClass(
    "IdentifierFactory",
    "jetbrains.kotlin.course.alias.util",
    declaredFields = listOf(
        TestVariable(
            name = "counter",
            javaType = "int",
            kotlinType = kotlinTypeIdentifier,
            visibility = Visibility.PRIVATE,
            mutability = VariableMutability.VAR,
        ),
    ),
    customMethods = listOf(uniqueIdentifierMethod),
)