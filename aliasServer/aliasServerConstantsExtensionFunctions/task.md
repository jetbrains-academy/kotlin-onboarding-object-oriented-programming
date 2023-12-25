### Const variables

To help the Kotlin compiler optimize your code, you can use the `const` modifier for the variables that remain unchanged – the [compile-time constants](https://kotlinlang.org/docs/properties.html#compile-time-constants).
Constants can only have basic (primitive) types, such as `String`, `Int`, and so on.
Also, they cannot be initialized by calling functions or in a similar way.
Last but not least, you must only use constants inside `companion objects` (or just inside `objects`, which we will talk about later):

```kotlin
class GameCard(private val capacity: Int = 5) {
  companion object {
    private const val MAX_NUMBER_OF_CARDS_OK = 10 // OK
    private const val MAX_NUMBER_OF_CARDS_NOT_OK = foo() // ERROR

    private fun foo() = 10
  }
}
```

As you can see from the example, Kotlin has adopted a special style code for naming compile-time constants – all letters must be capitalized and words in the name separated by an underscore.

### Extension functions

#### Definition

In Kotlin, you can add new member functions to the existing classes. This is done via special declarations called [extensions](https://kotlinlang.org/docs/extensions.html).
It is useful if, for example, if you don't have access to the original class but would like to add a new function.
Consider an example – let's say we need to count the number of letters in a string. We can do it in the following way:

```kotlin
fun getNumberOfLetters(s: String, letter: Char) = s.count { it == letter }

fun main() {
  println(getNumberOfLetters("photothermoelasticity", 'o')) // 3
}
```

However, we can also create an _extension function_ so as not to pass a string as a function argument:
```kotlin
fun String.getNumberOfLetters(letter: Char) = this.count { it == letter }

fun main() {
  println("photothermoelasticity".getNumberOfLetters('o')) // 3
}
```

In this case, we have added a new function to the `String` class.
The main difference in implementation is the following: 1) we use `this` instead of the passed string parameter; 2) we don't need to pass the string as an argument, and we
can call the function directly on the `String` type.

#### Access

It's important to note that this functionality only works for functions that _don't already exist in the original class_.
If you define a new function that is already defined in the class, then the original implementation will be called:

```kotlin
fun String.isEmpty() = true

fun main() {
    println("photothermoelasticity".isEmpty()) // false because the original isEmpty function was called
}
```

Also, if you define a new extension function _inside_ a class, it will not be available outside of it:

```kotlin
class Example {
    fun String.countLetters(letter: Char) = this.count { it == letter }
    
    fun foo(string: String) {
        string.countLetters('a') // OK
    }
}

fun main() {
    println("photothermoelasticity".countLetters()) // ERROR
}
```

<div class="hint" title="Click me to learn about cases with several `this` keywords inside one class">

When you add a new extension function _inside_ a class, you have several _contexts_ for the keyword `this`.
You can specify which context you need to use in the current case:

  ```kotlin
  class Example(private val toDrop: Int) {
    fun String.countLetters(letter: Char) = this.count { it == letter } // this == String
  
    fun String.dropAndCountLetters(letter: Char) = 
        this.drop(this@Example.toDrop).count { it == letter } // this == String, this@Example == Example
  }
  ```
</div>
