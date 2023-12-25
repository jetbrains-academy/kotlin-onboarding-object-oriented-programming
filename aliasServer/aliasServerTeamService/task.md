### Task

The package `jetbrains.kotlin.course.alias.team` already has a regular class `TeamService`.
It is responsible for the game logic for the teams. In this task, you need to implement several things to make the game alive:

- Add a property `identifierFactory` with the type `IdentifierFactory` to generate identifiers for each team.
  Don't forget to add the default value for it (just create a new instance of the `IdentifierFactory` class).
- Add a companion object to the `TeamService` class and declare the `teamsStorage` variable to store all previous teams.
  The type of the storage should be `MutableMap`, which maps `Identifier` to `Team`. Don't forget to init it via an empty map.
- Implement the `generateTeamsForOneRound` method.
  The method must generate a list of teams and also store all of them into the `teamsStorage` map.
  To create new teams, you need to use `identifierFactory` from the `TeamService` class to generate a new id.
  We need to create this method to save game results for the leaderboard.

If you have any difficulties, **hints will help you solve this task**.

<div class="hint" title="Click me to learn how to convert the generateTeamsForOneRound method from expression form to regular form">

The `generateTeamsForOneRound` method can be implemented either in one line or in several lines, 
so feel free, if necessary, to replace 
```kotlin
fun generateTeamsForOneRound(teamsNumber: Int): List<Team> = TODO("Not implemented yet")
``` 
with 
```kotlin
fun generateTeamsForOneRound(teamsNumber: Int): List<Team> { 
  TODO("Not implemented yet") 
}
```

</div>


----

### Hints

<div class="hint" title="Click me to learn about importing Identifier">

To use `Identifier` and `IdentifierFactory`, you need to import them at the top of the file with the `TeamService` class:

  ```kotlin
  package jetbrains.kotlin.course.alias.team

  import jetbrains.kotlin.course.alias.util.Identifier
  import jetbrains.kotlin.course.alias.util.IdentifierFactory
  ```
</div>

<div class="hint" title="Click me to learn how to create the IdentifierFactory class">

Since the `IdentifierFactory` class has a default value for the `counter` property,
you don't need to set it in the constructor:

  ```kotlin
  val identifierFactory = IdentifierFactory() // CORRECT
  ```
</div>

<div class="hint" title="Click me to learn how to generate a list with teams">

As we mentioned in the first module, you can generate a new list with `N` elements using the following construct:
  ```kotlin
  List(N) { Team(...) }
  ```
</div>

<div class="hint" title="Click me to learn about the putIfAbsent built-in function">

When working with a `map`, you can use the built-in `putIfAbsent` function to insert a new value if it is not already present in the `map`:
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
you can use the built-in `forEach` function instead of the `for` loop.
In such a case, you need to write the action inside curly brackets:
  ```kotlin
  val teams = List(N) { Team(...) }
  for (team in teams) {
    teamsStorage.putIfAbsent(it.id, it)
  }
  ```
It is the same as:
  ```kotlin
  val teams = List(N) { Team(...) }
  teams.forEach { teamsStorage.putIfAbsent(it.id, it) }
  ```
</div>
