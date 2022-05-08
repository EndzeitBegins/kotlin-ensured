package io.github.endzeitbegins.kotlin.ensured.internal.validators

import io.github.endzeitbegins.kotlin.ensured.Matchable
import io.github.endzeitbegins.kotlin.ensured.Matcher

internal object SucceedingMatcher : Matcher<Any?> {
    override fun match(property: Matchable<Any?>): Matcher.MatchResult = Matcher.MatchResult.Success
}