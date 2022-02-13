package com.github.theapache64.paperui.ui.common

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class PaperUiColors(
    val borderColor: Color = Color.Black,
    val buttonBgColor: Color = Color(0xFFCCCCCC)
)

internal val LocalPaperUiColors = staticCompositionLocalOf {
    PaperUiColors()
}