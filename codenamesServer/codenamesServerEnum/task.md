#### General definition

Imagine a situation where you may have multiple states you need to handle. 
For example, in our game, we have several types of cards – the first team cards (Pink), 
the second team cards (Violet), neutral cards (Gray), and a killer card (Black). 
We can, for example, create a class for each card type or simply use a string value for the property type. 
However, this is inconvenient and can lead to many errors.
An idiomatic approach would be to use [`enum classes`](https://kotlinlang.org/docs/enum-classes.html).

#### Kotlin definition

Enum classes in Kotlin are marked with a special keyword `enum`:

```kotlin
enum class CardType
```

Then you can list all the required states in curly brackets:

```kotlin
enum class CardType {
    Pink,
    Violet,
    Gray,
    Black
}
```

And then, you can add any _properties_ (multiple ones are also allowed) for each value, such as a text representation:

```kotlin
enum class CardType(val strRepr: String) {
    Pink("pink"),
    Violet("violet"),
    Gray("gray"),
    Black("black")
}
```

#### Usage

You can use enum classes to handle, for example, different events:

```kotlin
fun addPoints(cardType: CardType) {
    when (cardType) {
        CardType.Pink -> {
            println("It is ${CardType.Pink.strRepr} card!")
            ...
        }
        CardType.Violet -> {
            println("It is ${CardType.Violet.strRepr} card!")
            ...
        }
        CardType.Gray -> {
            println("It is ${CardType.Gray.strRepr} card!")
            ...
        }
        CardType.Black -> {
            println("It is ${CardType.Black.strRepr} card!")
            ...
        }
    }
}
```

Note that since the Kotlin compiler knows _all possible_ enum values of the class, 
it can check for exhaustiveness of `when`, and thus,
you can omit the `else` branch inside `when`.
