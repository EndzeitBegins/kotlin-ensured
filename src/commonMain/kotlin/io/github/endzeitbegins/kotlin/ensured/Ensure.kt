package io.github.endzeitbegins.kotlin.ensured

import io.github.endzeitbegins.kotlin.ensured.defaults.ValidationException
import kotlin.reflect.KProperty0


/**
 * TODO
 */
public interface EnsureContext : ValidationExceptionProvider {
    /**
     * TODO
     */
    public fun <T> ensureThat(matchable: Matchable<T>, matcher: Matcher<T>) {
        matcher.match(matchable).orThrow(::provideValidationException)
    }

    /**
     * TODO
     */
    public fun <T> ensure(matchable: Matchable<T>, matcher: Matcher<T>): Unit =
        ensureThat(matchable, matcher)

    /**
     * TODO
     */
    public fun <T> ensureThat(property: KProperty0<T>, matcher: Matcher<T>): Unit =
        ensureThat(property.asMatchable(), matcher)

    /**
     * TODO
     */
    public fun <T> ensure(property: KProperty0<T>, matcher: Matcher<T>): Unit =
        ensureThat(property, matcher)
}

internal object DefaultEnsureContext : EnsureContext {
    override fun provideValidationException(failureReasons: Matcher.MatchResult.Failure): Throwable {
        return ValidationException(failureReasons.reason)
    }
}