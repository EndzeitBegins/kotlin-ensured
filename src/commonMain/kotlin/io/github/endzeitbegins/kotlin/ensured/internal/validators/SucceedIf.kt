package io.github.endzeitbegins.kotlin.ensured.internal.validators

import io.github.endzeitbegins.kotlin.ensured.Matcher

internal fun succeedIf(successCondition: Boolean, failureReasonFactory: () -> String): Matcher.MatchResult =
    failIf(!successCondition, failureReasonFactory)