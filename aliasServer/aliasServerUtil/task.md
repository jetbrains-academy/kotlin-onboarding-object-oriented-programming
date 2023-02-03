It is time for practice! 
In this task, you will create some utility entities that will help you build the whole application!

### Task

Create a type alias `Identifier`, an `IdentifierFactory` class, and a `uniqueIdentifier` function
in the `jetbrains.kotlin.course.alias.util` package:

- the type alias `Identifier` needs to be an alias for the `Int` type. If you change the type in the future, e.g., create a new class,
  it will be changed automatically in all places.
- the `IdentifierFactory` class is a class to generate unique identifiers, e.g., identifiers for different game cards or teams.
  It should have a special `counter` – an `Int` property to store the last unique number. By default, `counter` should be zero.
- the `uniqueIdentifier` function just returns a new unique identifier – increments the `counter` and returns it.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Type aliases usage">

Sometimes, type aliases are used in cases where there is no certainty that
the type used will not be replaced in the future.

For example, right now, we use the `Int` type as the `Identifier`,
but in the future, we can create our own class.
Using a type alias in this case will help us make this change as painless as possible in the future.
</div>

<div class="hint" title="Access modifiers">

The property `counter` stores some internal information about the current state of the class instance.
So, the best way is to mark it as a private property to forbid access outside the class.

A simple example of why it is bad to use a `public` modifier here is that in this
case, the user will be able to change the value of the `counter` property on their own
and we cannot guarantee its uniqueness.
</div>

<div class="hint" title="Default values">

It is better to set the value `0` as the default value for the property `counter`.
This makes it easier to create an instance of the class,
since you do not have to write the start value each time:

  ```kotlin
  val id = IdentifierFactory(0)
  ```

Compare with:

  ```kotlin
  // This way is better
  val id = IdentifierFactory()
  ```

</div>

<div class="hint" title="Short notation for functions">

Since the `uniqueIdentifier` function is so short, we can use the short notation:

  ```kotlin
  fun uniqueIdentifier(): Identifier {
      return counter++
  }
  ```

Compare with:

  ```kotlin
  // This way is better
  fun uniqueIdentifier(): Identifier = counter++
  ```

</div>
