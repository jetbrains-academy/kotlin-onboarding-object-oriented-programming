### Task

Create a data class `Team` in the `jetbrains.kotlin.course.alias.team` package in the `TeamModel.kt` file to store the information about teams:
- It must have two properties in the primary constructor: `id` of `Identifier` type to identify each team and `points` of `Int` type
  to store the number of points in the game. For `points`, set the default value `0`.
- It must have an additional property `name`, which initializes automatically as `"Team#${id + 1}"` and will be shown in the leaderboard.

<div class="hint" title="Click me if you pressed Check and encountered a compilation error">

  If you encounter a compilation error and have not completed this task yet, please solve it first and then try again. 
  This is expected behavior, since the code requires the class `Team`, which currently does not exist.
</div>


If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about importing Identifier">

To use `Identifier`, you need to import it at the top of the file with the `Team` class:

  ```kotlin
  package jetbrains.kotlin.course.alias.team

  import jetbrains.kotlin.course.alias.util.Identifier
  ```
</div>


<div class="hint" title="Click me to learn why we use the data class">

The class `Team` is responsible for storing information about the teams in the game.
It is convenient to use data classes in all cases
when we need just to store something and have automatically implemented methods like `toString`.
</div>

<div class="hint" title="Click me to learn why we use `name` outside of the constructor">

  In this game, the team is defined only by its `id` (as well as the number of points), 
  and we need a `name` only for a pretty display on the screen. 
  This is the main reason why we don't need `name` to be used in automatically defined functions like the `toString` function.
</div>
