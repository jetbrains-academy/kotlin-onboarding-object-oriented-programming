It is time for practice!
In this task, you will create a utility to store the basic game settings!

### Task

Create an object `Utils` in the `jetbrains.kotlin.course.codenames.utils` package to store the general game settings:

- Add several consts to the `Utils` object to store the common constants:
  - `N = 5`, 
  - `TOTAL_NUMBER = N * N`, 
  - `PINK_CARDS_NUMBER = 8`, 
  - `VIOLET_CARDS_NUMBER = 9`, 
  - `GRAY_CARDS_NUMBER = 7`, 
  - `BLACK_CARDS_NUMBER = 1`.
  
  The `N` variable will be used only inside the `Utils` object.
- Add the `init` block to the `Utils` object to check if the sum of `PINK_CARDS_NUMBER`, `VIOLET_CARDS_NUMBER`, `GRAY_CARDS_NUMBER`, and `BLACK_CARDS_NUMBER` exactly equals `TOTAL_NUMBER`.
  If the condition is false, you need to throw an `IllegalArgumentException` error.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about access modifiers">
  
  Only the `N` const variable needs to be `private` because we will be using other variables in future tasks, 
  such as building the key card in the game.
</div>

<div class="hint" title="Click me to learn about the `require` built-in function">
  
Remember to use the built-in [`require`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html) function, which helps to check certain conditions and will throw an `IllegalArgumentException` error if necessary:

```kotlin
object Utils {
    ...
  
    init {
      val sum = ...
      if (sum != TOTAL_NUMBER) {
          throw IllegalArgumentException("The total number of cards in the game must be: $TOTAL_NUMBER")
      }
    }
}
```

It is the same as 

```kotlin
object Utils {
    ...
  
    init {
      require(sum == TOTAL_NUMBER) { "The total number of cards in the game must be: $TOTAL_NUMBER" }
    }
}
```

</div>

