Let's switch to the card model. Add a new interface `CardData` into the `jetbrains.kotlin.course.codenames.card` package.

Next, create a new class `WordCardData` in the same package to store words for this game.
The  `WordCardData` class should inheritance the `CardData` interface 
and have only one immutable field: `word: String`.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="The type of the WordCardData class">
  
The `WordCardData` must be a [data class](https://kotlinlang.org/docs/data-classes.html), because it stores data for the word cards.
</div>
