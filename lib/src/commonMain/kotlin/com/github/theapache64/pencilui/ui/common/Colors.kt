package com.github.theapache64.pencilui.ui.common

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class PencilUiColors(
    val contentColor: Color = Color.Black,
    val disabledAlpha: Float = 0.5f,
    val disabledContentColor: Color = contentColor.copy(alpha = disabledAlpha),
    val borderColor: Color = Color.Black,
    val disabledBorderColor: Color = borderColor.copy(alpha = disabledAlpha),
    val buttonBgColor: Color = Color(0xFFCCCCCC),
    val disabledButtonBgColor: Color = buttonBgColor.copy(alpha = disabledAlpha),
    val rippleColor: Color = contentColor.copy(alpha = disabledAlpha)
)

internal val LocalPencilUiColors = staticCompositionLocalOf {
    PencilUiColors()
}