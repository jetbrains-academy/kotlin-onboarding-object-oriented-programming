#### General definition

You are already familiar with [`companion objects`]((https://kotlinlang.org/docs/object-declarations.html#companion-objects)).

Kotlin also has [`objects`](https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview).
To better understand what they are, you need to be familiar with the [Singleton](https://en.wikipedia.org/wiki/Singleton_pattern) pattern.

In simple words, `objects` allow you to create a class that will always have exactly one instance.
Consider a board game as an example.
Let's say we have game settings, such as the number of cards of a certain color or the maximum number of rounds.
In addition, settings can control the color theme used for the playing field.
In such a case, we could define a new `Settings` _class_ and create it _exactly once_, 
since there can't be several `Settings` instances in the game, as they can conflict with each other.
In this case, `object` can help because if we create an `object` instead of a `class`, 
we will be sure that there won't be any other instances of `Settings` in the game.

#### Kotlin definition

**Objects** can act as such special entities, similar to `Settings`.
In Kotlin, you need to use the [`object`](https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview) keyword to define a new object:

```kotlin
object Settings
```

#### Properties and methods

Like with classes, you can define properties or methods within objects; 
however, to use them, you don't need to create a new class instance by calling its constructor. 
This is related to the definition of objects - there can be only one instance:

```kotlin
object Settings {
    val theme: String = "light"
}

// We don't need to create a new instance to get the property
fun main() {
    println(Settings.theme) // light
}
```

With methods, the situation is the same:

```kotlin
object Settings {
    var theme: String = "light"
    
    fun changeTheme(newTheme: String) {
        theme = newTheme
    }
}

// We don't need to create a new instance to call the method
fun main() {
    println(Settings.theme) // light
    Settings.changeTheme("dark")
    println(Settings.theme) // dark
}
```

#### Usage

Otherwise, objects can be used like classes - you can use access modifiers or use an object as a type:

```kotlin
object Settings {
    private var theme: String = "light"
}

fun main() {
    println(Settings.theme) // ERROR because it is private
}
```

Or: 

```kotlin
object Settings {
    private var theme: String = "light"
    
    fun printTheme() {
        println("The game theme is $theme")
    }
}

class Game(val settings: Settings)

fun main() {
    val game = Game()
    println(game.settings.printTheme()) // The game theme is light
}
```

