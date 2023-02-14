#### General definition

You are already familiar with the concept of functional interfaces (SAM).
They are used if you need to add different entities that share the same functionality 
but can be implemented in different ways. In our game, we have added the `KeyCardGenerator` 
SAM interface and its implementation for a unique `KeyCardGenerator`.
Ordinary _interfaces_ are needed to describe the same entities 
but may contain more than one function and also may have properties.

Let's get back to our board game.
The game has cards with words that players need to guess. 
There are, indeed, different versions of such a game - for example, instead of words, 
there can be pictures. 
However, the logic of the game does not change depending on the type of cards,
and we would like to process cards in the same way, 
regardless of their content, for example, create a field from cards.
In such a case, we can create a common interface (type) for all types of cards and then implement 
common functions to it.

#### Kotlin definition

Kotlin uses the keyword [`interface`](https://kotlinlang.org/docs/interfaces.html) to create an interface:

```kotlin
interface CardData
```

Next, you can implement a new class that inherits (implements) this interface:

```kotlin
class WordCardData : CardData
```

You can also add new properties or methods:

```kotlin
class WordCardData(val word: String) : CardData {
    fun someFunction() {}
}
```
