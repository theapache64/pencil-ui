package com.github.theapache64.paperui.ui.common

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class PaperUiDimens(
    val borderWidth: Dp = 2.dp,
    val textFieldInnerPadding: Dp = 15.dp
)

internal val LocalPaperUiDimens = staticCompositionLocalOf {
    PaperUiDimens()
}