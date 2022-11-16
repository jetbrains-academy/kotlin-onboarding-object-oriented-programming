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

- add a `generateData` function into the `KeyCardGenerator` interface, that accepts nothing and returns `List<KeyCardCell>`
- add a `previousAttempts` field into the `Utils` object with the type `MutableList<List<KeyCardCell>>` and init this field via an empty mutable list.
- add a `uniqueKeyCardGenerator` field into the `Utils` object with the type `KeyCardGenerator` and implement the `generateData` function:
generate a new `List<KeyCardCell>`: put the `amount` of each `KeyCardType` into this list and shuffle it. 
Next, check if this combination of `List<KeyCardCell>` was not used before (it is not in the `previousAttempts`) and return this list. 
If the generated list was used before, repeat generation while a new list (that is not in the `previousAttempts`) will not be generated.