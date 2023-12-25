The **goal** of this step is to implement the `Team` class.

First of all, create a type alias `Identifier` in the `jetbrains.kotlin.course.words.generator.team` package in the `TeamModel.kt` file:

- The type alias `Identifier` needs to be an alias of `Int` type. If you change the type in the future (e.g., create a new class),
  it will be changed automatically in all places.


Next, create a data class `Team` in the `jetbrains.kotlin.course.words.generator.team` package in the `TeamModel.kt` file to store the information about teams:
- It must have two properties in the primary constructor: `id` with `Identifier` type to identify each team and `points` with `Int` type
  to store the number of points in the game.
- It must have an additional property `name`, which initializes automatically as `"Team#${id + 1}"` and will be shown in the leaderboard.

Next, add a companion object to the `Team` class with an internal mutable variable `idCounter` with `Identifier`
type and the initial value `0` to help generate new ids for the teams.
After that, put the default values into the primary constructor into the `Team` class:
- use an incremented `idCounter` value for `id`;
- use `0` for `points`.

<div class="hint" title="Click me if you pressed Check and found a compilation error">

  If you have a compilation error and you have not solved this step yet, please solve the task and try again. 
  It is expected behavior, since the code requires the class `Team`, but it does not exist.
</div>

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about the usage of type aliases">

Sometimes, type aliases are used in cases where there uncertainty whether
the type being used will be replaced in the future.

For example, right now, we're using the `Int` type as the `Identifier`,
but in the future, we may create our own class.
Using a type alias in this case will help us make such a transition as seamless as possible.
</div>

<div class="hint" title="Click me to learn why we use the data class">

The class `Team` is responsible for storing information about teams in the game.
It is convenient to use data classes in all cases
when we need just to store something and have automatically implemented methods, like the `toString` method.
</div>

<div class="hint" title="Click me to learn why we use `name` outside of the constructor">

  In this game, the team is defined only by its `id` (as well as the number of points), 
  and we need a `name` only for a pretty display on the screen. 
  This is the main reason why we don't need `name` to be used in automatically defined functions like the `toString` function.
</div>

<div class="hint" title="Click me to learn about access modifiers">

The variable `idCounter` stores internal information about the last value for an id.
Therefore, the best approach is to mark it as a private property to restrict access from outside the class.

A simple example of why it is bad to use the `public` modifier here is that in such a
case, the user would be able to change the value of the `idCounter` property on their own
and we would not be able to ensure the uniqueness of team ids.
</div>

<div class="hint" title="Click me to learn about the short notation used for incrementing">

In Kotlin, you can use `++` to increment a value, where it first returns the old value before incrementing:

```kotlin
var a = 0
println(a) // 0
val b = a
a += 1
println(b) // 0
println(a) // 1
```

It is the **same** as

```kotlin
var a = 0 
println(a) // 0
val b = a++
println(b) // 0
println(a) // 1
```
</div>
