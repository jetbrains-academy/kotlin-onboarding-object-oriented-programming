The **goal** of this step is to add validators into the `WordServices` class.

Find the already added `WordServices` class in the `jetbrains.kotlin.course.words.generator.word` package and modify it.

- Implement the `isValidWord` function.

  - If `newWord` (the word was input by the user) _is empty_, return `false`
  - If `newWord` contains symbols not from `keyWord`, return `false`.
    Note, the number of times some symbol occurs in `newWord` cannot be grater
    than this the number of times this symbol occurs in `keyWord`
  ```kotlin
  val a = service.isValidWord("photothermoelasticity", "") // false
  val b = service.isValidWord("photothermoelasticity", "dog") // false
  val c = service.isValidWord("photothermoelasticity", "photo") // true
  val c = service.isValidWord("photothermoelasticity", "photooooo") // false, because the initial word contains <o> two times
  ```

- Add an internal variable `previousWords` into companion object in this class with the type `mutableMapOf<String, MutableList<Word>>`
  that maps each game word to the list of already guessed words. Don't forget to init this map with an empty map.
- Implement the `isNewWord` function:

  - if `previousWords` does not contain `keyWord` yet, return `true`
  - else if the list of words `previousWords[keyWord]` contains `newWord` return `false`, else return `true`

If you have any difficulties, **hints will help you solve this task**.

----

**TODO: add hints about algorithms for both functions?**

### Hints

<div class="hint" title="The `isEmpty` built-in function">

You can also use `isEmpty` function with strings, not only with lists:

  ```kotlin
  fun main() {
    println("".isEmpty()) // true
    println("cat".isEmpty()) // false
  }
  ```
</div>

<div class="hint" title="The aggregation built-in functions">

Kotlin has a lot of built-in functions for aggregation, consider several of them to help solving this task.
You can use the [`groupingBy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/grouping-by.html) to group the word by its letters
and next the [`eachCount`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/each-count.html) to count each letter:

  ```kotlin
  fun main() {
    val word = "photothermoelasticity"
    val grouped = word.groupingBy { it }.eachCount() // returns a map
    println(grouped) // {p=1, h=2, o=3, t=4, e=2, r=1, m=1, l=1, a=1, s=1, i=2, c=1, y=1}
  }
  ```

These functions work with special representation [Grouping](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-grouping/), we will consider in the third module of this course in detail.
</div>

<div class="hint" title="The `all` built-in function">

If you need verification that if **all** elements match the given predicate, you can use the [`all`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/all.html) built-in function.
The predicate you need to put into the curly brackets:

  ```kotlin
  val evenNumbers = listOf(2, 4, 6)
  println(evenNumbers.all { it % 2 == 0 }) // true
  println(evenNumbers.all { it == 4 }) // false, because only one item satisfies the predicate
  ```
</div>

<div class="hint" title="putIfAbsent built-in function">

If you work with a `map`, you can use `putIfAbsent` built-in function to put a new value if it absent in the `map`:
  ```kotlin
  val myMap = mutableMapOf<Int, String>()
  if (1 !in myMap.keys) {
      myMap[1] = "one"
  }
  ```
is the same with:
  ```kotlin
  val myMap = mutableMapOf<Int, String>()
  myMap.putIfAbsent(1, "one")
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