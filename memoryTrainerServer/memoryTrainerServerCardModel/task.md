The **goal** of this step is to implement the `Card` class.

First of all, create helper classes to store the names of countries and their capitals:

- It should be two `value` classes `Front` and `Back` in the `jetbrains.kotlin.course.card.trainer.card` package in the `CardModel.kt` file, which store one string each: `capital` for `Front` and `country` for `Back`.

Finally, create a class `Card` in the same package in the same file to store the information for each card, i.e., countries and capitals:

- It must have two properties in the primary constructor:
    - `front` with `Front` type to store capitals;
    - `back` with `Back` type to store countries.

<div class="hint" title="Click me if you pressed Check and found a compilation error">

  If you have a compilation error and you have not solved this step yet, please solve the task and try again. 
  It is expected behavior, since the code requires the class `Card`, but it does not exist.
</div>

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about the JvmInline annotation for value classes">

Remember to use the `JvmInline` annotation with the `Front` and `Back` value classes:
```kotlin
@JvmInline
value class Front(...)
```
</div>
