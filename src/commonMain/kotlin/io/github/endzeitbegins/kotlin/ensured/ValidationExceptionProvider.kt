package io.github.endzeitbegins.kotlin.ensured

/**
 * TODO
 */
public fun interface ValidationExceptionProvider {
    /**
     * TODO
     */
    public fun provideValidationException(failureReasons: Matcher.MatchResult.Failure): Throwable
}