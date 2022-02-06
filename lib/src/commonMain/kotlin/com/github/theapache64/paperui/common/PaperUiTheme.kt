package com.github.theapache64.paperui.common

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PaperUiTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content
    )
}