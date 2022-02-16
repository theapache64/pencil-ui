package com.github.theapache64.pencilui.ui.common

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class PencilUiDimens(
    val borderWidth: Dp = 1.5.dp,
    val textFieldInnerPadding: Dp = 15.dp
)

internal val LocalPencilUiDimens = staticCompositionLocalOf {
    PencilUiDimens()
}