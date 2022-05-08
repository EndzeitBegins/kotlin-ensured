package io.github.endzeitbegins.kotlin.ensured

import io.github.endzeitbegins.kotlin.ensured.DefaultEnsureContext.ensure
import io.github.endzeitbegins.kotlin.ensured.DefaultEnsureContext.ensureThat
import io.github.endzeitbegins.kotlin.ensured.defaults.ValidationException
import io.github.endzeitbegins.kotlin.ensured.validators.hasSize
import io.github.endzeitbegins.kotlin.ensured.validators.isNull
import io.github.endzeitbegins.kotlin.ensured.validators.whenNotNull

// TODO remove this ...
private data class Foo(
    val bar: String,
    val baz: String?,
) {

    init {
        validate(::bar, isNull())

        validateThat(::bar, hasSize(3) and hasSize(3)) and
                validateThat(::baz, whenNotNull { hasSize(5) }) and
                validateThat(::baz, whenNotNull { hasSize(4) }) orThrow {
            ValidationException(it.reason)
        }

        val value = "foo"
        ensure(value named "myProp", hasSize(6))

        ensureThat(::bar, hasSize(3) and hasSize(3))
        ensureThat(::baz, whenNotNull { hasSize(5) })
    }
}

internal fun main() {
    Foo("meh", null)
    Foo("mehe", "mew")
    Foo("meheh", "dwa")
}