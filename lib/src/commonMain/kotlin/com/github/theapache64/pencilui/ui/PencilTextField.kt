package com.github.theapache64.pencilui.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import com.github.theapache64.pencilui.ui.common.HandDrawnRectangle

@Composable
fun PencilTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    cursorBrush: Brush = SolidColor(Color.Black),
    decorationBox: @Composable (innerTextField: @Composable () -> Unit) -> Unit =
        @Composable { innerTextField -> innerTextField() },
    borderColor: Color = PencilUiTheme.color.borderColor,
    borderWidth: Dp = PencilUiTheme.dimens.borderWidth,
    innerPadding: Dp = PencilUiTheme.dimens.textFieldInnerPadding,
    textColor: Color = PencilUiTheme.color.contentColor,
    disabledTextColor: Color = PencilUiTheme.color.disabledContentColor,
    disabledBorderColor: Color = PencilUiTheme.color.disabledBorderColor,
    textStyle: TextStyle = MaterialTheme.typography.body1.copy(
        color = if (enabled) textColor else disabledTextColor
    ),
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
                border = BorderStroke(
                    width = borderWidth,
                    color = if (enabled) borderColor else disabledBorderColor
                ),
                shape = borderShape
            )
            .padding(innerPadding),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        visualTransformation = visualTransformation,
        onTextLayout = onTextLayout,
        interactionSource = interactionSource,
        cursorBrush = cursorBrush,
        decorationBox = decorationBox
    )
}