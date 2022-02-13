package com.github.theapache64.paperui.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.github.theapache64.paperui.ui.common.HandDrawnRectangle

@Composable
fun PaperTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 40.sp,
    borderColor: Color = PaperUiTheme.color.borderColor,
    borderWidth: Dp = PaperUiTheme.dimens.borderWidth,
    innerPadding: Dp = PaperUiTheme.dimens.textFieldInnerPadding,
    textStyle: TextStyle = MaterialTheme.typography.body1
) {
    val borderShape = remember { HandDrawnRectangle() }
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.border(
            width = borderWidth,
            color = borderColor,
            shape = borderShape
        ).padding(innerPadding),
        textStyle = textStyle.copy(fontSize = fontSize),
    )
}