package com.github.theapache64.pencilui.ui.common

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class PencilUiDevConfig(
    val debug: Boolean = false,
    val debugColor: Color = Color.Red
)

internal val LocalPencilUiDevConfig = staticCompositionLocalOf {
    PencilUiDevConfig()
}