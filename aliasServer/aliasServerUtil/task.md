It is time for practice! 
In this task, you will create some utility entities that will help you build the whole application!

### Task

Create a type alias `Identifier`, an `IdentifierFactory` class, and a `uniqueIdentifier` function
in the `jetbrains.kotlin.course.alias.util` package:

- The type alias `Identifier` needs to be an alias for the `Int` type. If you change the type in the future, e.g., create a new class,
  it will be changed automatically in all places.
- The `IdentifierFactory` class is a class to generate unique identifiers, e.g., identifiers for different game cards or teams.
  It should have a special `counter` – an `Identifier` property to store the last unique number. By default, `counter` should be zero.
- The `uniqueIdentifier` function just returns a new unique identifier – increments the `counter` and returns it.

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Click me to learn about the usage of type aliases">

Sometimes, type aliases are used in cases where there is uncertainty that
the type being used will not be replaced in the future.

For example, right now, we're using the `Int` type as the `Identifier`.
However, in the future, we may create our own class.
Using a type alias in this case can help us make such a change as seamless as possible in the future.
</div>

<div class="hint" title="Click me to learn more about access modifiers">

The `counter` property stores internal information about the current state of the class instance.
So, it's best to mark it as a private property to prevent access outside the class.

A simple example of why it is bad to use a `public` modifier here is that, in such a
case, the user could independently change the value of the `counter` property, 
compromising its uniqueness.
</div>

<div class="hint" title="Click me to learn about default values">

It is better to set `0` as the default value for the `counter` property.
This makes it easier to create an instance of the class,
since you won't need to specify the starting value each time:

  ```kotlin
  val id = IdentifierFactory(0)
  ```

Compare with:

  ```kotlin
  // This way is better
  val id = IdentifierFactory()
  ```

</div>

<div class="hint" title="Click me to learn about the short notation used for functions">

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
