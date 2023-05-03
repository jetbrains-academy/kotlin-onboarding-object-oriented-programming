### Mutable list

You are already familiar with the `List` and `Map` collections.
Just like `Map`, `List` can be _mutable_ or _read-only_, which must be specified directly.

In Kotlin, if you want to create a _mutable_ `List`, you need to indicate it _explicitly_
because by default, a _read-only_ collection is created,
and it will not be possible to add new elements to it later.

To create a new list, you can use `listOf` for a _read-only_ collection or `mutableListOf` for a _mutable_ one:

```kotlin
val readOnlyList = listOf<Int>(1, 2, 3)
readOnlyList.add(4) // ERROR

val mutableList =  mutableListOf<Int>(1, 2, 3)
mutableList.add(4) // OK
```

To create an empty _mutable_ list, you need to use the `mutableListOf` function rather than `emptyList` used for a _read-only_ list:

```kotlin
val emptyMutableListError: MutableList<Int> = emptyList() // ERROR

val emptyMutableListOk: MutableList<Int> =  mutableListOf() // OK
```

### Checking some conditions

When developing applications, we often need to keep some invariant values true.
For example, if we are working with game cards and we know the maximum number of the cards,
the list of cards cannot exceed the maximum value.

To handle such a case, you can use the built-in [`require`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html) function, which throws an IllegalArgumentException if the value is false:

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
