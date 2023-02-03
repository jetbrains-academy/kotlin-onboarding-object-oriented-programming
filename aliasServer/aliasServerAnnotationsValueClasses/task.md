### Annotations

[Annotations](https://kotlinlang.org/docs/annotations.html) are means of attaching metadata to code.
They usually start with `@` in code.
We will **not focus** on developing our own annotations in this module,
but we will analyze the most common ones used in Kotlin programming.

An example of a popular annotation is the `Deprecated` annotation, which marks classes or functions as deprecated and informs the user about it:

```kotlin
@Deprecated("This class will be deprecated in the future release") // <-- annotation
class GameCard(private val capacity: Int = 5)
```

### Value classes

[Value or inline classes](https://kotlinlang.org/docs/inline-classes.html) are special classes that wrap only one property.
They are needed for some optimizations while the program is running; you can read about it in the [official documentation](https://kotlinlang.org/docs/inline-classes.html).
All value classes must be marked with the `JvmInline` annotation.

```kotlin
@JvmInline
value class Word(val word: String)

fun main() {
    val w = Word("cat")
    println(w.word) // cat
}
```

Do not confuse value classes with type aliases.
The crucial difference is that type aliases are _assignment-compatible_ with their
underlying type (and with other type aliases with the same underlying type), while value classes are not.
In other words, value classes introduce a truly new type, contrary to type aliases, which only introduce an alternative name (alias) for an existing type:

```kotlin
typealias Word = String

fun generateWord(): Word { 
    return "cat" // OK
}
```

**vs.**

```kotlin
@JvmInline
value class Word(val w: String)

fun generateWord(): Word {
  return "cat" // ERROR, only Word("cat") is correct
}
```
