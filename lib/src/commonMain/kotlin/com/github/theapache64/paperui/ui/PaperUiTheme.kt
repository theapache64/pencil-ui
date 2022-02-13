package com.github.theapache64.paperui.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.github.theapache64.paperui.ui.common.*
import com.github.theapache64.paperui.ui.common.LocalPaperUiColors
import com.github.theapache64.paperui.ui.common.LocalPaperUiDimens


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

object PaperUiTheme {
    val dimens: PaperUiDimens
        @Composable
        @ReadOnlyComposable
        get() = LocalPaperUiDimens.current

    val color: PaperUiColors
        @Composable
        @ReadOnlyComposable
        get() = LocalPaperUiColors.current
}