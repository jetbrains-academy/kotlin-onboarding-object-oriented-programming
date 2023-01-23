### Mutable list

You already familiar with the `List` and with the `Map`.
Just like the `Map`, a `List` can be _mutable_ or _read-only_ and it must be reported directly.

In Kotlin, if you want to create a _mutable_ `List`, then you need to say so _explicitly_,
because by default, an _read-only_ collection is created,
to which it will not be possible to add new elements later.

To create a new list you can use `listOf` for the _read-only_ collection or `mutableListOf` for _mutable_ one:

```kotlin
val readOnlyList = listOf<Int>(1, 2, 3)
readOnlyList.add(4) // ERROR

val mutableList =  mutableListOf<Int>(1, 2, 3)
mutableList.add(4) // OK
```

### Checking some conditions

When developing applications, some invariants can often be true for values.
For example, if we are working with game cards and we know the maximum number of the cards,
the list of cards can not have cards more than the maximum value.

To handle these case you can use the [`require`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html) built-in function, that throws an IllegalArgumentException if the value is false:

```kotlin
class GameCard(private val capacity: Int = 5) {
    companion object {
        const val MAX_NUMBER_OF_CARDS = 10 // OK
    }
}

fun foo(cards: List<GameCard>) {
    require(cards.size <= GameCard.MAX_NUMBER_OF_CARDS) { "The maximum number of cards is ${GameCard.MAX_NUMBER_OF_CARDS}" }
}
```