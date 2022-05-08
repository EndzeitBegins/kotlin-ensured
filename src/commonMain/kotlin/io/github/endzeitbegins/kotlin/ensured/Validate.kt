package io.github.endzeitbegins.kotlin.ensured

import io.github.endzeitbegins.kotlin.ensured.Matcher.MatchResult.Failure
import io.github.endzeitbegins.kotlin.ensured.Matcher.MatchResult.Success
import kotlin.reflect.KProperty0

/**
 * TODO
 */
public fun <T> validateThat(matchable: Matchable<T>, matcher: Matcher<T>): Matcher.MatchResult =
    matcher.match(matchable)

/**
 * TODO
 */
public fun <T> validate(matchable: Matchable<T>, matcher: Matcher<T>): Matcher.MatchResult =
    validateThat(matchable, matcher)

/**
 * TODO
 */
public fun <T> validateThat(property: KProperty0<T>, matcher: Matcher<T>): Matcher.MatchResult =
    validateThat(property.asMatchable(), matcher)

/**
 * TODO
 */
public fun <T> validate(property: KProperty0<T>, matcher: Matcher<T>): Matcher.MatchResult =
    validateThat(property, matcher)

/**
 * TODO
 */
public infix fun Matcher.MatchResult.and(that: Matcher.MatchResult): Matcher.MatchResult {
    val failureReasons = this.failureReasons + that.failureReasons

    return if (failureReasons.isNotEmpty()) {
        Failure(failureReasons.first(), failureReasons.drop(1))
    } else Success
}

/**
 * TODO
 */
public infix fun Matcher.MatchResult.orThrow(throwableFactory: ValidationExceptionProvider): Success {
    return when (this) {
        is Failure -> throw throwableFactory.provideValidationException(this)
        is Success -> this
    }
}

private val Matcher.MatchResult.failureReasons: List<String>
    get() = when (this) {
        is Failure -> listOf(reason).plus(additionalReasons)
        is Success -> emptyList()
    }
