The package `jetbrains.kotlin.course.codenames.keyCard` already has the regular class `KeyCardService`.
It is responsible for the game logic for the key card. 
In this task, you need to implement the `generateKeyCard` function to make the game alive:

- implement the `generateKeyCard` function, which returns a new instance of the `KeyCard` class


After finishing this task you will be able to see the generated `KeyCard`, but the game field will not be generated yet:

![The current state of the game](../../utils/src/main/resources/images/states/codenames/state1.gif)

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="New instance of a class creation">

You just need to create a new instance of the `KeyCard` class: `KeyCard()`. 
Since it already has a default value for the `cells` filed, 
you can omit the arguments.
</div>
