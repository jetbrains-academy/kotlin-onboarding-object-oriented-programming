#### General definition

[Functional (SAM, Single Abstract Method) interfaces](https://kotlinlang.org/docs/fun-interfaces.html) 
are applicable to a situation where there is an entity type with just one method. 
Consider a board game example.
Our game has a KeyCard, which stores the playing field for the two leaders. 
But how should the KeyCard be generated? 
Should KeyCards be unique or can they be repeated? 
Can we have multiple game modes with different KeyCard generation strategies? 
All these questions lead to the following conclusion - any strategy needs its own generator, 
which can generate a KeyCard according to certain rules. 
A strategy generator is a good candidate for being declared as a SAM interface.

#### Kotlin definition

In Kotlin, SAM interfaces are defined using the `fun interface` keywords and must have exactly one function.
This function _must_ be without a definition, and it will be implemented later in a new class, which will _implement_ this SAM interface:

```kotlin
fun interface StringGenerator {
    fun generate(alphabet: List<Char>): String
}
```

Next, we can implement different generators, for example, a generator that uses only letters:

```kotlin
class OnlyLettersGenerator: StringGenerator {
    override fun generate(alphabet: List<Char>): String {
        return alphabet
            .filter { it.isLetter() }
            .shuffled()
            .take(3)
            .joinToString("")
    }
}
```

Because the initial SAM interface does not implement the `generate` function, we can not create an instance of this interface, 
but we can create a new instance of the new class that _implements_ the `StringGenerator` SAM interface:

```kotlin
fun main() {
    val baseGenerator = StringGenerator() // ERROR
    
    val onlyLettersGenerator = OnlyLettersGenerator() // OK
    println(onlyLettersGenerator.generate(listOf('a', 'b', 'c', 'd', '5'))) // some string that consists of 3 different English letters
}
```

#### Function definition

If you only need to define a class that implements the SAM interface _once_
and you don't need to refer to this class by its name in the future, you can, for example, 
save a new instance of the class into a variable or a property – then you can use just the SAM interface name 
and implement the function inside the curly brackets:

```kotlin
object Settings {
    val onlyLettersGenerator = StringGenerator {
            alphabet -> alphabet
                .filter { it.isLetter() }
                .shuffled()
                .take(3)
                .joinToString("")
    }
}
```

Next, you can use it the same way as in the previous example:
```kotlin
fun main() {
    println(Settings.onlyLettersGenerator.generate(listOf('a', 'b', 'c', 'd', '5'))) // some string that consists of 3 different English letters
}
```

