Hello! This lesson focuses on the topics covered in the previous lesson.
The main difference is that this lesson does not contain the theory part,
you just need to implement the project from scratch by yourself.
We have no doubt that you will succeed!

----

### Project description

The project of this lesson is **Words Generator**.
In this game, you need to divide into teams and build new words from one big English word.

### Project example

**TODO**

___

### Task

The **goal** of this step is to implement the `Team` class.

First of all, create a type alias `Identifier` in the `jetbrains.kotlin.course.words.generator.team` package:

- type alias `Identifier` need to be the alias to the `Int` type. If you change the type in the future, e.g. create a new class,
  it will be changes automatically in all places.


Next, create a data class `Team` in the `jetbrains.kotlin.course.words.generator.team` package to store the information about teams:
- it must have two properties in the primary constructor: `id` with `Identifier` type to identify each team and `points` with `Int` type
  to store the number of points in the game. 
- is must have an additional property `name`, that initializes automatically as `"Team#${id + 1}"` and will be shown in the leaderboard.

Next, add a companion object into the `Team` class with an internal mutable variable `idCounter` with `Identifier` 
type and the initial value `0` to help generate new ids for the teams. 
After that, put the default values into the primary constructor into the `Team` class:
- use an incremented `idCounter` value for `id`.
- use `0` for `points`.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Type aliases usage">

Sometimes type aliases are used in cases where there is no certainty that
the type used will not be replaced in the future.

For example, right now we use the `Int` type as the `Identifier`,
but in the future we can create our own class, for example.
Using a type alias in this case will help make this change as painless as possible in the future.
</div>

<div class="hint" title="Why do we use the data class?">

Class `Team` is responsible to store some information about teams in the game.
It is convenient to use data classes in all cases,
when we need just store something and have automatically implemented methods like `toString` method.
</div>

<div class="hint" title="Why are we using name outside of the constructor?">
  In this game, the team is determined only by its `id` (as well as the number of points), 
  and we need a `name` only for a pretty display on the screen. 
  This is the main reason why we don't need `name` to be used in automatically defined functions like `toString` function.
</div>

<div class="hint" title="Access modifiers">

The variable `idCounter` stores some internal information about the last value for id.
So, the best way to mark it as a private property to forbid access outside the class.

A simple example of why it is bad to use the `public` modifier here is that in this
case the user will be able to change the value of the `idCounter` property on his own,
and we cannot guarantee uniqueness of teams ids.
</div>

<div class="hint" title="Short notation for increment">
  
In Kotlin you can use `++` to return the old value and next increment it:

```kotlin
var a = 0
println(a) // 0
val b = a
a += 1
println(b) // 0
println(a) // 1
```

is the **same** with

```kotlin
var a = 0 
println(a) // 0
val b = a++
println(b) // 0
println(a) // 1
```
</div>

___

### Task

The **goal** of this step is to implement the `TeamService` class. 
This class is _almost_ the same with the `TeamService` from the alias game, 
so you can practice again or get your implementation from the previous project and adjust it.

The package `jetbrains.kotlin.course.words.generator.team` already has the regular class `TeamService`.
It is responsible for the game logic for the teams. In this task you need to implement several things to make the game alive:

- Add a companion object into the `TeamService` class and declare the `teamsStorage` variable to store all previous teams.
  The type of the storage should be the `MutableMap` from `Identifier` to `Team`. Don't forget to init it via an empty map.
- Implement the `generateTeamsForOneRound` method.
  The method must generate the teams list and also store all of them into the `teamsStorage` map.
  To create a new instance of the `Team` class, please use default values for the properties: `Team()`.
  We need it to save the games results for the leaderboard.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="List with teams generation">

As was mentioned in the first module, you can generate a new list with `N` elements by the following construction:
  ```kotlin
  List(N) { Team() }
  ```
</div>

<div class="hint" title="putIfAbsent built-in function">

If you work with a `map`, you can use `putIfAbsent` built-in function to put a new value if it is absent in the `map`:
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


<div class="hint" title="forEach built-in function">

If you need to handle each element in a collection, for example in a list or in a map,
you can use the `forEach` built-in function instead of the `for` loop.
In this case you need to write the action inside curly brackets:
  ```kotlin
  val teams = List(N) { Team() }
  for (team in teams) {
    teamsStorage.putIfAbsent(it.id, it)
  }
  ```
is the same with:
  ```kotlin
  val teams = List(N) { Team() }
  teams.forEach { teamsStorage.putIfAbsent(it.id, it) }
  ```
</div>

___

### Task

The **goal** of this step is to implement the `Word` and `WordServices` classes. 

First of all, create a value class `Word` with one `String` `word` property to store a word in the `jetbrains.kotlin.course.words.generator.word` package.

Next, find the already added `WordServices` class in the `jetbrains.kotlin.course.words.generator.word` package and modify it:
- Add a companion object into the `WordServices` class and declare the `numberOfWords` variable to store the number
  of words in the game. Initialize this variable as the _size_ of the predefined list of words `words`.
- Implement `generateNextWord` function: if the `words` list _is empty_, throw an error, 
else get the first element from the `words` list and remove it from the list, create a new `Word` and return it.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Why do we use the value class?">

Of course, we can just use the `String` type or create a type alias for the `String` type.
All of these options will undoubtedly be true in our case.
However, the _purpose_ of this course is to show you the power of Kotlin so that you can
choose the one you like best in the future.
</div>

<div class="hint" title="Why does numberOfWords not a const value?">
  
  We can not mark the `numberOfWords` variable with the `const` keyword since we use `words.size` of a mutable list `words`, 
  that potentially can be changed.
</div>

<div class="hint" title="The `isEmpty` built-in function">

If you need to check if a list is empty you can check its size ot use the [isEmpty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/is-empty.html) built-in function:

  ```kotlin
  val numbers = listOf(1, 2, 3)
  if (numbers.size == 0) {
      TODO()
  }
  ```
is the **same** with

  ```kotlin
  val numbers = listOf(1, 2, 3)
  if (numbers.isEmpty()) {
      TODO()
  }
  ```
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

___

### Task

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

___

### Task

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
