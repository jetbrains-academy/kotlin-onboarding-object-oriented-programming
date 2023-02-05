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