package io.github.endzeitbegins.kotlin.ensured.validators

import io.github.endzeitbegins.kotlin.ensured.Matchable
import io.github.endzeitbegins.kotlin.ensured.Matcher
import io.github.endzeitbegins.kotlin.ensured.Matcher.MatchResult.Success

/**
 * TODO
 */
public fun <T> whenNotNull(nonNullMatcherFactory: () -> Matcher<T>): Matcher<T?> =
    WhenNotNullMatcher(nonNullMatcherFactory)

internal class WhenNotNullMatcher<T>(private val nonNullMatcherFactory: () -> Matcher<T>) : Matcher<T?> {
    override fun match(property: Matchable<T?>): Matcher.MatchResult {
        return if (property.value != null) {
            val nonNullValidator = nonNullMatcherFactory.invoke()

            nonNullValidator.match(Matchable(property.name, property.value))
        } else Success
    }
}

