#### General definition

Sometimes when developing software, you need to do something at the moment of creating classes or objects: 
for example, inform the user about the current state or check certain conditions.
Classes have a constructor, but you cannot write additional code inside it, 
except for declaring properties. Objects generally have no constructor. 
It is for such cases that Kotlin provides [_initializer blocks_](https://kotlinlang.org/docs/classes.html#constructors), which allow you to 
run some code exactly at the moment of creating an instance of a class or an object.

#### Kotlin definition

Initializer blocks are marked with the `init` keyword. 
The additional code must be placed inside curly brackets:

```kotlin
object Settings {
    private const val MAX_NUMBER_OF_ROUNDS = 15
    init {
      require(MAX_NUMBER_OF_ROUNDS <= 5) { "The maximum number of rounds must be not more than five!" }
    }
}
```

In this case, if the condition is `False`, an error will be thrown.

<div class="hint" title="Click me to learn about the order of initialization Java classes">

Actually, the following code will not throw errors on the JVM target:
```kotlin
fun main() {
    println(Settings.MAX_NUMBER_OF_ROUNDS)
}
```

That is due to the order of class initialization in Java, 
and in order to access static fields (namely, we have static fields for objects), 
you do not need to create an instance of the class itself. 
Since Kotlin is fully compatible with Java, this behavior is natural.

However, the following code will cause the expected error:
```kotlin
fun main() {
    println(Settings)
}
```
The same happens if you call any function on the object.

A detailed explanation of that is beyond the scope of this course, 
but curious students can explore the topic on their own.

</div>


#### Execution order

During the initialization of an instance, initializer blocks are executed in the same order 
that they appear in the class or object body, interleaved with the property initializers:

```kotlin
object Settings {
    private const val MAX_NUMBER_OF_ROUNDS = 5
    init {
        require(MAX_NUMBER_OF_ROUNDS <= 5) { "The maximum number of rounds must be not more than five!" }
    }

    private const val MAX_NUMBER_OF_TEAMS = 5
    init {
        require(MAX_NUMBER_OF_TEAMS <=2) { "The maximum number of teams must be not more than two!" }
    }
}
```
