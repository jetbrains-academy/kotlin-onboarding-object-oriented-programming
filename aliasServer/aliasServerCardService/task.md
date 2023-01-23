### Task

It's time to revive the cards. The package `jetbrains.kotlin.course.alias.card` already has the regular class `CardService`.
You just need to add several properties and implement several methods:

- add a property `identifierFactory` with the type `IdentifierFactory` to generate identifiers for each card.
  Don't forget to add the default value for it (just create a new instance of the `IdentifierFactory` class).
- add a property `cards` that stores a list of cards (`List<Card>`), you should initialize it by the calling
  the `generateCards` method.
- add a companion object into the `CardService` class and declare the `WORDS_IN_CARD` const variable to store the number
  of words for the cards.
  You need to assign the value `4` for it. Also declare `cardsAmount` here, that stores the possible number of
  cards: `words.size / WORDS_IN_CARD`.
  The project contains the predefined list of words `words`.
- add the `toWords` function into the `CardService` class, that is an extension function for `List<String>`
  and converts each element from this list into `Word`.
- implement the `generateCards` function that shuffles the `words` list, chunks into chunks with `WORDS_IN_CARD` words
  each,
  takes `cardsAmount` chunks for `cardsAmount` cards, and finally creates a new `Card` for each chunk.
- implement the `getCardByIndex` method that accepts `index` (an integer number) and the `Card` at this index.
  If the card does not exist, throw an error.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="The `shuffled` built-in function">

Sometimes you need to randomly shuffle the contents of a list, for example,
to change the order of the words in the original list.
To do this, you can generate different word positions from the original list and build a new one,
or use the built-in function [`shuffled`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/shuffled.html):

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.shuffled()) // 1, 2, 3, 4, 5, 6 in the different random order
  ```
</div>

<div class="hint" title="The `chunked` built-in function">

Sometimes you need to split a list into `N` sublists of the same length,
for example when you want a large list of words into sublists for each game card.
To do this, you can manually iterate every `N` elements and create a new sublist,
but you can use the built-in function [`chunked`](https://kotlinlang.org/docs/collection-parts.html#chunked):

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.chunked(2)) // [[1, 2], [3, 4], [5, 6]]
  ```
</div>

<div class="hint" title="The `take` built-in function">

Sometimes you need to take the first `N` elements from a list,
for this you can loop up to the `N` element and make a new list,
or use the built-in function [`take`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/take.html).

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.take(4)) // [1, 2, 3, 4]
  ```
</div>

<div class="hint" title="Chaining multiple function calls">

In Kotlin you don't need to create a new variable for each call of functions
if you work with collections, e.g. with a list.
You can call them sequentially, thus creating a chain of calls:

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  val chunkedList = numbers.chunked(2)
  println(chunkedList.take(2)) // [[1, 2], [3, 4]]
  ```

is the **same** with

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.chunked(2).take(2)) // [[1, 2], [3, 4]]
  ```
</div>

<div class="hint" title="The `map` and `forEach` built-in functions">

If you need to handle each element in a collection, for example in a list or in a map,
you can use the `forEach` or `map` built-in functions instead of the `for` loop.
In this case you need to write the action inside curly brackets.

The main difference between `forEach` or `map` is the return value.
If you use the `map` function, you **will get** a new collection, e.g. a list with transformed values and can continue the sequence of the calls.
If you use the `forEach` function, you **will not get** a new collection:

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  for (number in numbers) {
    println(number)
  }
  ```
is the **same** with:
  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  numbers.forEach { println(it) }
  ```

But if you use the `map` function, behaviour will be different:
  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  val squared = numbers.map { 
    println(it) 
    it * it
  } // [1, 4, 9, 16, 25, 36]
  ```

In the last case the initial list `[1, 2, 3, 4]` will be printed, and next each number in this list will be squared.
The result of the last action in the curly brackets will be in the final list.

You also can combine map with other function:
  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.take(3).map { it * it }) // [1, 4, 9]
  ```
</div>

<div class="hint" title="The `getOrNull` built-in function">

If you try to get an element from a list be the index and this index does not exit, you will get an error.
To avoid this, you can use the built-in function [`getOrNull`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/get-or-null.html) that returns the value or `null` if the index does not exist:

  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  println(numbers[10]) // Throws the index of bounds error

  println(numbers.getOrNull(10) ?: error("You use incorrect index 10 for the list")) // Is better because the error will inform the user about the error in detail
  ```
</div>