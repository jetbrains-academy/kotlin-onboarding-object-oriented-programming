Congratulations! Your game is almost ready, what remains is only to add the display of the leaderboard for the current game
and for the previous rounds.

In this task, you need to implement several things in the already defined class `GameResultsService` in
the `jetbrains.kotlin.course.words.generator.results` package. Note, this class is the same as `GameResultsService` from the Alias game, so you can either practice again or just copy the previous solution.

- Add the type alias `GameResult` to `List<Team>`.
- Add a companion object to `GameResultsService`
  and declare the `gameHistory` variable to store the list of game results (`MutableList<GameResult>`).
  By default, it must be initialized as an empty list.
- Implement the `saveGameResults` method, which adds `result` to `gameHistory`.
  Before adding `result`, you need to check for two requirements and throw an error if they are broken: 1) `result` must
  not be empty; 2) all team ids in `result` must be present in `TeamService.teamsStorage`.
- Implement the `getAllGameResults` method, which returns the reversed `gameHistory` list.


<div class="hint" title="Click me if you pressed Check and found a compilation error">

  If you have a compilation error and you have not solved this step yet, please solve the task and try again. 
  It is expected behavior, since the code requires the type alia `GameResult`, but it does not exist.
</div>


Hooray! After finishing this step, the game will work well:

![The current state of the game](../../utils/src/main/resources/images/states/wordGenerator/state2.gif)

<div class="hint" title="Click me to learn about possible ways to extend the project">

Congratulations! You did a great job and created a working application.
We have put together a few ideas on how you can improve this project by yourself.
These improvements will not be tested within the course.
Some improvements require changes to both the client (what is displayed in the browser)
and the server (the application logic).
We don't cover the client-server architecture in this course,
so you can either explore that on your own or implement ideas that don't require investigating third-party code.

**Server improvements:**

- Give bonus points to the teams that come up with words that are longer than a certain number of letters 
  or words that use all the letters of the original word. 
  Or you can just assign a point value to each word based on the number of letters in the word or the difficulty of the word.
  Now points are calculated on the client side, so to take into account bonus points,
  you need not only to implement the rules but also store the points correctly after each round.
- Choose a word from a foreign language and have the teams come up with English words that use the same letters.
- Currently, the application throws an error if something goes wrong:
  for example, the application throws an error if the list with words for new rounds becomes empty.
  As an improvement, you can add handling of this kind of error.
- Limit the number of times a team can use each letter of the original word.
- Currently, we lose the game progress if we turn off the server.
  You can implement the ability to save the current state of the game in files,
  and when the server is starting, you can extract this data.

**Client improvements:**

- Show bonus points to the user during a game round.
- You can create a new screen to provide the user with the option to choose the language for words.
- Error handling can be added not only on the server but also on the client side:
  for example, you may show a dialog window with the error message.
</div>

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about the `isNotEmpty` built-in function">

If you need to check whether a list is empty or not, you can either check its size or use the built-in [`isNotEmpty`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/is-not-empty.html) function:

  ```kotlin
  val numbers = listOf(1, 2, 3)
  if (numbers.size != 0) {
      TODO()
  }
  ```
It is the **same** as

  ```kotlin
  val numbers = listOf(1, 2, 3)
  if (numbers.isNotEmpty()) {
      TODO()
  }
  ```
</div>

<div class="hint" title="Click me to learn about the `reversed` built-in function">

If you need to get a list in which the elements are in reverse order,
you can either loop through the elements of the original list from the end to the beginning and
return the new list or use the built-in [`reversed`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/reversed.html) function:

  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  val reversedList = mutableListOf<Int>()
  for (i in numbers.size - 1 downTo 0) {
    reversedList.add(numbers[i])
  }
  println(reversedList) // [4, 3, 2, 1]
  ```

It is the **same** as
  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  val reversedList = numbers.reversed()
  println(reversedList) // [4, 3, 2, 1]
  ```
</div>
