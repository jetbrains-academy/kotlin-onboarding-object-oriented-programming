In our game, there is a card for the two leaders, which shows the location of words and their corresponding colors. 
This card is called `KeyCard`.

In this step, create an enum class `KeyCardType` function
in the `jetbrains.kotlin.course.codenames.keyCard` package:

- the enum class `KeyCardType` must store four values: `Pink`, `Violet`, `Gray`, and `Black`.
  Each value must store an `Int` called `number` to initialize the number of times you need to use the consts from the `Utils` object.

<div class="hint" title="I press Check and see a compilation error">

  If you have a compilation error, and you have not solved this step yet, please solve the task and try again. 
  It is expected behavior since the code requires the enum class `KeyCardType`, but it does not exist.
</div>

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="What does the KeyCard look like in the game?">

Each square corresponds to a card on the field:

![KeyCard example](../../utils/src/main/resources/images/states/codenames/keycardSmall.png)
</div>
