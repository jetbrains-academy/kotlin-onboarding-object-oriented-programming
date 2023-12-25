Next, we need to create a special class to store the card information. 
First, we need to create a new enum class to store the state for the cards.
Create an enum class `CardState` in the package `jetbrains.kotlin.course.codenames.card` in the `CardModel.kt` file. 
This class must store two values: `Front` and `Back`.

Second, create a class `Card` in the same package in the same file with two immutable fields in the 
primary constructor: `data: CardData` and `state: CardState`.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about the type of the Card class">

`Card` must be a [data class](https://kotlinlang.org/docs/data-classes.html) because it stores data for the cards.
</div>
