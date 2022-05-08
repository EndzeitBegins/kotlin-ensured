# kotlin-ensured

![project status](https://img.shields.io/badge/status-prototype-ff69b4)

Just another validation library for Kotlin. 

kotlin-ensured provides a simple Kotlin DSL 
to validate your objects, effectively allowing to enforce more strict types.

## Introduction

The Kotlin DSL provided has two basic entry points, `ensureThat` and `validateThat`,
behaving a little different.

### ensureThat

The `ensureThat` or `ensure` DSL throws an `Throwable` of the users choice,
when any other the defined constraints are NOT fulfilled. 

```kotlin

```

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