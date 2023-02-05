Create a SAM interface to generate key cards:

- add a value class `KeyCardCell` in the `jetbrains.kotlin.course.codenames.keyCard` 
package with one field `type: KeyCardType`
- add a SAM interface `KeyCardGenerator` in the `jetbrains.kotlin.course.codenames.utils` package 
with the `generateData` function, that accepts nothing and returns `List<KeyCardCell>`

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="The JvmInline annotation for value classes">

Don't forget to use the `JvmInline` annotation with the `KeyCardCell` value class:
```kotlin
@JvmInline
value class KeyCardCell(...)
```
</div>

<div class="hint" title="Import classes from another package">

The `KeyCardCell` class is defined in the `jetbrains.kotlin.course.codenames.keyCard` package, 
but the `KeyCardGenerator` must be defined in the `jetbrains.kotlin.course.codenames.utils`.
To use `KeyCardCell` in the return type of the `generateData` function, don't forget to import the `KeyCardCell` class:

```kotlin
import jetbrains.kotlin.course.codenames.keyCard.KeyCardCell
```
</div>
