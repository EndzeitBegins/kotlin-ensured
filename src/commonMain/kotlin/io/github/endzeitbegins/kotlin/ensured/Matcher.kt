package io.github.endzeitbegins.kotlin.ensured

/**
 * TODO
 */
public fun interface Matcher<in T> {

    /**
     * TODO
     */
    public sealed interface MatchResult {

        /**
         * TODO
         */
        public object Success : MatchResult

        /**
         * TODO
         */
        public data class Failure(
            val reason: String,
            val additionalReasons: List<String> = emptyList()
        ) : MatchResult
    }


    /**
     * TODO
     */
    public fun match(property: Matchable<T>): MatchResult
}

/**
 * TODO
 */
public infix fun <T> Matcher<T>.and(that: Matcher<T>): Matcher<T> {
    return Matcher { property -> this.match(property) and that.match(property) }
}