Wow! You've almost finished the project! This is the last step.
In this step, you need to add statistics to the game.

First of all, you need to add a class `Stat` to the `jetbrains.kotlin.course.card.trainer.stat` package in the `StatModel.kt` file to store statistics:

- It must have two properties in the primary constructor:
    - `knownBacks` with `List<Back>` type to store known countries;
    - `unknownBacks` with `List<Back>` type to store unknown countries.

Next, you need to implement several methods in the already defined class `StatService` 
in the package `jetbrains.kotlin.course.card.trainer.card`:
- Add a `history` property to the companion object with type `MutableList<Stat>` and initialize it with an empty list.
- Implement the method `save`, which adds new `Stat` to `history`.
- Implement the method `getHistory`, which returns _reversed_ `history`.


Hooray! After finishing this step, the application will work well:

![The current state of the application](../../utils/src/main/resources/images/states/memoryTrainer/state2.gif)

<div class="hint" title="Click me to learn about possible ways to extend the project">

Congratulations! You did a great job and created a working application.
We have put together a few ideas on how you can improve this project by yourself.
These improvements will not be tested within the course.
Some improvements require changes to both the client (what is displayed in the browser)
and the server (the application logic).
We don't cover the client-server architecture in this course,
so you can either explore that on your own or implement ideas that don't require investigating third-party code.

**Server improvements:**

- Add a multiplayer mode, where players can compete with each other to match the countries 
  and their capitals in the fastest time.
- Add levels that the player can unlock as they progress through the game.
- Currently, the application throws an error if something goes wrong:
  for example, the application throws an error if the list with words becomes empty.
  As an improvement, you can add handling of this kind of error.
- Add a time penalty for each incorrect match.
- Currently, we lose the game progress if we turn off the server.
  You can implement the ability to save the current state of the game in files,
  and when the server is starting, you can extract this data.

**Client improvements:**

- To support a multiplayer mode, you need to add a new screen for each team.
- Add a new screen with all possible levels for the game.
- Error handling can be added not only on the server, but also on the client side:
  for example, you may show a dialog window with the error message.
- Add sound effects for each correct and incorrect match.
</div>

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn how to create an empty mutable list">

To create a new _mutable_ list, you can use [`mutableListOf`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-list-of.html):

```kotlin
val mutableList =  mutableListOf<Int>(1, 2, 3) // Creates a new mutable list with three numbers
val mutableList =  mutableListOf<Int>() // Creates a new empty mutable list
```
</div>

<div class="hint" title="Click me to learn about the `reversed` built-in function">

If you need to get a list in which the elements are in reverse order,
you can either loop through the elements of the original list from the end to the beginning and
return a new list or use the built-in [`reversed`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/reversed.html) function:

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
