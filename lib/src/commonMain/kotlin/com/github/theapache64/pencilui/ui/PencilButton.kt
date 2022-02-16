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
import com.github.theapache64.pencilui.ui.common.LocalPencilUiDevConfig

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
    textColor: Color = PencilUiTheme.color.contentColor,
    disabledTextColor: Color = PencilUiTheme.color.disabledContentColor,
    borderColor: Color = PencilUiTheme.color.borderColor,
    disabledBorderColor: Color = PencilUiTheme.color.disabledBorderColor,
    backgroundColor: Color = PencilUiTheme.color.buttonBgColor,
    disabledBackgroundColor: Color = PencilUiTheme.color.disabledButtonBgColor,
    rippleColor : Color = PencilUiTheme.color.rippleColor
) {
    val density = LocalDensity.current
    val handDrawnRectangle = remember { HandDrawnRectangle(density) }
    TextButton(
        onClick,
        modifier = modifier
            .ifTrue(PencilUiTheme.dev.debug) {
                background(LocalPencilUiDevConfig.current.debugColor)
            }
            .padding(all = (borderWidth.value * 2).dp)
            .border(
                border = BorderStroke(width = borderWidth, color = if (enabled) borderColor else disabledBorderColor),
                shape = handDrawnRectangle
            )
            .background(if (enabled) backgroundColor else disabledBackgroundColor, handDrawnRectangle),
        enabled = enabled,
        content = {
            PencilText(text = text, color = if (enabled) textColor else disabledTextColor)
        },
        colors = ButtonDefaults.textButtonColors(
            contentColor = rippleColor
        )
    )
}