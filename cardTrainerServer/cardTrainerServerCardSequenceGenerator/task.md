To train countries and their capitals, it is necessary to show the cards to the user in a certain sequence.
You can come up with various variations of the order of the cards sequence, 
for example, show everything in random order or only those that the user has not yet learned. 
However, they can all be combined with one interface.

In this task create an interface `CardSequenceGenerator` in the `jetbrains.kotlin.course.card.trainer.card` package with only 
one `generateData` function, which accepts nothing and returns `List<Card>`.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Why are we creating a common interface?">

Since we can use different strategies for different application modes and complexities, 
we can create a common interface and, for example, specify it as a data type in functions.

Also, since the interface only has one function, we can make it as a functional interface (SAM).
</div>
