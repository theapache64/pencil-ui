package com.github.theapache64.pencilui.util

import androidx.compose.ui.Modifier

inline fun Modifier.addIf(
    value: Boolean,
    builder: Modifier.() -> Modifier
): Modifier {
    return if (value) builder() else this
}