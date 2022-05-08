package io.github.endzeitbegins.kotlin.ensured.internal.validators

import io.github.endzeitbegins.kotlin.ensured.Matcher

internal fun failIf(failureCondition: Boolean, failureReasonFactory: () -> String): Matcher.MatchResult =
    if (failureCondition) Matcher.MatchResult.Failure(failureReasonFactory.invoke()) else Matcher.MatchResult.Success