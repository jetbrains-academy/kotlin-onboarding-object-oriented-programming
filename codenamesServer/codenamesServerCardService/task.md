Wow! You almost finish the project! It is the last step.

The package `jetbrains.kotlin.course.codenames.card` already has the regular class `CardService`. In this task you need to implement the `generateWordsCards` function with the following behaviour:
- if `words.size < TOTAL_AMOUNT`, you need to throw an error. The `words` is already defined variable with `List<String>`, that contains all possible words for the game. The `TOTAL_AMOUNT` you already declared in the `Utils` object in the `jetbrains.kotlin.course.codenames.utils` package.
- next, you need to _shuffle_ `words` and create `TOTAL_AMOUNT` cards by _taking_ them from the shuffled words list and creating new instances of the `Card` class.
- don't forget to _drop_ all words from the `words` list that were used for the generated cards.

Good luck!

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="The require built-in function">

To check some condition and throw an IllegalArgumentException error you can use the [`require`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html) built-in function:

```kotlin
fun foo(a: int) {
    if (a < 5) {
        throw IllegalArgumentException("Some error message")
    }
}
```

is the same with

```kotlin
fun foo(a: int) {
    require (a >= 5) { "Some error message" }
}
```
Note, you need to use an _opposite_ condition!
</div>

<div class="hint" title="The `shuffled` built-in function">

Sometimes, you need to randomly shuffle the contents of a list: for example,
to change the order of the words in the original list.
To do this, you can generate different word positions from the original list and build a new one,
or use the built-in function [`shuffled`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/shuffled.html):

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.shuffled()) // 1, 2, 3, 4, 5, 6 in a different random order
  ```
</div>

<div class="hint" title="How to take first N elements from a list?">

To take first `N` elements from a list you can use the [`take`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/take.html) built-in function:
```kotlin
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println(numbers.take(3)) // [1, 2, 3]
}
```
</div>


<div class="hint" title="How to drop first N elements from a list?">

To drop first `N` elements from a list you can use the [`drop`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/drop.html) built-in function:
```kotlin
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println(numbers.drop(3)) // [4, 5, 6]
}
```
</div>
