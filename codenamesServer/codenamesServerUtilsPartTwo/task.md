In this version of the game we will generate only unique key cards.
Improve the `Utils` object in the `jetbrains.kotlin.course.codenames.utils` package:

- add a `previousAttempts` field with the type `MutableList<List<KeyCardCell>>` 
and init this field via an empty mutable list. We will store the previous generated key cards to avoid duplicates.
- add a `uniqueKeyCardGenerator` field into the `Utils` object with the type `KeyCardGenerator`.

Implement the `generateData` function for the `uniqueKeyCardGenerator` field in the `Utils` object.
The behaviour of the `generateData` function must be the following:
1) Generate a new `List<KeyCardCell>`: put the `amount` of each `KeyCardType` into this list and shuffle it.
2) Next, check if this combination of `List<KeyCardCell>` was not used before (it is not in the `previousAttempts`) and return this list.
3) If the generated list was used before, repeat generation while a new list (that is not in the `previousAttempts`) will not be generated.

Finally, add a new class `KeyCard` into the `jetbrains.kotlin.course.codenames.keyCard` package to store the key class.
Add one immutable field into the primary constructor: `cells: List<KeyCardCell>` and init through `Utils.uniqueKeyCardGenerator.generateData()` by default.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Empty mutable list initialization">

To initialize the `previousAttempts` field you need to create a new empty mutable list:
```kotlin
object Utils {
    ...

    private val previousAttempts: MutableList<List<KeyCardCell>> = mutableListOf()
}
```
</div>

<div class="hint" title="Function definition of the SAM interfaces">

It is better to use the function definition for SAM interfaces:
```kotlin
val uniqueKeyCardGenerator = KeyCardGenerator {
    // The generateData function implementation
}
```
</div>


**TODO: add more hints**