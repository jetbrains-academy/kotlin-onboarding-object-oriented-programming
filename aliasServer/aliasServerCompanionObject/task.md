#### Definition

Classes can contain variables or functions that are specific to
that class but do not require the use of a concrete instance state of the class
and can be applied generally.

For example, we have a `GameCard` class and would like to store the maximum number
of cards that can be generated. Such a variable can be placed in a [`companion object`](https://kotlinlang.org/docs/object-declarations.html#companion-objects) within that class
and then accessed _directly_ via the class name:

```kotlin
class GameCard(private val capacity: Int = 5) {
    companion object {
        val maxNumberOfCards = 10
    }
}

fun main() {
    println(GameCard.maxNumberOfCards) // 10
    println(GameCard().maxNumberOfCards) // ERROR
}
```

#### Access modifiers

If you use the `private` access modifier **inside** the companion object,
it will be available **inside** the external class, but **not outside** of it:

```kotlin
class GameCard(private val capacity: Int = 5) {
    companion object {
        private val maxNumberOfCards = 10
    }
    
    fun foo() {
        println(maxNumberOfCards) // OK
    }
}

fun main() {
    println(GameCard.maxNumberOfCards) // ERROR
}
```
