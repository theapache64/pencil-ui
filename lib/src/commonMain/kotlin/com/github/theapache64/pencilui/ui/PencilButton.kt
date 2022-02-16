package com.github.theapache64.pencilui.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.theapache64.pencilui.ui.common.HandDrawnRectangle

inline fun Modifier.ifTrue(
    value: Boolean,
    builder: Modifier.() -> Modifier
): Modifier {
    return if (value) builder() else this
}

@Composable
fun PencilButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    borderWidth: Dp = PencilUiTheme.dimens.borderWidth,
    backgroundColor: Color = PencilUiTheme.color.buttonBgColor
) {
    val density = LocalDensity.current
    val handDrawnRectangle = remember { HandDrawnRectangle(density) }
    TextButton(
        onClick,
        modifier = modifier
            .ifTrue(PencilUiTheme.dev.debug) {
                background(Color.Red)
            }
            .padding(all = (borderWidth.value * 2).dp)
            .border(BorderStroke(borderWidth, Color.Black), handDrawnRectangle)
            .background(backgroundColor, handDrawnRectangle)
            ,
        enabled = enabled,
        content = {
            PencilText(text = text, color = Color.Black)
        },
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.Black
        )
    )
}