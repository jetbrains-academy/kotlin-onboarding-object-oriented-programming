To help the user learn countries and their capitals, it is necessary to show the cards to the user in a certain sequence.
You can come up with different variations of the order in which the cards are displayed: 
for example, show the cards in a random order or show only those that the user has not yet learned. 
However, these sequences can all be combined in one interface.

In this task, create an interface `CardSequenceGenerator` in the `jetbrains.kotlin.course.card.trainer.card` package in the `CardModel.kt` file with only 
one function – `generateCards`, which accepts nothing and returns `List<Card>`.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn why we create a common interface">

Since we can use different strategies for different application modes and complexity levels, 
we can create a common interface and, for example, specify it as a data type in functions.

Also, since the interface only has one function, we can make it a functional interface (SAM).
</div>
