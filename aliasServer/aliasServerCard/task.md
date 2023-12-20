### Task

Create two classes to work with the cards in the `jetbrains.kotlin.course.alias.card` package in the `CardModel.kt` file:
- a value class `Word` with one `String` `word` property to store a word;
- a data class `Card` to store information for each card.
  Each card must store `id` with the `Identifier` type and a list of `words` (`List<Word>`).
  These properties don't have default values and must be defined in the primary constructor.

<div class="hint" title="Click me if you pressed Check and found a compilation error">

  If you have a compilation error and you have not solved this step yet, please solve the task and try again. 
  It is expected behavior, since the code requires the classes `Word` and `Card`, but they do not exist.
</div>

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about importing Identifier">

To use `Identifier`, you need to import it at the top of the file with the `Word` and `Card`  classes:

  ```kotlin
  package jetbrains.kotlin.course.alias.card

  import jetbrains.kotlin.course.alias.util.Identifier
  ```
</div>

<div class="hint" title="Click me to learn why we use the value class">

Of course, we can just use the `String` type or create a type alias for the `String` type.
All of these options will undoubtedly work in our case.
However, the _purpose_ of this course is to show you the power of Kotlin so that you can
choose the option you like best in the future.
</div>
