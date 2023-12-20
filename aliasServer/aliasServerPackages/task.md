### Packages

According to [the Kotlin specification](https://kotlinlang.org/spec/packages-and-imports.html#:~:text=A%20Kotlin%20project%20is%20structured,belongs%20to%20exactly%20one%20package),
a Kotlin project is structured into **packages**.
A package contains one or more Kotlin files,
with files linked to a package using a package header.
A file may contain exactly one or zero package headers,
which means that each file belongs to exactly one package.

In other words, packages allow you to specify the full
address to some Kotlin objects, such as functions.
This is similar to the full address in an apartment building –
if you have several tenants with the same last name living in the building,
then the full address including the street name, house number, and apartment number
will help you find the right person.

In code, the package is placed at the very top of the Kotlin file and starts with the [`package`](https://kotlinlang.org/docs/packages.html) keyword.
Further, separated by a dot, all sub-folders leading to this file are listed.
With the [`import`](https://kotlinlang.org/docs/packages.html#imports) keyword, you can use the required entity in another Kotlin file.

<div class="hint" title="Click me to see package and import examples">

Consider one small example. Let's say we have two functions with the same name `foo` in two different Kotlin files – `file1.kt` and `file2.kt`.
Next, we create a new file with the name `file3.kt`, and in it, we need to call the `foo` function from `file1.kt`.
If the two original files `file1.kt` and `file2.kt` belong to different packages, we import this function from the desired package:

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

It is important to remember that within one package, there _cannot be completely identical entities_ –
for example, two identical functions with exactly the same signatures (name, arguments, and return value).
