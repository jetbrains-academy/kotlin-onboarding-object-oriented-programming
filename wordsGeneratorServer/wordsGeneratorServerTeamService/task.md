The **goal** of this step is to implement the `TeamService` class.
This class is _almost_ the same as the `TeamService` from the Alias game,
so you can either practice again or get your implementation from the previous project and adjust it.

The package `jetbrains.kotlin.course.words.generator.team` already has the regular class `TeamService`.
It is responsible for the game logic for the teams. In this task, you need to implement several things to make the game alive:

- Add a companion object to the `TeamService` class and declare the `teamsStorage` variable to store all previous teams.
  The type of the storage should be `MutableMap` of `Identifier` to `Team`. Don't forget to init it as an empty map.
- Implement the `generateTeamsForOneRound` method.
  The method must generate the list of teams and also store all of them in the `teamsStorage` map.
  To create a new instance of the `Team` class, please use the default values for the properties: `Team()`.
  We need it to save game results for the leaderboard.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn how to generate a list with teams">

As was mentioned in the first module, you can generate a new list with `N` elements using the following construct:
  ```kotlin
  List(N) { Team() }
  ```
</div>

<div class="hint" title="Click me to learn about the putIfAbsent built-in function">

When working with a `map`, you can use the built-in `putIfAbsent` function to add a new value if it is not present in the `map`:
  ```kotlin
  val myMap = mutableMapOf<Int, String>()
  if (1 !in myMap.keys) {
      myMap[1] = "one"
  }
  ```
It is the same as:
  ```kotlin
  val myMap = mutableMapOf<Int, String>()
  myMap.putIfAbsent(1, "one")
  ```
</div>


<div class="hint" title="Click me to learn about the forEach built-in function">

If you need to handle each element in a collection, for example, in a list or in a map,
you can use the built-in `forEach` function instead of a `for` loop.
In such a case, you need to write the action inside curly brackets:
  ```kotlin
  val teams = List(N) { Team() }
  for (team in teams) {
    teamsStorage.putIfAbsent(it.id, it)
  }
  ```
It is the same as:
  ```kotlin
  val teams = List(N) { Team() }
  teams.forEach { teamsStorage.putIfAbsent(it.id, it) }
  ```
</div>
