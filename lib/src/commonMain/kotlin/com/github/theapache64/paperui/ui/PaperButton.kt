package com.github.theapache64.paperui.ui

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
import androidx.compose.ui.unit.Dp
import com.github.theapache64.paperui.ui.common.HandDrawnRectangle

@Composable
fun PaperButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    borderWidth: Dp = PaperUiTheme.dimens.borderWidth
) {
    val handDrawnRectangle = remember { HandDrawnRectangle() }
    TextButton(
        onClick,
        modifier = modifier
            .background(Color.Red)
            .padding(all = borderWidth)
            .border(BorderStroke(borderWidth, Color.Black), handDrawnRectangle)
            .background(Color(0xffcccccc), handDrawnRectangle),
        enabled = enabled,
        content = {
            PaperText(text = text, color = Color.Black)
        },
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.Black
        )
    )
}