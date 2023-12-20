Create a SAM interface to generate key cards:

- Add a value class `KeyCardCell` to the `jetbrains.kotlin.course.codenames.keyCard` 
package in the `KeyCardModel.kt` file with one field `type: KeyCardType`.
- Add a SAM interface `KeyCardGenerator` to the `jetbrains.kotlin.course.codenames.utils` package 
with the `generateData` function, which accepts nothing and returns `List<KeyCardCell>`.

<div class="hint" title="Click me if you pressed Check and found a compilation error">

  If you have a compilation error and you have not solved this step yet, please solve the task and try again. 
  It is expected behavior, since the code requires the value class `KeyCardCell`, but it does not exist.
</div>

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about the JvmInline annotation for value classes">

Don't forget to use the `JvmInline` annotation with the `KeyCardCell` value class:
```kotlin
@JvmInline
value class KeyCardCell(...)
```
</div>

<div class="hint" title="Click me to learn about importing classes from another package">

The `KeyCardCell` class is defined in the `jetbrains.kotlin.course.codenames.keyCard` package, 
but `KeyCardGenerator` must be defined in `jetbrains.kotlin.course.codenames.utils`.
To use `KeyCardCell` in the return type of the `generateData` function, don't forget to import the `KeyCardCell` class:

```kotlin
import jetbrains.kotlin.course.codenames.keyCard.KeyCardCell
```
</div>
