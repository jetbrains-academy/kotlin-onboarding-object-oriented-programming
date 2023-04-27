Congratulations! Your game is almost ready, it remains only to add the display of the leaderboard at the end of the game
and the for the previous rounds.
In this task implement several things in the already defined class `GameResultsService` in
the `jetbrains.kotlin.course.alias.results` package:

- add a type alias `GameResult` to `List<Team>`;
- add a companion object into the `GameResultsService`
  and declare the `gameHistory` variable to store the list of game results (`MutableList<GameResult>`).
  By default, it must be initialized via an empty list.
- implement the `saveGameResults` method that adds the `result` into the `gameHistory`.
  Before adding the `result` you need to check two requirements and throw an error if they are broken: 1) `result` must
  be not empty; 2) all teams ids from the `result` must be in the `TeamService.teamsStorage`.
- implement the `getAllGameResults` method that returns the reversed `gameHistory` list.

<div class="hint" title="I press Check and see a compilation error">
  If you have a compilation error, and you have not solved this step yet, please solve the task and try again. 
  It is expected behavior since the code requires the type alias `GameResult`, but it does not exist.
</div>

Hooray! After finishing this step the game will work well:

![The current state of the game](../../utils/src/main/resources/images/states/alias/state2.gif)

<div class="hint" title="Possible ways to extend the project">

Congratulations! You did a great job and created a working application. 
We have put together a few ideas on how you can improve this project by yourself. 
These improvements will not be tested by tests within the course. 
Some improvements require changes to both the client (what is displayed in the browser) 
and the server (application logic). 
We don't cover client-server architecture in this course, 
so you can either explore them on your own or explore ideas that don't require investigating third-party code.

**Server improvements:**

- Currently, the application throws an error if something went wrong,
  for example, the application throws an error if the list with words for new cards becomes empty.
  As an improvement, you can add handling of this kind of error.
- You can add categories for the words on the card, such as animals, 
  countries, or movies to make the game process more diverse. 
  At the beginning of the game you can generate a random category as the default option.
- Currently, we lost the game progress if we turn off the server.
  You can implement the ability to save the current state of the game in files
  and when the server is starting you can extract this data.

**Client improvements:**

- Error handling can be added not only on the server, but also on the client, 
  for example, you may show a dialog window with the error message.
- Words categories can be added not only on the server, but also on the client,
  for example, you may add a new screen to choose the category.
- You can add a list of forbidden words that cannot be used while describing the word on the card. 
  On the client side for this improvement you need to show this list of words.
</div>


If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="The `isNotEmpty` built-in function">

If you need to check if a list is not empty you can check its size ot use the [isNotEmpty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/is-not-empty.html) built-in function:

  ```kotlin
  val numbers = listOf(1, 2, 3)
  if (numbers.size != 0) {
      TODO()
  }
  ```
is the **same** with

  ```kotlin
  val numbers = listOf(1, 2, 3)
  if (numbers.isNotEmpty()) {
      TODO()
  }
  ```
</div>

<div class="hint" title="`contains` and `in`">

In Kotlin you can use [operators](https://kotlinlang.org/docs/java-interop.html#operators) insted several functions to make code shorter.
For example, instead of the `contains` function, you can use the `in` operator to check if the collection contains some element:

  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  println(numbers.contains(1)) // true
  ```
is the **same** with
  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  println(1 in numbers) // true
  ```
</div>


<div class="hint" title="The `all` built-in function">

If you need to check that **all** elements match the given predicate, you can use the [`all`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/all.html) built-in function.
The predicate you need to put into the curly brackets:

  ```kotlin
  val evenNumbers = listOf(2, 4, 6)
  println(evenNumbers.all { it % 2 == 0 }) // true
  println(evenNumbers.all { it == 4 }) // false, because only one item satisfies the predicate
  ```
</div>

<div class="hint" title="The `reversed` built-in function">

If you need to get a list in which the elements are in reverse order,
you can loop through the elements of the original list from the end to the beginning and
return a new list, or use the [`reversed`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/reversed.html) built-in function:

  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  val reversedList = mutableListOf<Int>()
  for (i in numbers.size - 1 downTo 0) {
    reversedList.add(numbers[i])
  }
  println(reversedList) // [4, 3, 2, 1]
  ```

is the **same** with
  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  val reversedList = numbers.reversed()
  println(reversedList) // [4, 3, 2, 1]
  ```
</div>