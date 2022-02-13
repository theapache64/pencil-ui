package com.github.theapache64.paperui.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.github.theapache64.paperui.ui.common.*


@Composable
fun PaperUiTheme(
    typography: Typography = Typography(
        defaultFontFamily = Fonts.sweetHeart()
    ),
    colors: PaperUiColors = PaperUiTheme.color,
    dimens: PaperUiDimens = PaperUiTheme.dimens,
    devConfig: PaperUiDevConfig = PaperUiTheme.dev,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalPaperUiColors provides colors,
        LocalPaperUiDimens provides dimens,
        LocalPaperUiDevConfig provides devConfig,
    ){
        MaterialTheme(
            content = content,
            typography = typography
        )
    }
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

    val dev: PaperUiDevConfig
        @Composable
        @ReadOnlyComposable
        get() = LocalPaperUiDevConfig.current
}