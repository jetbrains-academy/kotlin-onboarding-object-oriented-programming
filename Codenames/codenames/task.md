### Theory

___

### Task

Create an object `Utils` in the `jetbrains.kotlin.course.codenames.utils` package to store the general game settings:

- add several consts into the `Utils` object to store the common constants: `N = 5`, `TOTAL_AMOUNT = N * N`, `PINK_CARDS_NUMBER = 8`, `VIOLET_CARDS_NUMBER = 9`, `GRAY_CARDS_NUMBER = 7`, `BLACK_CARDS_NUMBER = 1`. 
The `N` variable will be used only inside the `Utils` object.
- add the `init` block the `Utils` object to check the sum of `PINK_CARDS_NUMBER`, `VIOLET_CARDS_NUMBER`, `GRAY_CARDS_NUMBER`, and `BLACK_CARDS_NUMBER` is exactly `TOTAL_AMOUNT`. 
If the conditions is false, you need to throw an `IllegalArgumentException` error.

___

### Task

Create an enum class `KeyCardType` function
in the `jetbrains.kotlin.course.codenames.keyCard` package:

- the enum class `KeyCardType` must store four values: `Pink`, `Violet`, `Gray`, `Black`. 
Each value must store the `Int` `amount`, to initialize the amount you need to use the consts from the `Utils` object.

___

### Task

Create a SAM interface `KeyCardGenerator` in the `jetbrains.kotlin.course.codenames.utils` package:

- add a value class `KeyCardCell` in the `jetbrains.kotlin.course.codenames.keyCard` package with one field `type: KeyCardType`
- add a `generateData` function into the `KeyCardGenerator` interface, that accepts nothing and returns `List<KeyCardCell>`


___

### Task

Improve the `Utils` object in the `jetbrains.kotlin.course.codenames.utils` package:

- add a `previousAttempts` field with the type `MutableList<List<KeyCardCell>>` and init this field via an empty mutable list.
- add a `uniqueKeyCardGenerator` field into the `Utils` object with the type `KeyCardGenerator`, ypu need to add a `TODO` statement as a temporary implementation of the `generateData` function.

___

### Task

Implement the `generateData` function for the `uniqueKeyCardGenerator` field in the `Utils` object.
The behaviour of the `generateData` function must be the following:
1) Generate a new `List<KeyCardCell>`: put the `amount` of each `KeyCardType` into this list and shuffle it. 
2) Next, check if this combination of `List<KeyCardCell>` was not used before (it is not in the `previousAttempts`) and return this list. 
3) If the generated list was used before, repeat generation while a new list (that is not in the `previousAttempts`) will not be generated.

Add a new class `KeyCard` into the `jetbrains.kotlin.course.codenames.keyCard` package to store the key class. 
Add one immutable field into the primary constructor: `cells: List<KeyCardCell>` and init through `Utils.uniqueKeyCardGenerator.generateData()` by default.

___

### Task

The package `jetbrains.kotlin.course.codenames.keyCard` already has the regular class `KeyCardService`.
It is responsible for the game logic for the key card. In this task you need to implement the `generateKeyCard` function to make the game alive:

- implement the `generateKeyCard` function, that just returns a new instance of the `KeyCard` class

___

### Task

Let's switch to the card model. Add a new interface `CardData` into the `jetbrains.kotlin.course.codenames.card` package. 
Next, create a new class `WordCardData` in the same package to store words for this game. 
The  `WordCardData` class should inheritance the `CardData` interface and have only one immutable field: `word: String`.

___

### Task

Next we need to create a special class to store the card information. Firstly, we need to create a new enum class to store a state for the cards. 
Create an enum class `CardState` in the package `jetbrains.kotlin.course.codenames.card`. This class must store two values: `Data`, and `Back`.
Secondly, create a class `Card` in the same package with two immutable fields in the primary constructor: `data: CardData` and `state: CardState`.