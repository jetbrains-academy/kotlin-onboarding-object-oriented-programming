In our game, there is a card for the two leaders, which shows the location of words and their corresponding colors. 
This card is called `KeyCard`.

In this step, create an enum class `KeyCardType` in the `jetbrains.kotlin.course.codenames.keyCard` package in the `KeyCardModel.kt` file:

- The enum class `KeyCardType` must store four values: `Pink`, `Violet`, `Gray`, and `Black`.
  Each value must store an `Int` called `number` to initialize the number of times you need to use the consts from the `Utils` object.

<div class="hint" title="Click me if you pressed Check and found a compilation error">

  If you have a compilation error and you have not solved this step yet, please solve the task and try again. 
  It is expected behavior, since the code requires the enum class `KeyCardType`, but it does not exist.
</div>

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn what the KeyCard looks like in the game">

Each square corresponds to a card in the field:

![KeyCard example](../../utils/src/main/resources/images/states/codenames/keycardSmall.png)
</div>
