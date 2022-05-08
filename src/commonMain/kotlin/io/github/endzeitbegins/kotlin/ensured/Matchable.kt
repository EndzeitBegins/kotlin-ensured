package io.github.endzeitbegins.kotlin.ensured

import kotlin.reflect.KProperty0


/**
 * TODO
 */
public data class Matchable<out T>(
    val name: String,
    val value: T
)

/**
 * TODO
 */
public fun <T> KProperty0<T>.asMatchable(): Matchable<T> = Matchable(name, get())

/**
 * TODO
 */
public infix fun <T> T.named(name: String): Matchable<T> = Matchable(name, this)
