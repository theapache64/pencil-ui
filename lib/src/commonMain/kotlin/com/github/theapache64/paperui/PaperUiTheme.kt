package com.github.theapache64.paperui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily


@Composable
fun PaperUiTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content,
        typography = Typography(
            defaultFontFamily = FontFamily(getFont())
        )
    )
}