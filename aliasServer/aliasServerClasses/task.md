
### Type aliases

A [type alias](https://kotlinlang.org/docs/type-aliases.html) allows you to define an alternative name for an existing type.
The most common use of type aliases is shortening long type names.
In this case you can use a different shorter name:

```kotlin
typealias Words = List<String>

// Next you can use <Words> in any cases, when you need to have <List<String>>:
fun foo(): Words = TODO() // must return List<String>
```


### Classes

#### General definition

During software development process, it is often impractical to implement the whole application
using only functions as building blocks.
If you are designing large complex system and use the principles of object-oriented programming
you can divide the application into several entities with each
entity responsible for its own functionality.

Consider a board game as an example.
Let's say we have a `GameCard` entity and a function to generate a list of words inside it.
Of course, we can implement a function that will return some list of words separately
and don't link to `GameCard` entity.
However, the `GameCard` entity may have some _properties_, for example, its capacity.
In this case you will need to pass all properties of a `GameCard` entity to the function manually,
and keep track of them later.
It is inconvinient and error-prone.

[//]: # (However, it might be inconvenient to work with such function. )

[//]: # (because the `GameCard` may have some _property_, for example, capacity. )

[//]: # (In this case the returning all properties from the function )

[//]: # (and passing them later can be inconvenient.)

#### Kotlin definition

**Classes** can act as such special entities like `GameCard`.
In Kotlin, you need to use the [`class`](https://kotlinlang.org/docs/classes.html) keyword to define a new class:

```kotlin
class GameCard
```

#### Properties

Next you can set up all _properties_ in the [_primary constructor_](https://kotlinlang.org/docs/classes.html#constructors),
that should store each _instance_ in this class:

```kotlin
class GameCard(val capacity: Int = 5)
```
In the example above, we specified that every card in the game has a capacity,
and the default capacity is five:

```kotlin
class GameCard(val capacity: Int = 5)

// Next we can create a new instance
fun main() {
    val card1 = GameCard() // a new card with capacity 5

    val card2 = GameCard(4) // a new card with capacity 4
}
```

In simple terms, you create a new type that you can then use in your program:

```kotlin
class GameCard(val capacity: Int = 5)

fun foo(card: GameCard): Unit = TODO("Not implemented yet")
```

<div class="hint" title="An example with several properties in the class">

In classes you can add several properties:
  ```kotlin
  class GameCard(
    val capacity: Int = 5,
    val contentType: String,
  )
  
  // Next we can create a new instance
  fun main() {
    val card1 = GameCard(contentType = "word") // a new card with capacity 5 and contentType "word"
  
    val card2 = GameCard(4, "word") // a new card with capacity 4 and contentType "word"
  }
  ```
</div>


#### Methods

In addition, each class can have a set of _methods_.
Simply put, there are functions that can be called on any _instance_ of this class.
Inside such functions, both method's arguments and all _properties_ of the class are available:

```kotlin
class GameCard(val capacity: Int = 5) {
    fun generateNewWords(language: String = "en") : List<String> {
        // You can use <language> and <capacity> here
        TODO("Not implemented yet")
    }
}
```

**TODO: for the redactor - should we reformulate <specify the name of the method after name of the entity through dot>?**

Next, you can call this method specify the name of the method after name of the entity through dot:

```kotlin
fun main() {
    val card = GameCard() // a new card with capacity 5
    val words = card.generateNewWords()
}
```

#### Access modifiers

Classes can have properties and methods, but some of them can be internal.
Then we can use special _access modifiers_ that restrict such usage.
By default, all properties and methods have the `public` access modifier, which means that they can be used from anywhere.
However, if you specify the `private` modifier, then they can only be used inside the class.
Other modifiers also exist, we will look at them later.

<div class="hint" title="Example of access modifiers">

By default, all modifiers are `public`:

```kotlin
class GameCard(val capacity: Int = 5) {
    fun generateNewWords(language: String = "en") : List<String> {
        TODO("Not implemented yet")
    }
  
    fun anotherFunction() {
        val a = capacity // OK
        val b = generateNewWords() // OK
    }
}

fun main() {
    val card = GameCard() // a new card with capacity 5
    card.capacity // OK
    card.generateNewWords() // OK
}
```

But we can change them to `private`:

```kotlin
class GameCard(private val capacity: Int = 5) {
    private fun generateNewWords(language: String = "en") : List<String> {
        TODO("Not implemented yet")
    }

    fun anotherFunction() {
        val a = capacity // OK
        val b = generateNewWords() // OK
    }
}

fun main() {
    val card = GameCard() // a new card with capacity 5
    card.capacity // ERROR
    card.generateNewWords() // ERROR
}
```

</div>

If you are designing a large or complex application,
remember to use various access modifiers such as `private`.

<div class="hint" title="Examples of usage different access modifiers">

The `private` modifier usually is used for internal functionality in the class, e.g.
if you create a helper function to avoid code duplication in the original one:

  ```kotlin
  class GameCard(val capacity: Int = 5) {
    fun generateNewWords(language: String = "en") : List<String> {
      val words: List<String> = TODO("Not implemented yet")
      return words.filter { isValidWord(it) }
    }
  
    private fun isValidWord(str: String): Boolean  = str.all { it.isLetter() }
  }
  ```

In the example above we created a private function `isValidWord` to keep only valid words for the card.
However, it is _internal_ functionality for this class and reflects the internal logic for the words' generation.
By this case we should mark it as a `private` function.
</div>