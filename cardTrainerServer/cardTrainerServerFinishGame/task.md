Wow! You've almost finished the project! This is the last step.
On this step you need to add statistics to the game.

First of all, you need to add a class `Stat` in the `jjetbrains.kotlin.course.card.trainer.stat` package to store statics:

- it must have two properties in the primary constructor:
    - `knownBacks` with `List<Back>` type to store known countries;
    - `unknownBacks` with `List<Back>` type to store unknown countries.

Next, you need to implement several methods in already defined class `StatService` 
in the package `jetbrains.kotlin.course.card.trainer.card`:
- add a `history` property into the companion object with type `MutableList<Stat>` and initialize it with an empty list;
- implement the method `save` that `adds` new `Stat` into `history`;
- implement the method `getHistory` that returns _reversed_ `history`.


Hooray! After finishing this step the application will work well:

![The current state of the application](../../utils/src/main/resources/images/states/cardTrainer/state2.gif)

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="How to create an empty mutable list">

To create a new _mutable_ list, you can use [`mutableListOf`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/mutable-list-of.html):

```kotlin
val mutableList =  mutableListOf<Int>(1, 2, 3)
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
