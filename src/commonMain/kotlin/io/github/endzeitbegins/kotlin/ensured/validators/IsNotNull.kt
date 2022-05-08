package io.github.endzeitbegins.kotlin.ensured.validators

import io.github.endzeitbegins.kotlin.ensured.Matchable
import io.github.endzeitbegins.kotlin.ensured.Matcher
import io.github.endzeitbegins.kotlin.ensured.internal.validators.SucceedingMatcher

/**
 * TODO
 */
public fun <T> isNotNull(nonNullMatcherFactory: () -> Matcher<T>): Matcher<T?> =
    IsNotNullMatcher(nonNullMatcherFactory)

/**
 * TODO
 */
public fun <T> isNotNull(): Matcher<T?> = IsNotNullMatcher { SucceedingMatcher }

internal class IsNotNullMatcher<T>(private val nonNullMatcherFactory: () -> Matcher<T>) : Matcher<T?> {
    override fun match(property: Matchable<T?>): Matcher.MatchResult {
        return if (property.value == null) {
            Matcher.MatchResult.Failure(
                """"${property.name}" is NOT non-null, but null instead!"""
            )
        } else {
            val nonNullValidator = nonNullMatcherFactory.invoke()

            nonNullValidator.match(Matchable(property.name, property.value))
        }
    }
}
