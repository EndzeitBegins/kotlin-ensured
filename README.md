# kotlin-ensured

![project status](https://img.shields.io/badge/status-prototype-ff69b4)

Just another validation library for Kotlin. 

kotlin-ensured provides a simple Kotlin DSL 
to validate your objects, effectively allowing to enforce more strict types.

## Introduction

The Kotlin DSL provided has two basic entry points, `ensureThat` and `validateThat`,
behaving a little different.

### ensureThat / ensure

The `ensureThat` or `ensure` DSL throws an `Throwable` of the users choice,
when any other the defined constraints are NOT fulfilled. 

```kotlin
import io.github.endzeitbegins.kotlin.ensured.validators.hasSize
import io.github.endzeitbegins.kotlin.ensured.validators.matches
import io.github.endzeitbegins.kotlin.ensured.validators.whenNotNull
import my.package.MyCustomEnsureContext.ensure
import my.package.MyCustomEnsureContext.ensureThat

data class Foo(
    val bar: String,
    val baz: String?,
) {

    init {
        ensureThat(::bar, matches("""[01]{8}""".toRegex()))
        ensure(::baz, whenNotNull { hasSize(5) })
    }
}
```

These functions are defined as part of the `EnsureContext`, 
which requires a `ValidationExceptionProvider` to know which Throwable to throw.
To make use of the `ensureThat` / `ensure`, one may provide an `object` implementing the `EnsureContext`.
```kotlin
package my.package

import io.github.endzeitbegins.kotlin.ensured.EnsureContext
import io.github.endzeitbegins.kotlin.ensured.Matcher

object MyCustomEnsureContext : EnsureContext {
    override fun provideValidationException(failureReasons: Matcher.MatchResult.Failure): Throwable {
        return MyCustomException(...)
    }
}
```

The library itself provides a `ValidationException`, if one does not want to create a custom `Throwable`.

Then, one may import the `ensureThat` / `ensure` functions, e.g.:

```kotlin
import io.github.endzeitbegins.kotlin.ensured.named
import my.package.MyCustomEnsureContext.ensure

ensure("foo" named "bar", hasSize(3))
```

### validateThat / validate

...

## Setup

### Gradle

Kotlin DSL:

```kotlin
dependencies {
    implementation("io.github.endzeitbegins:kotlin-ensured:0.0.0")
}
```

Groovy DSL:

```gradle
dependencies {
    implementation "io.github.endzeitbegins:kotlin-ensured:0.0.0"
}
```

### Maven

```xml
<dependency>
    <groupId>io.github.endzeitbegins</groupId>
    <artifactId>kotlin-ensured</artifactId>
    <version>0.0.0</version>
</dependency>
```