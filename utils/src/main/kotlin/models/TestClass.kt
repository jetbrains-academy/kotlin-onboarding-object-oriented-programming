package models

import throwInternalCourseError
import java.lang.reflect.Constructor
import java.lang.reflect.Method
import kotlin.jvm.internal.DefaultConstructorMarker

enum class ClassType(val key: String) {
    CLASS("class"),
    INTERFACE("interface"),
    ENUM("enum class"),
    OBJECT("object"),
//    COMPANION_OBJECT
    ;
}

data class ConstructorGetter(
    val parameterTypes: List<Class<*>> = emptyList(),
    val defaultParameterTypes: List<Class<*>> = emptyList()
) {
    fun getConstructorWithDefaultArguments(clazz: Class<*>) = try {
        val parameters = (parameterTypes + defaultParameterTypes.map { listOf(it, Int::class.java) }
            .flatten()).toMutableList()
        if (defaultParameterTypes.isNotEmpty()) {
            parameters.add(DefaultConstructorMarker::class.java)
        }
        clazz.getConstructor(*parameters.toTypedArray())
    } catch (e: NoSuchMethodException) {
        null
    }
}

data class TestClass(
    val name: String = "MainKt",
    val classPackage: String? = null,
    val visibility: Visibility = Visibility.PUBLIC,
    val classType: ClassType = ClassType.CLASS,
    val declaredFields: List<Variable> = emptyList(),
    val customMethods: List<TestMethod> = emptyList(),
    val isDataClass: Boolean = false,
) {
    fun getFullName() = classPackage?.let {
        "$it.$name"
    } ?: name

    private fun getBaseDefinition() = "${visibility.key} ${classType.key} $name"

    private fun getFieldsListPrettyString() = declaredFields.joinToString { it.prettyString() }

    fun checkBaseDefinition(): Class<*> {
        val clazz = this.findClassSafe()
        val errorMessage = "You need to add: ${this.getBaseDefinition()}"
        assert(clazz != null) { errorMessage }
        assert(
            clazz!!.isSameWith(this)
        ) {
            "$errorMessage, but currently you added: ${
                clazz.toTestClass(this.name, this.classPackage).getBaseDefinition()
            }"
        }
        if (isDataClass) {
            clazz.checkIfIsDataClass(this)
        }
        return clazz
    }

    private fun checkFields(clazz: Class<*>) {
        val declaredFields = clazz.getDeclaredFieldsWithoutCompanion()
        this.declaredFields.forEach { field ->
            val currentField = declaredFields.find { it.name == field.name }
            assert(currentField != null) { "Can not find the field with name ${field.name}" }
            field.checkField(currentField!!)
        }
    }

    fun checkFieldsDefinition(clazz: Class<*>, toCheckDeclaredFieldsSize: Boolean = true) {
        if (toCheckDeclaredFieldsSize) {
            assert(clazz.getDeclaredFieldsWithoutCompanion().size == this.declaredFields.size) { "You need to declare the following fields: ${this.getFieldsListPrettyString()}" }
        }
        this.checkFields(clazz)
    }

    fun getJavaClass(): Class<*> {
        val clazz = this.findClassSafe()
        assert(clazz != null) { "You need to add: ${this.getBaseDefinition()}" }
        return clazz!!
    }

    fun checkConstructors(clazz: Class<*>, constructorGetters: List<ConstructorGetter>): Constructor<out Any>? {
        require(constructorGetters.isNotEmpty())
        val arguments = constructorGetters.map { it.parameterTypes }.toSet()
        require(arguments.size == 1)
        constructorGetters.forEach {
            it.getConstructorWithDefaultArguments(clazz)?.let { constructor ->
                return constructor
            }
        }
        assert(false) { "You don't have any constructors with ${arguments.first().size} arguments in the class $name. Please, check the arguments, probably you need to add the default values." }
        return null
    }

    fun checkDeclaredMethods(clazz: Class<*>) {
        val methods = clazz.methods
        val privateMethods = clazz.declaredMethods
        customMethods.forEach {
            val candidates = if (it.visibility == Visibility.PRIVATE) {
                privateMethods
            } else {
                methods
            }
            val method = candidates.findMethod(it)
            it.checkMethod(method)
        }
    }

    fun findMethod(clazz: Class<*>, method: TestMethod): Method {
        assert(method in customMethods) { "The method ${method.name} was not found in the class ${getFullName()}" }
        return clazz.methods.findMethod(method)
    }

    fun <T> invokeMethodWithoutArgs(clazz: Class<*>, instance: T, javaMethod: Method, isPrivate: Boolean = false) =
        javaMethod.invokeWithoutArgs(clazz, obj = instance, isPrivate = isPrivate)

    fun <T> invokeMethodWithArgs(
        vararg args: Any,
        clazz: Class<*>,
        instance: T,
        javaMethod: Method,
        isPrivate: Boolean = false
    ) =
        javaMethod.invokeWithArgs(*args, clazz = clazz, obj = instance, isPrivate = isPrivate)
}

fun TestClass.findClass(): Class<*> = Class.forName(this.getFullName())

fun TestClass.findClassSafe() = try {
    this.findClass()
} catch (e: ClassNotFoundException) {
    null
}

private fun Class<*>.getVisibility() = this.modifiers.getVisibility()

private fun Class<*>.getClassType(): ClassType {
    if (this.isInterface) {
        return ClassType.INTERFACE
    }
    if (this.isEnum) {
        return ClassType.ENUM
    }
    // TODO: think about object and companion object
    return ClassType.CLASS
}

private fun Class<*>.checkIfIsDataClass(testClass: TestClass) {
    val methods = this.methods
    val methodsNames = methods.map { it.name }
    val dataClassMethods = listOf(
        "copy",
        "equals",
        "hashCode",
        "toString",
    )
    dataClassMethods.forEach {
        assert(it in methodsNames) { "${testClass.getFullName()} must be a data class and must have the $it method" }
    }
    val (primary, _) = testClass.declaredFields.partition { it.isInPrimaryConstructor }
    val componentNFunctions = methodsNames.filter { "component" in it }
    val componentNErrorMessage =
        "You must put only ${primary.size} fields into the primary constructor: ${primary.joinToString(", ") { it.name }}."
    assert(componentNFunctions.size == primary.size) { componentNErrorMessage }
    primary.forEachIndexed { index, _ ->
        assert("component${index + 1}" in methodsNames) { componentNErrorMessage }
    }
}

private fun Class<*>.hasSameVisibilityWith(testClass: TestClass) =
    this.getVisibility() == testClass.visibility

private fun Class<*>.hasSameClassTypeWith(testClass: TestClass) =
    this.getClassType() == testClass.classType

fun Class<*>.isSameWith(testClass: TestClass) =
    this.hasSameVisibilityWith(testClass) && this.hasSameClassTypeWith(testClass)

fun Class<*>.toTestClass(name: String, classPackage: String?): TestClass {
    val visibility = this.getVisibility() ?: throwInternalCourseError()
    return TestClass(name, classPackage, visibility, this.getClassType())
}
