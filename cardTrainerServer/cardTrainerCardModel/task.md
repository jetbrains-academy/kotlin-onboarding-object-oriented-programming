The **goal** of this step is to implement the `Card` class.

First of all, you have already implemented `IdentifierFactory` class and a type alias `Identifier`, 
you can find them in the [Utils.kt](./src/main/kotlin/jetbrains/kotlin/course/card/trainer/util/Utils.kt) file.
They are responsible for unique identifier generation, but you are familiar with them from the previous projects.

Next, create helper classes to store capitals and countries:

- it should be two value classes `Front` and `Back` that store one string: `capital` for `Front` and `country` for `Back`.

Finally, create a class `Card` in the `jetbrains.kotlin.course.card.trainer.card` package to store the information for each card, e.g. cities and capitals:

- add an `idFactory` to the `companion object` and initialize it with new `IdentifierFactory` instance; 
- the class `Card` must two three properties in the primary constructor:
    - `front` with `Front` type to store capitals;
    - `back` with `Back` type to store countries;
- also, add an additional property outside the primary constructor:
    - `id` with `Identifier` type to identify each card, 
     put the default value `idFactory.uniqueIdentifier()` for automatic generation 
     of unique identifiers

If you have any difficulties, **hints will help you solve this task**.

----

### Hints
