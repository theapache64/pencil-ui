package com.github.theapache64.pencilui.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.github.theapache64.pencilui.ui.common.*


@Composable
fun PencilUiTheme(
    colors: PencilUiColors = PencilUiTheme.color,
    dimens: PencilUiDimens = PencilUiTheme.dimens,
    devConfig: PencilUiDevConfig = PencilUiTheme.dev,
    typography: Typography = Typography(
        defaultFontFamily = Fonts.sweetHeart(),
        button = TextStyle(
            fontSize = 40.sp
        ),
        body1 = TextStyle(
            fontSize = 40.sp
        ),
    ),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalPencilUiColors provides colors,
        LocalPencilUiDimens provides dimens,
        LocalPencilUiDevConfig provides devConfig,
    ){
        MaterialTheme(
            content = content,
            typography = typography
        )
    }
}

object PencilUiTheme {
    val dimens: PencilUiDimens
        @Composable
        @ReadOnlyComposable
        get() = LocalPencilUiDimens.current

    val color: PencilUiColors
        @Composable
        @ReadOnlyComposable
        get() = LocalPencilUiColors.current

    val dev: PencilUiDevConfig
        @Composable
        @ReadOnlyComposable
        get() = LocalPencilUiDevConfig.current
}