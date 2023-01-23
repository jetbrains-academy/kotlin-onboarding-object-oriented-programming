
### Task

The package `jetbrains.kotlin.course.alias.team` already has the regular class `TeamService`.
It is responsible for the game logic for the teams. In this task you need to implement several things to make the game alive:

- add a property `identifierFactory` with the type `IdentifierFactory` to generate identifiers for each team.
  Don't forget to add the default value for it (just create a new instance of the `IdentifierFactory` class).
- add a companion object into the `TeamService` class and declare the `teamsStorage` variable to store all previous teams.
  The type of the storage should be the `MutableMap` of `Identifier` to `Team`. Don't forget to init it via an empty map.
- implement the `generateTeamsForOneRound` method.
  The method must generate the teams list and also store all of them into the `teamsStorage` map.
  We need it to save the games results for the leaderboard.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Import Identifier">

To use `Identifier` and `IdentifierFactory` you need to import it in the top on the file with the `TeamService` class:

  ```kotlin
  package jetbrains.kotlin.course.alias.team

  import jetbrains.kotlin.course.alias.util.Identifier
  import jetbrains.kotlin.course.alias.util.IdentifierFactory
  ```
</div>

<div class="hint" title="Create IdentifierFactory class">

Since `IdentifierFactory` class has the default value for the `counter` property,
you don't need to set up it in the constructor:

  ```kotlin
  val identifierFactory = IdentifierFactory() // CORRECT
  ```
</div>

<div class="hint" title="List with teams generation">

As was mentioned in the first module, you can generate a new list with `N` elements by the following construction:
  ```kotlin
  List(N) { Team(...) }
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

<div class="hint" title="forEach built-in function">

If you need to handle each element in a collection, for example in a list or in a map,
you can use the `forEach` built-in function instead of the `for` loop.
In this case you need to write the action inside curly brackets:
  ```kotlin
  val teams = List(N) { Team(...) }
  for (team in teams) {
    teamsStorage.putIfAbsent(it.id, it)
  }
  ```
is the same with:
  ```kotlin
  val teams = List(N) { Team(...) }
  teams.forEach { teamsStorage.putIfAbsent(it.id, it) }
  ```
</div>