package com.github.theapache64.pencilui.ui.common

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class PencilUiColors(
    val borderColor: Color = Color.Black,
    val buttonBgColor: Color = Color(0xFFCCCCCC)
)

internal val LocalPencilUiColors = staticCompositionLocalOf {
    PencilUiColors()
}