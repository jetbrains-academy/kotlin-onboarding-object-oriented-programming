Let's switch to the card model. Add a new interface `CardData` to the `jetbrains.kotlin.course.codenames.card` package in the `CardModel.kt` file.

Next, create a new class `WordCardData` in the same package in the same file to store words for this game.
The  `WordCardData` class should inherit from the `CardData` interface 
and have only one immutable field: `word: String`.

<div class="hint" title="I press Check and see a compilation error">

  If you have a compilation error and you have not solved this step yet, please solve the task and try again. 
  It is expected behavior, since the code requires the value class `WordCardData`, but it does not exist.
</div>

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about the type of the WordCardData class">
  
`WordCardData` must be a [data class](https://kotlinlang.org/docs/data-classes.html) because it stores data for the word cards.
</div>
