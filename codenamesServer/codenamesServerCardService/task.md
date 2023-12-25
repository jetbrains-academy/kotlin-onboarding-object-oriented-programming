Wow! You've almost finished the project! This is the last step.

The package `jetbrains.kotlin.course.codenames.card` already has the regular class `CardService`. In this task, you need to implement the `generateWordsCards` function with the following behavior:
- If `words.size < TOTAL_NUMBER`, you need to throw an error. `words` is an already defined variable with `List<String>`, which contains all possible words for the game. You've already declared `TOTAL_NUMBER` in the `Utils` object in the `jetbrains.kotlin.course.codenames.utils` package.
- Next, you need to _shuffle_ `words` and create `TOTAL_NUMBER` cards by _taking_ them from the shuffled word list and creating new instances of the `Card` class (use `CardState.Front` as a state).
- Don't forget to _drop_ all words from the `words` list that were used for the generated cards.

Good luck! After finishing this step, the application will work well:

![The current state of the game](../../utils/src/main/resources/images/states/codenames/state2.gif)

<div class="hint" title="Click me to learn about possible ways to extend the project">

Congratulations! You did a great job and created a working application.
We have put together a few ideas on how you can further improve this project by yourself.
These improvements will not be tested within the course.
Some improvements require changes to both the client (what is displayed in the browser)
and the server (application logic).
We don't cover the client-server architecture in this course,
so you can either explore that on your own or implement ideas that don't require investigating third-party code.

**Server improvements:**

- Add words that belong to more than one color, making it more challenging for the leaders to give clues.
- Currently, the application throws an error if something goes wrong:
  for example, the application throws an error if the list with words for new rounds becomes empty.
  As an improvement, you can add handling of this kind of error.
- Jumble the letters of the words on the board and have the teams unscramble them to guess the words.
- Currently, we lose the game progress if we turn off the server.
  You can implement the ability to save the current state of the game in files,
  and when the server is starting, you can extract this data.

**Client improvements:**

- To show multicolor words, you need to change the client a little.
- Error handling can be added not only on the server, but also on the client side:
  for example, you may show a dialog window with the error message.
- Connect the card state from the server with the card state from the client.
</div>

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about the `require` built-in function">

To check a condition and throw an IllegalArgumentException error if necessary, you can use the built-in [`require`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html) function:

```kotlin
fun foo(a: int) {
    if (a < 5) {
        throw IllegalArgumentException("Some error message")
    }
}
```

It is the same as

```kotlin
fun foo(a: int) {
    require (a >= 5) { "Some error message" }
}
```
Note that you need to use an _opposite_ condition!
</div>

<div class="hint" title="Click me to learn about the `shuffled` built-in function">

Sometimes, you need to randomly shuffle the contents of a list: for example,
to change the order of the words in the original list.
To do that, you can either generate different word positions from the original list and build a new one
or use the built-in function [`shuffled`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/shuffled.html):

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.shuffled()) // 1, 2, 3, 4, 5, 6 in a different random order
  ```
</div>

<div class="hint" title="Click me to learn how to take the first N elements from a list">

To take the first `N` elements from a list, you can use the built-in [`take`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/take.html) function:
```kotlin
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println(numbers.take(3)) // [1, 2, 3]
}
```
</div>


<div class="hint" title="Click me to learn how to drop the first N elements from a list">

To drop the first `N` elements from a list, you can use the built-in [`drop`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/drop.html) function:
```kotlin
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println(numbers.drop(3)) // [4, 5, 6]
}
```
</div>
