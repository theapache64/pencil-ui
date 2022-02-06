package com.github.theapache64.paperui

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
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

@Composable
fun PaperButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val handDrawnRectangleShape = remember { HandDrawnRectangleShape() }
    TextButton(
        onClick,
        modifier = modifier
            .padding(
                start = handDrawnRectangleShape.leftGravity.absoluteValue.dp,
                end = handDrawnRectangleShape.rightGravity.absoluteValue.dp,
                top = handDrawnRectangleShape.topGravity.absoluteValue.dp,
                bottom = handDrawnRectangleShape.bottomGravity.absoluteValue.dp,
            )
            .border(BorderStroke(2.dp, Color.Black), handDrawnRectangleShape)
            .background(Color(0xffcccccc), handDrawnRectangleShape)
            ,
        enabled = enabled,
        content = {
            PaperText(text = text, color = Color.Black)
        },
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.Black
        )
    )
}