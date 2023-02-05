#### General definition

[Functional (SAM) interfaces](https://kotlinlang.org/docs/fun-interfaces.html) are needed if you have any entity type with just one function. 
Consider an example in a board game.
Our game has a KeyCard, which stores the playing field for the two leaders. 
But how should the KeyCard be generated? 
Should KeyCards be unique or can they be repeated? 
Can we have multiple game modes with different KeyCard generation strategies? 
All these questions are united by the following conclusion - any strategy needs its own generator, 
which can generate a KeyCard according to certain rules. 
This describes the definition of a SAM interface well.

#### Kotlin definition

In Kotlin SAM interfaces are defined using the `fun interface` keywords and must have exactly one function.
This function _must_ be without definition and will be implemented later in a new class, which will _implement_ this SAM interface:

```kotlin
fun interface StringGenerator {
    fun generate(alphabet: List<Char>): String
}
```

Next, we can implement different generators, for example a generator, that uses only letters:

```kotlin
class OnlyLettersGenerator: StringGenerator {
    override fun generate(alphabet: List<Char>): String {
        return alphabet.filter { it.isLetter() }.shuffled().take(3).joinToString("")
    }
}
```

Because the initial SAM interface does not implement the `generate` function, we can not create an instance of this interface, 
but we can create a new instance of the new class, that _implements_ the `StringGenerator` SAM interface:

```kotlin
fun main() {
    val baseGenerator = StringGenerator() // ERROR
    
    val onlyLettersGenerator = OnlyLettersGenerator() // OK
    println(onlyLettersGenerator.generate(listOf('a', 'b', 'c', 'd', '5'))) // some string that consists of 3 different english letters
}
```

#### Function definition

If you only need to define a class that implements the SAM interface _once_,
and you don't need to call this class by the name in the future, for example,  
save a new class into a variable ot a property, then you can use just the SAM interface name 
and next to implement the function inside the curly brackets:

```kotlin
object Settings {
    val onlyLettersGenerator = StringGenerator {
            alphabet -> alphabet.filter { it.isLetter() }.shuffled().take(3).joinToString("")
    }
}
```

and next use like in the previous example:
```kotlin
fun main() {
    println(Settings.onlyLettersGenerator.generate(listOf('a', 'b', 'c', 'd', '5'))) // some string that consists of 3 different english letters
}
```

