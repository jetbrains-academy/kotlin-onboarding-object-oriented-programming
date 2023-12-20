### Definition

You are already briefly familiar with [`List`](https://kotlinlang.org/docs/collections-overview.html#list), which stores a list of objects of the same type,
such as `List<Int>`. The second popular collection type is [`Map`](https://kotlinlang.org/docs/collections-overview.html#map).
It stores key-value pairs such that all keys are different but the values can be the same.
`Map` is very similar to an address book, where you can find the corresponding address for each person.
Accordingly, the same address can occur several times, but each person will appear in the book only once.

In Kotlin, if you want to create a _mutable_ `Map`, then you need to indicate it _explicitly_
because by default, a _read-only_ collection is created
and it will not be possible to add new elements to it later.

To create a new map, you can use `mapOf` for a _read-only_ collection or `mutableMapOf` for a _mutable_ one:

```kotlin
val readOnlyMap = mapOf<Int, String>(1 to "one", 2 to "two")
readOnlyMap.put(3 to "three") // ERROR

val mutableMap =  mutableMapOf<Int, String>(1 to "one", 2 to "two")
mutableMap.put(3 to "three") // OK
```

To create an empty _mutable_ map, you need to use the `mutableMapOf` function rather than `emptyMap` used for a _read-only_ map:

```kotlin
val emptyMutableMapError: MutableMap<Int, Int> = emptyMap() // ERROR

val emptyMutableMapOk: MutableMap<Int, Int> =  mutableMapOf() // OK
```

#### Built-in functions

You can find a lot of useful built-in functions to work with maps in the [official Kotlin documentation](https://kotlinlang.org/docs/map-operations.html).
Let's consider several basic ones, which can help you to solve this task.

<div class="hint" title="Click me to learn about the `keys` built-in property">

If you need to get all _keys_ from a read-only or mutable map, you can use the [_keys_](https://kotlinlang.org/docs/map-operations.html#retrieve-keys-and-values) property:
  ```kotlin
  val readOnlyMap = mapOf<Int, String>(1 to "one", 2 to "two")
  for (key in readOnlyMap.keys) {
      println(key) // Will print 1 and 2
  }
  ```
</div>

<div class="hint" title="Click me to learn about the `values` built-in property">

If you need to get all _values_ from a read-only or mutable map, you can use the [_values_](https://kotlinlang.org/docs/map-operations.html#retrieve-keys-and-values) property:
  ```kotlin
  val mutableMap = mutableMapOf<Int, String>(1 to "one", 2 to "two")
  for (value in mutableMap.values) {
      println(value) // Will print "one" and "two"
  }
  ```
</div>

<div class="hint" title="Click me to learn how to get a value by key">

If you need to get a value by key, you can use the [following construction](https://kotlinlang.org/docs/map-operations.html#retrieve-keys-and-values):
  ```kotlin
  val readOnlyMap = mapOf<Int, String>(1 to "one", 2 to "two")
  println(readOnlyMap[1]) // one
  ```

However, it can return `null` if the key does not exist:
  ```kotlin
  val readOnlyMap = mapOf<Int, String>(1 to "one", 2 to "two")
  println(readOnlyMap[3]) // null
  ```
In such a case, you can use the [null-safety](https://kotlinlang.org/docs/null-safety.html) mechanism discussed in the previous module to handle the situation:

  ```kotlin
  val readOnlyMap = mapOf<Int, String>(1 to "one", 2 to "two")
readOnlyMap[3]?.let {
      println(it) // Nothing to print because readOnlyMap[3] is null
  }

  println(readOnlyMap[3] ?: "Incorrect key") // "Incorrect key" because readOnlyMap[3] is null
  println(readOnlyMap[2] ?: "Incorrect key") // "two" because readOnlyMap[2] is not null
  ```

</div>
