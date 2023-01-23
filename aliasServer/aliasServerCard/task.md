### Task

Create two classes to work with the cards in the `jetbrains.kotlin.course.alias.card` package:
- a value class `Word` with one `String` `word` property to store a word;
- a data class `Card` to store information for each card.
  Each card must store `id` with the `Identifier` type, and a list of `words` (`List<Word>`).
  These properties don't have default values and also must be defined in the primary constructor.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Import Identifier">

To use `Identifier` you need to import it in the top on the file with the `Word` and `Card`  classes:

  ```kotlin
  package jetbrains.kotlin.course.alias.card

  import jetbrains.kotlin.course.alias.util.Identifier
  ```
</div>

<div class="hint" title="Why do we use the value class?">

Of course, we can just use the `String` type or create a type alias for the `String` type.
All of these options will undoubtedly be true in our case.
However, the _purpose_ of this course is to show you the power of Kotlin so that you can
choose the one you like best in the future.
</div>