[![official project](https://jb.gg/badges/official.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub)
[![Gradle Build](https://github.com/jetbrains-academy/kotlin-onboarding-part2/actions/workflows/gradle-build.yml/badge.svg)](https://github.com/jetbrains-academy/kotlin-onboarding-part2/actions/workflows/gradle-build.yml)
[![Gradle Build With Detekt](https://github.com/jetbrains-academy/kotlin-onboarding-part2/actions/workflows/gradle-build-with-detekt.yml/badge.svg)](https://github.com/jetbrains-academy/kotlin-onboarding-part2/actions/workflows/gradle-build-with-detekt.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# Kotlin Onboarding: Object-oriented programming

**TODO**

## Technical requirements

Before starting this course, check the following requirements.

1. Your computer needs to have a stable internet connection.
2. Git version control system needs to be installed on your computer (link to the git site: https://git-scm.com/).
3. Make sure that the path to the root folder of the course does not contain spaces, special characters, or non-latin characters.
4. Make sure that you use the [EduTools](https://plugins.jetbrains.com/plugin/10081-edutools) plugin with version at least `2023.1`.
5. **TODO: google chrome**

The course is integrated into the [Intellij Idea IDE](https://www.jetbrains.com/idea/), which has a community free license. 
You may use this license to complete the course. 
If you have some troubles with the course installation, fell free to contact us by email education@jetbrains.com.


## Getting started

**TODO: add course link**
This course is available on JetBrains Marketplace and can be installed from the 
[IntelliJ IDEA](https://www.jetbrains.com/idea/) IDE directly, but you can also use this course in 
the course creator mode or create a course archive from the source code.

### Getting started: create a course preview from the source code

You can create a [course preview](https://plugins.jetbrains.com/plugin/10081-edutools/docs/educator-start-guide.html#preview_course) from the source code:
1. Clone this repository: 
```text
git clone https://github.com/jetbrains-academy/kotlin-onboarding-part2.git
```

2. Install [npm](https://www.npmjs.com/) and [yarn](https://yarnpkg.com/) to your laptop

TODO: absolute paths to models

3. Run yarn install in each module woth frontend

4. Build the project:
```text
./gradlew build
```

3. Install the [EduTools](https://plugins.jetbrains.com/plugin/10081-edutools/docs/educational-products.html) plugin from JetBrains Marketplace.

4. Create a new [course preview](https://plugins.jetbrains.com/plugin/10081-edutools/docs/educator-start-guide.html#preview_course).

### Getting started: create a course archive

You can create a [course archive](https://plugins.jetbrains.com/plugin/10081-edutools/docs/educator-start-guide.html#fe7010f2) from the source code:
1. Clone this repository:
```text
git clone https://github.com/jetbrains-academy/kotlin-onboarding-part2.git
```

2. Build the project:
```text
./gradlew build
```

3. Install the [EduTools](https://plugins.jetbrains.com/plugin/10081-edutools/docs/educational-products.html) plugin from JetBrains Marketplace.

4. Create a new [course archive](https://plugins.jetbrains.com/plugin/10081-edutools/docs/educator-start-guide.html#fe7010f2).

## Run tests

To run tests locally, you just need to build the project and run the following command:

```text
./gradlew test
```

The tests use the Java Reflection API under the hood to check the user tasks.

## Want to know more?

If you have questions about the course or the tasks or if you find some errors,
you can ask questions and participate in discussions in repository [issues](https://github.com/jetbrains-academy/kotlin-onboarding-part2/issues).

## Contribution

Please be sure to review the [project's contributing guidelines](./contributing.md) to learn how to help the project.
