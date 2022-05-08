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
To make use of the `ensureThat` / `ensure`, one may provide an `object` implementing the `EnsureContext`,
from which one can import the functions afterwards, e.g.:
```kotlin
object MyCustomEnsureContext : EnsureContext {
    override fun provideValidationException(failureReasons: Matcher.MatchResult.Failure): Throwable {
        return MyCustomException(...)
    }
}

...

import my.package.MyCustomEnsureContext.ensure
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