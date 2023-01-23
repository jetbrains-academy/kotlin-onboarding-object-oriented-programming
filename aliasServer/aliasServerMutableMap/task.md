### Definition

You are already familiar with [`List`](https://kotlinlang.org/docs/collections-overview.html#list) a little, which stores a list of objects of the same type,
such as `List<Int>`. The second popular collection is [`Map`](https://kotlinlang.org/docs/collections-overview.html#map).
It stores key-value pairs, such that all keys are different, but values can be the same.
`Map` is very similar to an address book, where you can find the corresponding address for each person.
Accordingly, the same address can occur several times, but each person will be in the book only once.

In Kotlin, if you want to create a _mutable_ `Map`, then you need to say so _explicitly_,
because by default, an _read-only_ collection is created,
to which it will not be possible to add new elements later.

To create a new map you can use `mapOf` for the _read-only_ collection or `mutableMapOf` for _mutable_ one:

```kotlin
val readOnlyMap = mapOf<Int, String>(1 to "one", 2 to "two")
readOnlyMap.put(3 to "three") // ERROR

val mutableMap =  mutableMapOf<Int, String>(1 to "one", 2 to "two")
mutableMap.put(3 to "three") // OK
```

#### Built-in functions

You can find a lot of useful built-in functions to work with maps in the [official Kotlin documentation](https://kotlinlang.org/docs/map-operations.html).
Let's consider several basic ones that can help you to solve this task:

<div class="hint" title="The `keys` built-in property">

If you need to get all _keys_ from a read-only or mutable map, you can use the [_keys_](https://kotlinlang.org/docs/map-operations.html#retrieve-keys-and-values) property:
  ```kotlin
  val readOnlyMap = mapOf<Int, String>(1 to "one", 2 to "two")
  for (key in readOnlyMap.keys) {
      println(key) // Will print 1 and 2
  }
  ```
</div>

<div class="hint" title="The `values` built-in property">

If you need to get all _values_ from a read-only or mutable map, you can use the [_values_](https://kotlinlang.org/docs/map-operations.html#retrieve-keys-and-values) property:
  ```kotlin
  val mutableMap = mutableMapOf<Int, String>(1 to "one", 2 to "two")
  for (value in mutableMap.values) {
      println(value) // Will print "one" and "two"
  }
  ```
</div>

<div class="hint" title="Get a value by the key">

If you need to get a value by the key, you can use the [following construction](https://kotlinlang.org/docs/map-operations.html#retrieve-keys-and-values):
  ```kotlin
  val readOnlyMap = mapOf<Int, String>(1 to "one", 2 to "two")
  println(readOnlyMap[1]) // one
  ```

But it can return `null` if the key does not exist:
  ```kotlin
  val readOnlyMap = mapOf<Int, String>(1 to "one", 2 to "two")
  println(readOnlyMap[3]) // null
  ```
In this case you can use the [null-safety](https://kotlinlang.org/docs/null-safety.html) mechanism from the previous module to handle such situations:

  ```kotlin
  val readOnlyMap = mapOf<Int, String>(1 to "one", 2 to "two")
readOnlyMap[3]?.let {
      println(it) // Nothing to print because readOnlyMap[3] is null
  }

  println(readOnlyMap[3] ?: "Incorrect key") // "Incorrect key", because readOnlyMap[3] is null
  println(readOnlyMap[2] ?: "Incorrect key") // "two", because readOnlyMap[2] is not null
  ```

</div>