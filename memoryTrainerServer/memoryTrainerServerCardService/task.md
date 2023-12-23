The package `jetbrains.kotlin.course.card.trainer.card` already has the regular class `CardService`.
It is responsible for the game logic for the cards.
In this task, you need to implement this service to make the game alive.

First of all, add a simple random generator to the companion object to generate random sequences of the cards:
- Add the variable `randomCardGenerator` with the type `CardSequenceGenerator` and implement the `generateCards` function. 
This function should use the pre-defined map `countries`, which stores pairs: capital to country. 
You need to convert all pairs into `Card`, then _shuffle_ this list, and return it from the function.

Next, add a new function `generateNewCardsSequence` to the companion object, which uses `randomCardGenerator`, 
calls the function `generateCards`, and converts the result into a _mutable_ list.

Next, add a new mutable variable `cards` to the companion object to store the current list of cards and 
initialize it by calling the `generateNewCardsSequence` function.

Finally, implement two functions:

- `getNextCard`, which checks the list from the variable `cards` to make sure it is not empty, next 
removes the first element from this list and returns it.
- `startNewGame`, which just puts a new sequence of cards into the variable `cards` – you 
can use the `generateNewCardsSequence` function. Next it returns the first card – you can call the `getNextCard` function.

After solving this task, you can try playing the game, but the `Finish game` button will not work:

![The current state of the application](../../utils/src/main/resources/images/states/memoryTrainer/state1.gif)

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about defining a function for SAM interfaces">

It is better to use a function definition for SAM interfaces:
```kotlin
val randomCardGenerator = CardSequenceGenerator {
    // The generateCards function implementation
}
```
</div>

<div class="hint" title="Click me to learn about the `map` built-in function">

You can use the built-in [`map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map.html) function to modify each pair in a map collection:

  ```kotlin
  val numbers = mapOf("one" to 1,"two" to 2, "three" to 3)
  val squared = numbers.map { (key, value) -> 
      MyClass(key, value) 
  } // [MyClass("one", 1), MyClass("two", 2), MyClass("three", 3)]
  ```
</div>

<div class="hint" title="Click me to learn about the `shuffled` built-in function">

Sometimes, you need to randomly shuffle the contents of a list: for example,
to change the order of the cards in the original list.
To do that, you can either generate different card positions from the original list and build a new list
or use the built-in function [`shuffled`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/shuffled.html):

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.shuffled()) // 1, 2, 3, 4, 5, 6 in a different random order
  ```
</div>

<div class="hint" title="Click me to learn about the main difference between mutable and read-only lists">

We'll go into the details of collections in the next module; for now, it is enough to know some basics facts:
1) We can create both read-only and mutable lists. 
If you initialize a read-only list, you can only read its elements. 
If you create a mutable list, you can modify its elements after list initialization:

```kotlin
val readOnlyNumbers = listOf(1, 2, 3, 4, 5, 6)
readOnlyNumbers.add(7) // ERROR
println(readOnlyNumbers[2]) // OK

val mutableNumbers = mutableListOf(1, 2, 3, 4, 5, 6)
readOnlyNumbers.add(7) // OK
println(readOnlyNumbers[2]) // OK
```

2) You can convert a read-only list into a mutable one:
```kotlin
val readOnlyNumbers = listOf(1, 2, 3, 4, 5, 6)
val mutableNumbers = readOnlyNumbers.toMutableList()
readOnlyNumbers.add(7) // OK
println(readOnlyNumbers[2]) // OK
```
</div>

<div class="hint" title="Click me to learn about the `isNotEmpty` built-in function">

In case you need to check that a list is not empty, you can either check its size or use the built-in [isNotEmpty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/is-not-empty.html) function:

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

<div class="hint" title="Click me to learn about the `require` built-in function">

To check a certain condition and throw an `IllegalArgumentException` error if necessary, you can use the built-in [`require`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html) function:

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

<div class="hint" title="Click me to learn about the `removeFirst` built-in function">

If you need to get the first element from a mutable list and then remove it, you can use the built-in [`removeFirst`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/remove-first.html) function:

```kotlin
fun main() {
    val numbers = mutableListOf(2, 3, 4, 5)
    val first = numbers.first()
    numbers.drop(1)
    println(first) // 2
    println(numbers) // [3, 4, 5]
}
```
It is the **same** as

```kotlin
fun main() {
    val numbers = mutableListOf(2, 3, 4, 5)
    val first = numbers.removeFirst()
    println(first) // 2
    println(numbers) // [3, 4, 5]
}
```
</div>
