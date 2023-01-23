### Task

Create a data class `Team` in the `jetbrains.kotlin.course.alias.team` package to store the information about teams:
- it must have two properties in the primary constructor: `id` with `Identifier` type to identify each team and `points` with `Int` type
  to store the number of points in the game. For `points` set the default value `0`.
- is must have an additional property `name`, that initializes automatically as `"Team#${id + 1}"` and will be shown in the leaderboard.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Import Identifier">

To use `Identifier` you need to import it in the top on the file with the `Team` class:

  ```kotlin
  package jetbrains.kotlin.course.alias.team

  import jetbrains.kotlin.course.alias.util.Identifier
  ```
</div>


<div class="hint" title="Why do we use the data class?">

Class `Team` is responsible to store some information about teams in the game.
It is convenient to use data classes in all cases,
when we need just store something and have automatically implemented methods like `toString`.
</div>

<div class="hint" title="Why are we using name outside of the constructor?">
  In this game, the team is determined only by its `id` (as well as the number of points), 
  and we need a `name` only for a pretty display on the screen. 
  This is the main reason why we don't need `name` to be used in automatically defined functions like `toString` function.
</div>