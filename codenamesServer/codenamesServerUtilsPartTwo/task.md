In this version of the game, we will generate only unique key cards.
Improve the `Utils` object in the `jetbrains.kotlin.course.codenames.utils` package:

- Add a `previousAttempts` field with the type `MutableList<List<KeyCardCell>>` 
and init this field via an empty mutable list. We will store the previously generated key cards to avoid duplicates.
- Add a `uniqueKeyCardGenerator` field to the `Utils` object with the type `KeyCardGenerator`.

Implement the `generateData` function for the `uniqueKeyCardGenerator` field in the `Utils` object.
The behavior of the `generateData` function must be the following:
1) Generate a new `List<KeyCardCell>`: put the `number` of each `KeyCardType` into this list and shuffle it.
2) Next, check if this combination of `List<KeyCardCell>` has not been used before (it is not in `previousAttempts`), add this list into `previousAttempts` and return this list.
3) If the generated list has been used before, repeat generation till a new list (that is not in `previousAttempts`) is generated.

Finally, add a new class `KeyCard` to the `jetbrains.kotlin.course.codenames.keyCard` package to store the key class.
Add one immutable field to the primary constructor: `cells: List<KeyCardCell>` and init it through `Utils.uniqueKeyCardGenerator.generateData()` by default.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about initializing an empty mutable list">

To initialize the `previousAttempts` field, you need to create a new empty mutable list:
```kotlin
object Utils {
    ...

    private val previousAttempts: MutableList<List<KeyCardCell>> = mutableListOf()
}
```
</div>

<div class="hint" title="Click me to learn about defining a function for SAM interfaces">

It is better to use a function definition for SAM interfaces:
```kotlin
val uniqueKeyCardGenerator = KeyCardGenerator {
    // The generateData function implementation
}
```
</div>


<div class="hint" title="Click me to learn how to get all values from an enum class">

To get _all_ values from an enum class, you can use the built-in function [values](https://kotlinlang.org/docs/enum-classes.html#working-with-enum-constants).
Consider an example:

```kotlin
enum class KeyCardType(val number: Int) {
    Pink(Utils.PINK_CARDS_NUMBER),
    Violet(Utils.VIOLET_CARDS_NUMBER),
    ...
}

fun main() {
    val enumValuesBase = listOf(KeyCardType.Pink, KeyCardType.Violet, ...)
    // is the same with
    val enumValuesSmart = KeyCardType.values()
}
```
</div>

<div class="hint" title="Click me to learn about the `map` built-in function">

You are already familiar with several built-in functions for lists. 
It's time to get acquainted with the built-in [`map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map.html) function.

This function allows you to apply some kind of _transformation_ to each element of the list and return a new, modified list. 
It is equivalent to using a loop and creating a new list from the original one. Consider an example:

```kotlin
fun main() {
    val initialList = KeyCardType.values()
    val modifiedList = mutableListOf<List<KeyCardType>>()

    for (key in initialList) {
        modifiedList.add(List(key.number) { key })
    }

    println(modifiedList) // [[Pink, Pink, Pink, Pink, Pink, Pink, Pink, Pink], [Violet, Violet, Violet, Violet, Violet, Violet, Violet, Violet, Violet], [Gray, Gray, Gray, Gray, Gray, Gray, Gray], [Black]]
}
```

It is the same as:

```kotlin
fun main() {
    val initialList = KeyCardType.values()
    val modifiedList = initialList.map { key -> List(key.number) { key } }
    
    println(modifiedList) // [[Pink, Pink, Pink, Pink, Pink, Pink, Pink, Pink], [Violet, Violet, Violet, Violet, Violet, Violet, Violet, Violet, Violet], [Gray, Gray, Gray, Gray, Gray, Gray, Gray], [Black]]
}
```

You can also omit `key` and use the default name `it`:
```kotlin
fun main() {
    val initialList = KeyCardType.values()
    val modifiedList = initialList.map { List(it.number) { it } }
    
    println(modifiedList) // [[Pink, Pink, Pink, Pink, Pink, Pink, Pink, Pink], [Violet, Violet, Violet, Violet, Violet, Violet, Violet, Violet, Violet], [Gray, Gray, Gray, Gray, Gray, Gray, Gray], [Black]]
}
```
</div>

<div class="hint" title="Click me to learn how to flatten a list of lists into a single list">

Consider a situation where we have a list of lists, for example, `List<List<KeyCardType>>`, 
and we need to get a list consisting of all the elements of all lists of the original list:
```kotlin
// [[Pink, Pink], [Violet, Violet], [Gray], [Black]] -> [Pink, Pink, Violet, Violet, Gray, Black]
```

We can do that with loops:
```kotlin
fun main() {
    val initialList = listOf(
        listOf(KeyCardType.Pink, KeyCardType.Pink),
        listOf(KeyCardType.Violet, KeyCardType.Violet),
        listOf(KeyCardType.Gray),
        listOf(KeyCardType.Black)
    )
    val finalList = mutableListOf<KeyCardType>()

    for (keyList in initialList) {
        for (key in keyList) {
            finalList.add(key)
        }
    }

    println(finalList) // [Pink, Pink, Violet, Violet, Gray, Black]
}
```

However, Kotlin has a built-in function [`flatten`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/flatten.html) to do the same:
```kotlin
fun main() {
    val initialList = listOf(
        listOf(KeyCardType.Pink, KeyCardType.Pink),
        listOf(KeyCardType.Violet, KeyCardType.Violet),
        listOf(KeyCardType.Gray),
        listOf(KeyCardType.Black)
    )
    val finalList = initialList.flatten()

    println(finalList) // [Pink, Pink, Violet, Violet, Gray, Black]
}
```
</div>

<div class="hint" title="Click me to learn about the `shuffled` built-in function">

Sometimes, you need to randomly shuffle the contents of a list: for example,
to change the order of the words in the original list.
To do that, you can either generate different word positions from the original list and build a new one
or use the built-in function [`shuffled`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/shuffled.html):

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.shuffled()) // 1, 2, 3, 4, 5, 6 in a different random order
  ```
</div>

<div class="hint" title="Click me to learn how to check if an element is in a list">

To check if an element is in a list, you can use the `in` operator:
```kotlin
fun main() {
    val initialList = listOf(
        KeyCardType.Pink,
        KeyCardType.Pink,
        KeyCardType.Black
    )

    println(KeyCardType.Pink in initialList) // true
    println(KeyCardType.Violet in initialList) // false
}
```

The same can also be applied to a list of lists, in which case the function will return `true` if the original list contains 
exactly the _same_ list - the one that has the same size and contains the elements in the same order:

```kotlin
fun main() {
    val initialList = listOf(
        listOf(KeyCardType.Pink, KeyCardType.Pink, KeyCardType.Black),
        listOf(KeyCardType.Violet, KeyCardType.Gray, KeyCardType.Violet)
    )

    println(listOf(KeyCardType.Pink, KeyCardType.Pink, KeyCardType.Black) in initialList) // true
    println(listOf(KeyCardType.Pink, KeyCardType.Black, KeyCardType.Pink) in initialList) // false because of the different order
    println(listOf(KeyCardType.Pink, KeyCardType.Pink) in initialList) // false
}
```
</div>
