package com.github.theapache64.paperui.ui.common

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class PaperUiDevConfig(
    val debug: Boolean = false,
    val debugColor: Color = Color.Red
)

internal val LocalPaperUiDevConfig = staticCompositionLocalOf {
    PaperUiDevConfig()
}