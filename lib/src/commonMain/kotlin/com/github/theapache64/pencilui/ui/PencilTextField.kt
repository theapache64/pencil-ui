package com.github.theapache64.pencilui.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.github.theapache64.pencilui.ui.common.HandDrawnRectangle

@Composable
fun PencilTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 40.sp,
    borderColor: Color = PencilUiTheme.color.borderColor,
    borderWidth: Dp = PencilUiTheme.dimens.borderWidth,
    innerPadding: Dp = PencilUiTheme.dimens.textFieldInnerPadding,
    textStyle: TextStyle = MaterialTheme.typography.body1
) {
    val density = LocalDensity.current
    val borderShape = remember { HandDrawnRectangle(density) }
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .ifTrue(PencilUiTheme.dev.debug) {
                background(Color.Red)
            }
            .border(
                border = BorderStroke(borderWidth, borderColor),
                shape = borderShape
            )
            .padding(innerPadding),
        textStyle = textStyle.copy(fontSize = fontSize),
    )
}