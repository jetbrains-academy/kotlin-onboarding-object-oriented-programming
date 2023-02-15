The **goal** of this step is to implement the `Card` class.

First of all, create helper classes to store capitals and countries:

- it should be two value classes `Front` and `Back` that store one string: `capital` for `Front` and `country` for `Back`.

Finally, create a class `Card` in the `jetbrains.kotlin.course.card.trainer.card` package to store the information for each card, e.g. cities and capitals:

- it must have two properties in the primary constructor:
    - `front` with `Front` type to store capitals;
    - `back` with `Back` type to store countries;

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="The JvmInline annotation for value classes">

Don't forget to use the `JvmInline` annotation with the `Front` and `Back` value classes:
```kotlin
@JvmInline
value class Front(...)
```
</div>
