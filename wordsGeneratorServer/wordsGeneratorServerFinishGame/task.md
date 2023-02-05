Congratulations! Your game is almost ready, it remains only to add the display of the leaderboard at the end of the game
and the for the previous rounds.

In this task implement several things in the already defined class `GameResultsService` in
the `jetbrains.kotlin.course.words.generator.results` package. Note, this class is the same as `GameResultsService` from the alias game, so you can practice again or just copy the previous solution.

- Add a type alias `GameResult` to `List<Team>` into `jetbrains.kotlin.course.alias.results` package.
- Add a companion object into the `GameResultsService`
  and declare the `gameHistory` variable to store the list of game results (`MutableList<GameResult>`).
  By default, it must be initialized via an empty list.
- Implement the `saveGameResults` method that adds the `result` into the `gameHistory`.
  Before adding the `result` you need to check two requirements and throw an error if they are broken: 1) `result` must
  not be empty; 2) all teams ids from the `result` must be in the `TeamService.teamsStorage`.
- Implement the `getAllGameResults` method that returns the reversed `gameHistory` list.

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
