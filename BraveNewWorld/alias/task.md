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
