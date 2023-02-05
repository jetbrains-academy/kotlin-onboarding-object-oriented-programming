#### General definition

Sometimes during software development, you need to do something during classes or objects creation, 
for example inform the user about the current state or check come conditions.
Classes have a constructor, but you cannot write additional code inside it, 
except for declaring properties. Objects generally have no constructor. 
It is for such cases in Kotlin that there are [_initializer blocks_](https://kotlinlang.org/docs/classes.html#constructors) that allow you to 
run some code exactly at the moment of creating an instance of a class or object.

#### Kotlin definition

The initializer blocks are marked as the `init` keyword. 
The additional code must be placed inside curly brackets:

```kotlin
object Settings {
    private const val MAX_NUMBER_OF_ROUNDS = 15
    init {
      require(MAX_NUMBER_OF_ROUNDS <= 5) { "The maximum number of rounds must be not more than five!" }
    }
}
```

In this case if the condition is `False`, the error will be thrown.

<div class="hint" title="The order of initialization Java classes">

Actually, the following code will not throw any errors:
```kotlin
fun main() {
    println(Settings.MAX_NUMBER_OF_ROUNDS)
}
```

This is due to the order of initialization of classes in Java, 
and in order to access static fields (namely, we have static fields for objects), 
you do not need to create an instance of the class itself. 
Since Kotlin is fully compatible with Java, this behavior is natural.

But the following code will already cause the expected error:
```kotlin
fun main() {
    println(Settings)
}
```
Or if you call any function on the object.

A detailed explanation of this is beyond the scope of this course, 
but interested students can explore this topic on their own.

</div>


#### Execution order

During the initialization of an instance, the initializer blocks are executed in the same order 
as they appear in the class or object body, interleaved with the property initializers:

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
