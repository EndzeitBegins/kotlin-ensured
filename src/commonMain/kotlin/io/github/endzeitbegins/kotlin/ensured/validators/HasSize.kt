package io.github.endzeitbegins.kotlin.ensured.validators

import io.github.endzeitbegins.kotlin.ensured.Matchable
import io.github.endzeitbegins.kotlin.ensured.Matcher
import io.github.endzeitbegins.kotlin.ensured.internal.validators.failIf

/**
 * TODO
 */
public fun hasSize(size: Int): Matcher<String> = HasSizeMatcher(size)

internal class HasSizeMatcher(private val size: Int) : Matcher<String> {
    override fun match(property: Matchable<String>): Matcher.MatchResult =
        failIf(property.value.length != size) {
            """"${property.name}" does NOT have a size of $size, but ${property.value.length} instead!"""
        }
}
