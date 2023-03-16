Congratulations! Your game is almost ready, it remains only to add the display of the leaderboard at the end of the game
and the for the previous rounds.
In this task implement several things in the already defined class `GameResultsService` in
the `jetbrains.kotlin.course.alias.results` package:

- add a type alias `GameResult` to `List<Team>` into `jetbrains.kotlin.course.alias.results` package;
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