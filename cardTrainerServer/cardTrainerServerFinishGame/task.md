Wow! You've almost finished the project! This is the last step.
In this step, you need to add statistics to the game.

First of all, you need to add a class `Stat` to the `jetbrains.kotlin.course.card.trainer.stat` package to store statistics:

- it must have two properties in the primary constructor:
    - `knownBacks` with `List<Back>` type to store known countries;
    - `unknownBacks` with `List<Back>` type to store unknown countries.

Next, you need to implement several methods in the already defined class `StatService` 
in the package `jetbrains.kotlin.course.card.trainer.card`:
- add a `history` property to the companion object with type `MutableList<Stat>` and initialize it with an empty list;
- implement the method `save`, which `adds` new `Stat` to `history`;
- implement the method `getHistory`, which returns _reversed_ `history`.


Hooray! After finishing this step, the application will work well:

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
