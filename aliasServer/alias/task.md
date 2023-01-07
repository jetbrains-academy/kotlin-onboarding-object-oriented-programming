Hello! Welcome to the second module of the Kotlin course. 
This module will introduce you to the concepts of **object-oriented programming** (OOP) 
in the context of the Kotlin language.
We assume that you have completed the first part of the course 
or are familiar with the Kotlin constructions it covers.

Note that Kotlin combines several concepts, for example, 
it actively uses functional programming practices. 
Therefore, we will consider only several concepts and do not 
call for the use of Kotlin only as an OOP language.

All topics will be accompanied by links to [the official Kotlin documentation](https://kotlinlang.org/docs/home.html),
which you can read later.

Each lesson of the course is built in the form of a project:
step by step, by completing different small tasks,
you will get a finished small project in the end.
At the end of each lesson, an additional similar project will be offered:
it includes all the topics of the lesson but is not contains any theory materials.
The topic of this module is board games. 
It means, in each lesson you will create one on the popular games as a web application.
Note, part of the code will be pre-written by the course author 
to avoid deep into web programming in this course.

### Project description

The project of this lesson is **Alias**.
Probably everyone knows this party board game. 
In this game, you need to divide into teams and explain as many words from the 
cards as possible in a limited time.

### Lesson topics

- packages;
- classes, properties, and member functions;
- type aliases;
- value and data classes;
- companion objects;
- extension functions;
- some basic built-in functions to work with collections.

### Project example

**TODO**

___

### Theory

### Packages

According to [the Kotlin specification](https://kotlinlang.org/spec/packages-and-imports.html#:~:text=A%20Kotlin%20project%20is%20structured,belongs%20to%20exactly%20one%20package), 
a Kotlin project is structured into **packages**. 
A package contains one or more Kotlin files, 
with files linked to a package using a package header. 
A file may contain exactly one or zero package headers, 
meaning each file belongs to exactly one package.

In other words, packages allow you to specify the full 
address to some Kotlin objects, such as functions. 
This is similar to the full address in an apartment building - 
if you have several tenants with the same last name living in the building, 
then the full address, including the street name, house number and apartment number, 
will help you find the right one.

In code, the package is placed at the very top of the Kotlin file and starts with the [`package`](https://kotlinlang.org/docs/packages.html) keyword. 
Further, through a dot, all sub-folders leading to this file are listed.
You can then use the [`import`](https://kotlinlang.org/docs/packages.html#imports) keyword to use the required entity in another Kotlin file.

<div class="hint" title="package and import example">
  
  Consider one small example. Let's say we have two functions with the same name `foo` in two different Kotlin files - `file1.kt` and `file2.kt`.
  Next, we create a new file with the name `file3.kt` and need to call the `foo` function from the `file1.kt`.
  We can do this if the original two files `file1.kt` and `file2.kt` have different packages, and we import this function from the desired package:

  ```kotlin
    // file1.kt
    package my.project.package1
    
    fun foo(): Unit = TODO("Not implemented yet")
   ```

  ```kotlin
    // file2.kt
    package my.project.package2

    fun foo(): Unit = TODO("Not implemented yet")
  ```

  ```kotlin
    // file3.kt
    package my.project.package3
    
    import my.project.package1.foo

    fun main() {
        foo()
    }
  ```
</div>

It is important to remember that within one package there _cannot be completely identical entities_, 
for example, two identical functions with exactly the same signatures (name, arguments and return value).

### Type aliases

A [type alias](https://kotlinlang.org/docs/type-aliases.html) allows you to define an alternative name for an existing type.
The most common use of type aliases is too long type names. 
In this case you can use a different shorter name and use the new one instead:

```kotlin
typealias Words = List<String>

// Next you can use <Words> in any cases, when you need to have <List<String>>:
fun foo(): Words = TODO() // must return List<String>
```


### Classes

#### General definition

During developing software process, it is often impossible to implement the whole functionality only be separated functions. 
Of course, if we mean the principles of object-oriented, not functional programming.

Consider an example. If you are designing some kind of large and complex system, 
and in our case a board game, you can divide it into several entities and each 
entity will be able to do some things, but outside of this entity such a function is useless.

Let's say we have a `GameCard` entity and a function to generate a list of words inside it. 
Of course, we can implement a function that will return some list of words separately 
and don't link to `GameCard`, but it will be inconvenient to work with such a list, 
because the `GameCard` may have some _attributes_, for example, capacity. 
In this case the returning all attributes from the function 
and passing them later can be inconvenient.

#### Kotlin definition

**Classes** can act as such special entities like `GameCard`. 
In Kotlin, you need to use the [`class`](https://kotlinlang.org/docs/classes.html) keyword to define a new class:

```kotlin
class GameCard
```

#### Properties

Next you can set up all _attributes_ (properties) in the [_primary constructor_](https://kotlinlang.org/docs/classes.html#constructors), 
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

Next, you can just call this function:

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
remember to use various access modifiers such as `private`

___

### Task

Create a type alias `Identifier`, a `IdentifierFactory` class and a `uniqueIdentifier` function 
in the `jetbrains.kotlin.course.alias.util` package:

- type alias `Identifier` need to be the alias to the `Int` type. If you change the type in the future, e.g. create a new class, 
it will be changes automatically in all places.
- the `IdentifierFactory` class is a class to generate unique identifiers, e.g. identifiers for the different game cards ot teams. 
It should have a special `counter` - an `Int` property to store the last unique number. By default `counter` should be zero.
- the `uniqueIdentifier` function just returns a new unique identifier -- increments the `counter` and returns it.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Type aliases usage">

  Sometimes type aliases are used in cases where there is no certainty that 
  the type used will not be replaced in the future. 

  For example, right now we use the `Int` type as the `Identifier`, 
  but in the future we can create our own class, for example. 
  Using a type alias in this case will help make this change as painless as possible in the future.
</div>

<div class="hint" title="Access modifiers">
  
  The property `counter` stores some internal information about the current state of the class instance.
  So, the best way to mark it as a private property to forbid access outside the class.

  A simple example of why it is bad to use the `public` modifier here is that in this 
  case the user will be able to change the value of the `counter` property on his own, 
  and we cannot guarantee its uniqueness.
</div>

<div class="hint" title="Default values">

  It is better to set the value `0` as the default valur for the property `counter`.
  This makes it easier to create an instance of this class, 
  since you can not write a start value each time:

  ```kotlin
  val id = IdentifierFactory(0)
  ```
  
  **vs**

  ```kotlin
  // This way is better
  val id = IdentifierFactory()
  ```

</div>

<div class="hint" title="Short notation for functions">

  Since the `uniqueIdentifier` function is too short, we can use the short notation for this:

  ```kotlin
  fun uniqueIdentifier(): Identifier {
      return counter++
  }
  ```

  **vs.**

  ```kotlin
  // This way is better
  fun uniqueIdentifier(): Identifier = counter++
  ```

</div>


___

### Theory

### Data classes

#### Definition

It is not unusual to create classes whose main purpose is to hold data. 
In such classes, some standard functionality and some utility functions 
are often mechanically derivable from the data, for example, 
how the string representation of an instance of this class will look like. 
In Kotlin, these are called data classes and are marked with the [`data`](https://kotlinlang.org/docs/data-classes.html) keyword:
Such classes must have at least one property:

```kotlin
data class GameCard() // ERROR
```

```kotlin
data class GameCard(private val capacity: Int = 5) // OK
```

As mentioned above, data classes have several implemented functions. 
Consider the example of the `toString` function, 
which allows you to get a string representation of a class instance:

```kotlin
class GameCard(private val capacity: Int = 5) // OK

fun main() {
    println(GameCard()) // package.GameCard@6d03e736
}
```

**vs.**

```kotlin
data class GameCard(private val capacity: Int = 5) // OK

fun main() {
  println(GameCard()) // GameCard(capacity=5)
}
```

The full list of redefined functions can be found in the [official documentation](https://kotlinlang.org/docs/data-classes.html), 
we will gradually become familiar with them during this module.

#### Properties outside the constructor

In a data classed (as in regular classes), you can define properties not only inside the primary constructor, 
but also outside it. 
In this case, the user does not need to pass a value for this property directly:

```kotlin
data class GameCard(
    private val id: Int, 
    private val capacity: Int = 5
) {
    val name: String = "Card#${id + 1}"
}

fun main() {
    val card = GameCard(3)
    println(card.name) // Card#4
}
```

However, properties defined outside the constructor **do not participate** in **all** automatically implemented functions of the date class:

```kotlin
data class GameCard(
    private val id: Int, 
    private val capacity: Int = 5
) {
    val name: String = "Card#${id + 1}"
}

fun main() {
    val card = GameCard(3)
    println(card) // GameCard(id=3, capacity=5)
}
```

but

```kotlin
data class GameCard(
    private val id: Int,
    private val capacity: Int = 5,
    val name: String = "Card#${id + 1}"
)

fun main() {
    val card = GameCard(3)
    print(card) // GameCard(id=3, capacity=5, name=Card#4)
}
```

___

### Task

Create a data class `Team` in the `jetbrains.kotlin.course.alias.team` package to store the information about teams:
- it must have two properties in the primary constructor: `id` with `Identifier` type to identify each team and `points` with `Int` type 
to store the number of points in the game. For `points` set the default value `0`.
- is must have an additional property `name`, that initializes automatically as `"Team#${id + 1}"` and will be shown in the leaderboard.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Import Identifier">

  To use `Identifier` you need to import it in the top on the file with the `Team` class:

  ```kotlin
  package jetbrains.kotlin.course.alias.team

  import jetbrains.kotlin.course.alias.util.Identifier
  ```
</div>


<div class="hint" title="Why do we use the data class?">

  Class `Team` is responsible to store some information about teams in the game. 
  It is convenient to use data classes in all cases, 
  when we need just store something and have automatically implemented methods like `toString` method.
</div>

<div class="hint" title="Why are we using name outside of the constructor?">
  In this game, the team is determined only by its `id` (as well as the number of points), 
  and we need a `name` only for a pretty display on the screen. 
  This is the main reason why we don't need `name` to be used in automatically defined functions like `toString` function.
</div>


----

### Theory

### Companion objects

#### Definition

Classes can contain variables or functions that are specific to 
that class, but do not require the use of a concrete instance state of this class, 
but rather can be applied generally.

For example, we have a `GameCard` class and would like to store the maximum number 
of cards that can be generated. Such a variable can be placed in a [`companion object`](https://kotlinlang.org/docs/object-declarations.html#companion-objects) within that class 
and then accessed _directly_ via the class name:

```kotlin
class GameCard(private val capacity: Int = 5) {
    companion object {
        val maxNumberOfCards = 10
    }
}

fun main() {
    println(GameCard.maxNumberOfCards) // 10
    println(GameCard().maxNumberOfCards) // ERROR
}
```

#### Access modifiers

If you use the `private` access modifier **inside** the companion object, 
it will be available **inside** the external class, but **not outside**:

```kotlin
class GameCard(private val capacity: Int = 5) {
    companion object {
        private val maxNumberOfCards = 10
    }
    
    fun foo() {
        println(maxNumberOfCards) // OK
    }
}

fun main() {
    println(GameCard.maxNumberOfCards) // ERROR
}
```

### Mutable map

#### Definition

You are already familiar with [`List`](https://kotlinlang.org/docs/collections-overview.html#list) a little, which stores a list of objects of the same type, 
such as `List<Int>`. The second popular collection is [`Map`](https://kotlinlang.org/docs/collections-overview.html#map). 
It stores key and values, where all keys are different, but values can be the same.
`Map` is very similar to an address book, where you can find the corresponding address for each person. 
Accordingly, the same address can occur several times, but each person will be in the book only once.

In Kotlin, if you want to create a _mutable_ `Map`, then you need to say so _explicitly_, 
because by default, an _immutable_ collection is created, 
to which it will not be possible to add new elements later.

To create a new map you can use `mapOf` for the _immutable_ collection or `mutableMapOf` for _mutable_ one:

```kotlin
val immutableMap = mapOf<Int, String>(1 to "one", 2 to "two")
immutableMap.put(3 to "three") // ERROR

val mutableMap =  mutableMapOf<Int, String>(1 to "one", 2 to "two")
mutableMap.put(3 to "three") // OK
```

#### Built-in functions

You can find a lot of useful built-in functions to work with maps in the [official Kotlin documentation](https://kotlinlang.org/docs/map-operations.html).
Let's consider several basic ones that can help you to solve this task:

<div class="hint" title="The `keys` built-in property">
  
  If you need to get all _keys_ from an immutable or mutable map, you can use the [_keys_](https://kotlinlang.org/docs/map-operations.html#retrieve-keys-and-values) property:
  ```kotlin
  val immutableMap = mapOf<Int, String>(1 to "one", 2 to "two")
  for (key in immutableMap.keys) {
      println(key) // Will print 1 and 2
  }
  ```
</div>

<div class="hint" title="The `values` built-in property">

If you need to get all _values_ from an immutable or mutable map, you can use the [_values_](https://kotlinlang.org/docs/map-operations.html#retrieve-keys-and-values) property:
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
  val immutableMap = mapOf<Int, String>(1 to "one", 2 to "two")
  println(immutableMap[1]) // one
  ```
  
  But it can return `null` if the key is not exist:
  ```kotlin
  val immutableMap = mapOf<Int, String>(1 to "one", 2 to "two")
  println(immutableMap[3]) // null
  ```
  In this case you can use the [null-safety](https://kotlinlang.org/docs/null-safety.html) mechanism from the previous module to handle such situations:

  ```kotlin
  val immutableMap = mapOf<Int, String>(1 to "one", 2 to "two")
  immutableMap[3]?.let {
      println(it) // Nothing to print because immutableMap[3] is null
  }

  println(immutableMap[3] ?: "Incorrect key") // "Incorrect key", because immutableMap[3] is null
  println(immutableMap[2] ?: "Incorrect key") // "two", because immutableMap[2] is not null
  ```

</div>

----

### Task

The package `jetbrains.kotlin.course.alias.team` already has the regular class `TeamService`. 
It is responsible for the game logic for the teams. In this task you need to implement several things to make the game alive:

- add a property `identifierFactory` with the type `IdentifierFactory` to generate identifiers for each team. 
Don't forget to add the default value for it (just create a new instance of the `IdentifierFactory` class).
- add a companion object into the `TeamService` class and declare the `teamsStorage` variable to store all previous teams. 
The type of the storage should be the `MutableMap` of `Identifier` to `Team`. Don't forget to init it via an empty map.
- implement the `generateTeamsForOneRound` method.
The method must generate the teams list and also store all of them into the `teamsStorage` map. 
We need it to save the games results for the leaderboard.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Import Identifier">

To use `Identifier` and `IdentifierFactory` you need to import it in the top on the file with the `TeamService` class:

  ```kotlin
  package jetbrains.kotlin.course.alias.team

  import jetbrains.kotlin.course.alias.util.Identifier
  import jetbrains.kotlin.course.alias.util.IdentifierFactory
  ```
</div>

<div class="hint" title="Create IdentifierFactory class">
  
  Since `IdentifierFactory` class has the default value for the `counter` property, 
  you don't need to set up it in the constructor:
  
  ```kotlin
  val identifierFactory = IdentifierFactory() // CORRECT
  ```
</div>

<div class="hint" title="List with teams generation">

  As was mentioned in the first module, you can generate a new list with `N` elements by the following construction:
  ```kotlin
  List(N) { Team(...) }
  ```
</div>

<div class="hint" title="putIfAbsent built-in function">

  If you work with a `map`, you can use `putIfAbsent` built-in function to put a new value if it absent in the `map`:
  ```kotlin
  val myMap = mutableMapOf<Int, String>()
  if (1 !in myMap.keys) {
      myMap[1] = "one"
  }
  ```
  is the same with:
  ```kotlin
  val myMap = mutableMapOf<Int, String>()
  myMap.putIfAbsent(1, "one")
  ```
</div>

<div class="hint" title="forEach built-in function">
  
  If you need to handle each element in a collection, for example in a list or in a map, 
  you can use the `forEach` built-in function instead of the `for` loop.
  In this case you need to write the action inside curly brackets:
  ```kotlin
  val teams = List(N) { Team(...) }
  for (team in teams) {
    teamsStorage.putIfAbsent(it.id, it)
  }
  ```
  is the same with:
  ```kotlin
  val teams = List(N) { Team(...) }
  teams.forEach { teamsStorage.putIfAbsent(it.id, it) }
  ```
</div>
___

### Theory

### Annotations

[Annotations](https://kotlinlang.org/docs/annotations.html) are means of attaching metadata to code.
They usually start with `@` in code. 
We will **not focus** on developing our own annotations in this module, 
but we will analyze the most common ones when developing on Kotlin.

An example of a popular annotation is the `Deprecated` annotation, that marks classes or functions as deprecated and informs the user about it:

```kotlin
@Deprecated("This class will be deprecated in the future release") // <-- annotation
class GameCard(private val capacity: Int = 5)
```

### Value classes

[Value or inline classes](https://kotlinlang.org/docs/inline-classes.html) are special classes to wrap only one property.
They are needed for some optimizations while the program is running, you can read about it in the [official documentation](https://kotlinlang.org/docs/inline-classes.html).
All value classes must be marked the `JvmInline` annotation.

```kotlin
@JvmInline
value class Word(val word: String)

fun main() {
    val w = Word("cat")
    println(w.word) // cat
}
```

Do not confuse inline classes with type aliases.
Type aliases _only refer_ to an already existing type, 
while inline classes create a _new_ one for convenient use in your program without performance degradation.

----

### Task

Create two classes to work with the cards in the `jetbrains.kotlin.course.alias.card` package:
- a value class `Word` with one `String` `word` property to store a word;
- a data class `Card` to store information for each card. 
Each card must store `id` with the `Identifier` type, and a list of `words` (`List<Word>`). 
These properties don't have default values and also must be defined in the primary constructor.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Import Identifier">

To use `Identifier` you need to import it in the top on the file with the `Word` and `Card`  classes:

  ```kotlin
  package jetbrains.kotlin.course.alias.card

  import jetbrains.kotlin.course.alias.util.Identifier
  ```
</div>

<div class="hint" title="Why do we use the value class?">

  Of course, we can just use the `String` type or create a type alias for the `String` type. 
  All of these options will undoubtedly be true in our case. 
  However, the _purpose_ of this course is to show you the power of Kotlin so that you can 
  choose the one you like best in the future.
</div>

___

### Theory

### Const variables 

To help the Kotlin compiler to optimize your code you can use the `const` modifier for the variables, that are unchanged always - the [compile-time constants](https://kotlinlang.org/docs/properties.html#compile-time-constants).
Constants can only have basic (primitive) types such as `String`, `Int`, and so on. 
Also, they cannot be initialized by calling functions or anything like that. 
Last but not least, you must only use constants inside `companion objects` (or just inside `objects`, which we will talk about later):

```kotlin
class GameCard(private val capacity: Int = 5) {
  companion object {
    private const val MAX_NUMBER_OF_CARDS_OK = 10 // OK
    private const val MAX_NUMBER_OF_CARDS_NOT_OK = foo() // ERROR

    private fun foo() = 10
  }
}
```

As you can see from the example, Kotlin has adopted a special style code for naming compile-time constants - all letters must be capitalized, words in the name are separated by underscore.

### Extension functions

#### Definition

In Kotlin you can add new member function to the existing classes. This is done via special declarations called [extensions](https://kotlinlang.org/docs/extensions.html).
This is useful if, for example, you don't have access to the original class, but would like to add a new function. 
Consider an example - lets we need to count the amount of letters in a string, we can make it by the following way:

```kotlin
fun getAmountOfLetter(s: String, letter: Char) = s.count { it == letter }

fun main() {
  println(getAmountOfLetter("photothermoelasticity", 'o')) // 3
}
```

However, we can also create an _extension function_ so as not to pass a string as a function argument:
```kotlin
fun String.getAmountOfLetter(letter: Char) = this.count { it == letter }

fun main() {
  println("photothermoelasticity".getAmountOfLetter('o')) // 3
}
```

In this case, we have added a new function to the `String` class. 
The main difference in implementation is 1) we use `this` instead of the passed a string parameter 2) we don't need to pass the string as an argument and we 
can call the function directly on the `String` type.

#### Access

It's important to note that this functionality only works for functions that _don't already exist in the original class_. 
If you define a new function that is already defined in the class, then the original implementation will be called:

```kotlin
fun String.isEmpty() = true

fun main() {
    println("photothermoelasticity".isEmpty()) // false, because the original isEmpty function was called
}
```

Also, if you define a new extension function _inside_ a class, it will not be available outside of it:

```kotlin
class Example {
    fun String.getAmountOfLetter(letter: Char) = this.count { it == letter }
    
    fun foo(string: String) {
        string.getAmountOfLetter('a') // OK
    }
}

fun main() {
    println("photothermoelasticity".getAmountOfLetter()) // ERROR
}
```

___

### Task

It's time to revive the cards. The package `jetbrains.kotlin.course.alias.card` already has the regular class `CardService`.
You just need to add several properties and implement several methods:

- add a property `identifierFactory` with the type `IdentifierFactory` to generate identifiers for each card.
Don't forget to add the default value for it (just create a new instance of the `IdentifierFactory` class).
- add a property `cards` that stores a list of cards (`List<Card>`), you should initialize it by the calling
  the `generateCards` method.
- add a companion object into the `CardService` class and declare the `WORDS_IN_CARD` const variable to store the number
  of words for the cards.
  You need to assign the value `4` for it. Also declare `cardsAmount` here, that stores the possible number of
  cards: `words.size / WORDS_IN_CARD`.
  The project contains the predefined list of words `words`.
- add the `toWords` function into the `CardService` class, that is an extension function for `List<String>`
  and converts each element from this list into `Word`.
- implement the `generateCards` function that shuffles the `words` list, chunks into chunks with `WORDS_IN_CARD` words
  each,
  takes `cardsAmount` chunks for `cardsAmount` cards, and finally creates a new `Card` for each chunk.
- implement the `getCardByIndex` method that accepts `index` (an integer number) and the `Card` at this index.
  If the card does not exist, throw an error.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="The `shuffled` built-in function">

  Sometimes you need to randomly shuffle the contents of a list, for example,
  to change the order of the words in the original list.
  To do this, you can generate different word positions from the original list and build a new one,
  or use the built-in function [`shuffled`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/shuffled.html):

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.shuffled()) // 1, 2, 3, 4, 5, 6 in the different random order
  ```
</div>

<div class="hint" title="The `chunked` built-in function">

  Sometimes you need to split a list into `N` sublists of the same length,
  for example when you want a large list of words into sublists for each game card.
  To do this, you can manually iterate every `N` elements and create a new sublist,
  but you can use the built-in function [`chunked`](https://kotlinlang.org/docs/collection-parts.html#chunked):

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.chunked(2)) // [[1, 2], [3, 4], [5, 6]]
  ```
</div>

<div class="hint" title="The `take` built-in function">

  Sometimes you need to take the first `N` elements from a list, 
  for this you can loop up to the `N` element and make a new list, 
  or use the built-in function [`take`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/take.html).

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.take(4)) // [1, 2, 3, 4]
  ```
</div>

<div class="hint" title="Chaining multiple function calls">

  In Kotlin you don't need to create a new variable for each call of functions 
  if you work with collections, e.g. with a list. 
  You can call them sequentially, thus creating a chain of calls:

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  val chunkedList = numbers.chunked(2)
  println(chunkedList.take(2)) // [[1, 2], [3, 4]]
  ```

  is the **same** with

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.chunked(2).take(2)) // [[1, 2], [3, 4]]
  ```
</div>

<div class="hint" title="The `map` and `forEach` built-in functions">

  If you need to handle each element in a collection, for example in a list or in a map,
  you can use the `forEach` or `map` built-in functions instead of the `for` loop.
  In this case you need to write the action inside curly brackets.

  The main difference between `forEach` or `map` is the return value. 
  If you use the `map` function, you **will get** a new collection, e.g. a list with transformed values and can continue the sequence of the calls.
  If you use the `forEach` function, you **will not get** a new collection:

  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  for (number in numbers) {
    println(number)
  }
  ```
  is the **same** with:
  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  numbers.forEach { println(it) }
  ```

  But if you use the `map` function, behaviour will be different:
  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  val squared = numbers.map { 
    println(it) 
    it * it
  } // [1, 4, 9, 16, 25, 36]
  ```

  In the last case the initial list `[1, 2, 3, 4]` will be printed, and next each nu,ber in this list will be squared.
  The result of the last action in the curly brackets will be in the final list.

  You also can combine map with other function:
  ```kotlin
  val numbers = listOf(1, 2, 3, 4, 5, 6)
  println(numbers.take(3).map { it * it }) // [1, 4, 9]
  ```
</div>

<div class="hint" title="The `getOrNull` built-in function">

  If you try to get an element from a list be the index and this index does not exit, you will get an error. 
  To avoid this, you can use the built-in function [`getOrNull`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/get-or-null.html) that returns the value or `null` if the index does not exist:

  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  println(numbers[10]) // Throws the index of bounds error

  println(numbers.getOrNull(10) ?: error("You use incorrect index 10 for the list")) // Is better because the error will inform the user about the error in detail
  ```
</div>
___

### Theory

### Mutable list

You already familiar with the `List` and with the `Map`.
Just like the `Map`, a `List` can be _mutable_ or _immutable_ and it must be reported directly.

In Kotlin, if you want to create a _mutable_ `List`, then you need to say so _explicitly_,
because by default, an _immutable_ collection is created,
to which it will not be possible to add new elements later.

To create a new list you can use `listOf` for the _immutable_ collection or `mutableListOf` for _mutable_ one:

```kotlin
val immutableList = listOf<Int>(1, 2, 3)
immutableList.add(4) // ERROR

val mutableList =  mutableListOf<Int>(1, 2, 3)
mutableList.add(4) // OK
```

### Checking some conditions

When developing applications, some invariants can often be true for values.
For example, if we are working with game cards and we know the maximum number of the cards, 
the list of cards can not have cards more than the maximum value.

To handle these case you can use the [`require`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html) built-in function, that throws an IllegalArgumentException if the value is false:

```kotlin
class GameCard(private val capacity: Int = 5) {
    companion object {
        const val MAX_NUMBER_OF_CARDS = 10 // OK
    }
}

fun foo(cards: List<GameCard>) {
    require(cards.size <= GameCard.MAX_NUMBER_OF_CARDS) { "The maximum number of cards is ${GameCard.MAX_NUMBER_OF_CARDS}" }
}
```
___

### Task

Congratulations! Your game is almost ready, it remains only to add the display of the leaderboard at the end of the game
and the for the previous rounds.
In this task implement several things in the already defined class `GameResultsService` in
the `jetbrains.kotlin.course.alias.results` package:

- add a type alias `GameResult` to `List<Team>` into `jetbrains.kotlin.course.alias.results` package;
- add a companion object into the `GameResultsService`
  and declare the `gameHistory` variable to store the list of game results (`MutableList<GameResult>`).
  By default, it must be initialized via an empty list.
- implement the `saveGameResults` method that adds the `result` into the `gameHistory`.
  Before adding the `result` you need to check two requirements and throw an error if they are broken: 1) `result` must
  be not empty; 2) all teams ids from the `result` must be in the `TeamService.teamsStorage`.
- implement the `getAllGameResults` method that returns the reversed `gameHistory` list. 

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="The `isNotEmpty` built-in function">

  If you need to check if a list is not empty you can check its size ot use the [isNotEmpty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/is-not-empty.html) built-in function:

  ```kotlin
  val numbers = listOf(1, 2, 3)
  if (numbers.size != 0) {
      TODO()
  }
  ```
  is the **same** with

  ```kotlin
  val numbers = listOf(1, 2, 3)
  if (numbers.isNotEmpty()) {
      TODO()
  }
  ```
</div>

<div class="hint" title="`contains` and `in`">

  In Kotlin you can use [operators](https://kotlinlang.org/docs/java-interop.html#operators) insted several functions to make code shorter.
  For example, instead of the `contains` function, you can use the `in` operator to check if the collection contains some element:

  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  println(numbers.contains(1)) // true
  ```
  is the **same** with
  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  println(1 in numbers) // true
  ```
</div>


<div class="hint" title="The `all` built-in function">

  If you need verification that if **all** elements match the given predicate, you can use the [`all`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/all.html) built-in function.
  The predicate you need to put into the curly brackets:

  ```kotlin
  val evenNumbers = listOf(2, 4, 6)
  println(evenNumbers.all { it % 2 == 0 }) // true
  println(evenNumbers.all { it == 4 }) // false, because only one item satisfies the predicate
  ```
</div>

<div class="hint" title="The `reversed` built-in function">

  If you need to get a list in which the elements are in reverse order, 
  you can loop through the elements of the original list from the end to the beginning and 
  return a new list, or use the [`reversed`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/reversed.html) built-in function:

  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  val reversedList = mutableListOf<Int>()
  for (i in numbers.size - 1 downTo 0) {
    reversedList.add(numbers[i])
  }
  println(reversedList) // [4, 3, 2, 1]
  ```

  is the **same** with 
  ```kotlin
  val numbers = listOf(1, 2, 3, 4)
  val reversedList = numbers.reversed()
  println(reversedList) // [4, 3, 2, 1]
  ```
</div>
