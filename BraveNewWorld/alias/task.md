### Theory

___

### Task

Create a type alias `Identifier`, a `IdentifierFactory` class and a `uniqueIdentifier` function 
in the `jetbrains.kotlin.course.alias.util` package:

- type alias `Identifier` need to be the alias to the `Int` type. If you change the type in the future, e.g. create a new class, 
it will be changes automatically in all places.
- the `IdentifierFactory` class is a class to generate unique identifiers, e.g. identifiers for the different game cards ot teams. 
It should have a special `counter` - an `Int` field to store the last unique number. By default `counter` should be zero.
- the `uniqueIdentifier` function just returns a new unique identifier -- increments the `counter` and returns it.

___

### Task

Create a data class `Team` in the `jetbrains.kotlin.course.alias.team` package to store the information about teams:
- it must have two fields in the primary constructor: `id` with `Identifier` type to identify each team and `points` with `Int` type 
to store the number of points in the game. For `points` set the default value `0`.
- is must have an additional field `name`, that initializes automatically as `"Team#${id + 1}"` and will be shown in the leaderboard.

___

### Task

The package `jetbrains.kotlin.course.alias.team` already contains the regular class `TeamService`. 
It is responsible for the game logic for the teams. In this task you need to implement several things to make the game alive:

- add a field `identifierFactory` with the type `IdentifierFactory` to generate identifiers for each team. 
Don't forget to add the default value for it (just create a new instance of the `IdentifierFactory` class).
- add a companion object into the `TeamService` class and declare the `teamsStorage` variable to store all previous teams. 
The type of the storage should be the `MutableMap` of `Identifier` to `Team`. Don't forget to init it via an empty map.
- implement the `generateTeamsForOneRound` method.
The method must generate the teams list and also store all of them into the `teamsStorage` map. 
We need it to save the games results for the leaderboard.

___

### Task

Create two classes to work with the cards in the `jetbrains.kotlin.course.alias.card` package:
- a value class `Word` with one `String` `word` field to store a word;
- a data class `Card` to store information for each card. 
Each card must store `id` with the `Identifier` type, and a list of `words` (`List<Word>`). 
These fields don't have default values and also must be defined in the primary constructor.