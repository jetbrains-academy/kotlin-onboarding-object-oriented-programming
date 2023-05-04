### Data classes

#### Definition

It is not unusual to create classes whose main purpose is to hold data.
In such classes, some standard functionality and some utility functions
are often automatically derivable from the data: for example,
the way the string representation of an instance of this class will look.
In Kotlin, these are called data classes and are marked with the [`data`](https://kotlinlang.org/docs/data-classes.html) keyword.
Such classes must have at least one property:

```kotlin
data class GameCard() // ERROR
```

```kotlin
data class GameCard(private val capacity: Int = 5) // OK
```

As mentioned above, data classes have several implemented functions.
Consider the example of the `toString` function,
which allows you to get the string representation of a class instance:

```kotlin
class GameCard(private val capacity: Int = 5) // OK

fun main() {
    println(GameCard()) // package.GameCard@6d03e736
}
```

Compare:

```kotlin
data class GameCard(private val capacity: Int = 5) // OK

fun main() {
  println(GameCard()) // GameCard(capacity=5)
}
```

The full list of redefined functions can be found in the [official documentation](https://kotlinlang.org/docs/data-classes.html);
we will gradually get familiar with them in this module.

#### Properties outside the constructor

In a data class (like in regular classes), you can define properties not only inside the primary constructor
but also outside of it.
In such a case, the user does not need to pass the value for that property directly:

```kotlin
data class GameCard(
    private val id: Int, 
    private val capacity: Int = 5
) {
    val name: String = "Card#${id + 1}"
}

fun main() {
    val card = GameCard(3)
    println(card.name) // Card#4
}
```

However, properties defined outside of the constructor **do not participate** in **all** automatically implemented functions of the data class:

```kotlin
data class GameCard(
    private val id: Int, 
    private val capacity: Int = 5
) {
    val name: String = "Card#${id + 1}"
}

fun main() {
    val card = GameCard(3)
    println(card) // GameCard(id=3, capacity=5)
}
```

Compare with:

```kotlin
data class GameCard(
    private val id: Int,
    private val capacity: Int = 5,
    val name: String = "Card#${id + 1}"
)

fun main() {
    val card = GameCard(3)
    print(card) // GameCard(id=3, capacity=5, name=Card#4)
}
```
