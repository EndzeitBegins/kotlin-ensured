package io.github.endzeitbegins.kotlin.ensured.validators

import io.github.endzeitbegins.kotlin.ensured.Matchable
import io.github.endzeitbegins.kotlin.ensured.Matcher
import io.github.endzeitbegins.kotlin.ensured.internal.validators.succeedIf

/**
 * TODO
 */
public fun <T> isNull(): Matcher<T> = IsNullMatcher()

internal class IsNullMatcher<T> : Matcher<T> {
    override fun match(property: Matchable<T>): Matcher.MatchResult =
        succeedIf(property.value == null) {
            """"${property.name}" is NOT null, but non-null instead!"""
        }
}
