package com.github.theapache64.paperui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.github.theapache64.paperui.platform.Font
import com.github.theapache64.paperui.ui.common.Fonts


@Composable
fun PaperUiTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content,
        typography = Typography(
            defaultFontFamily = Fonts.sweetHeart()
        )
    )
}