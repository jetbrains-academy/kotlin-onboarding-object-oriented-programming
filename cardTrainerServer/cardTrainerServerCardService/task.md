The package `jetbrains.kotlin.course.card.trainer.card` already has the regular class `CardService`.
It is responsible for the game logic for the cards.
In this task, you need to implement this service to make the game alive.

First of all, add a simple random generator into the companion object to generate a random sequences of the cards:
- add the variable `randomCardGenerator` with the type `CardSequenceGenerator` and implement the `generateCards` function. 
This function should use the pre-defined map `countries` that stores pairs: capital to county. 
You need to convert all pairs into `Card`, next _shuffle_ this list and return from the function.

Next add a new function `generateNewCardsSequence` into the companion object, that just uses the `randomCardGenerator`, 
calls the function `generateCards` and converts the result into a _mutable_ list.

Next, add a new mutable variable `cards` into the companion object to store the current list of cards and 
initialize with calling the `generateNewCardsSequence` function.

Finally, implement two functions:

- `getNextCard` that checks list from the variable `cards` that it is not empty and next 
removes the first element from this list and returns it.
- `startNewGame` that just put a new sequence of cards into the variable `cards` - you 
can use the `generateNewCardsSequence` function. And next returns the first card - you can call the `getNextCard` function.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Function definition of the SAM interfaces">

It is better to use a function definition for SAM interfaces:
```kotlin
val randomCardGenerator = CardSequenceGenerator {
    // The generateCards function implementation
}
```
</div>

<div class="hint" title="The `map`built-in function">

You can use the `map` built-in function to change each pair inside a map collection:

  ```kotlin
  val numbers = mapOf("one" to 1,"two" to 2, "three" to 3)
  val squared = numbers.map { (key, value) -> 
      MyClass(key, value) 
  } // [MyClass("one", 1), MyClass("two", 2), MyClass("three", 3)]
  ```
</div>

<div class="hint" title="The `shuffled` built-in function">

Sometimes, you need to randomly shuffle the contents of a list: for example,
to change the order of the cards in the original list.
To do this, you can generate different cards positions from the original list and build a new one,
or use the built-in function [`shuffled`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/shuffled.html):

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.shuffled()) // 1, 2, 3, 4, 5, 6 in a different random order
  ```
</div>

<div class="hint" title="The main difference between mutable and readonly lists">

We'll get into the details of collections in the next module, for now it is enough to know some basics facts:
1) We can create readonly and mutable lists. 
You can initialize a readonly list and next only read the elements. 
If you create a mutable list, you can change the elements after list's initialization:

```kotlin
val readOnlyNumbers = listOf(1, 2, 3, 4, 5, 6)
readOnlyNumbers.add(7) // ERROR
println(readOnlyNumbers[2]) // OK

val mutableNumbers = mutableListOf(1, 2, 3, 4, 5, 6)
readOnlyNumbers.add(7) // OK
println(readOnlyNumbers[2]) // OK
```

2) You can convert a readonly list into a mutable one:
```kotlin
val readOnlyNumbers = listOf(1, 2, 3, 4, 5, 6)
val mutableNumbers = readOnlyNumbers.toMutableList()
readOnlyNumbers.add(7) // OK
println(readOnlyNumbers[2]) // OK
```
</div>

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

<div class="hint" title="The `require` built-in function">

To check some condition and throw an `IllegalArgumentException` error, you can use the built-in [`require`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html) function:

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
Note, you need to use an _opposite_ condition!
</div>

<div class="hint" title="The `removeFirst` built-in function">

If you need to get the first element from a mutable list and next remove it, you can use the [removeFirst](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/remove-first.html) built-in function:

```kotlin
fun main() {
    val numbers = mutableListOf(2, 3, 4, 5)
    val first = numbers.first()
    numbers.drop(1)
    println(first) // 2
    println(numbers) // [3, 4, 5]
}
```
is the **same** with

```kotlin
fun main() {
    val numbers = mutableListOf(2, 3, 4, 5)
    val first = numbers.removeFirst()
    println(first) // 2
    println(numbers) // [3, 4, 5]
}
```
</div>
