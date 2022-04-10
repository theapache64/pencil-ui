package com.github.theapache64.pencilui.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.theapache64.pencilui.ui.common.LocalPencilUiDevConfig
import com.github.theapache64.pencilui.ui.common.PencilBorder
import com.github.theapache64.pencilui.ui.indication.firework.FireworkIndication
import com.github.theapache64.pencilui.util.addIf
import kotlinx.coroutines.flow.collect


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PencilButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    enableFireworkIndication: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    shape: Shape = MaterialTheme.shapes.small,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    borderWidth: Dp = PencilUiTheme.dimens.borderWidth,
    textColor: Color = PencilUiTheme.color.contentColor,
    disabledTextColor: Color = PencilUiTheme.color.disabledContentColor,
    borderColor: Color = PencilUiTheme.color.borderColor,
    disabledBorderColor: Color = PencilUiTheme.color.disabledBorderColor,
    backgroundColor: Color = PencilUiTheme.color.buttonBgColor,
    disabledBackgroundColor: Color = PencilUiTheme.color.disabledButtonBgColor,
    border: BorderStroke = BorderStroke(width = borderWidth, color = if (enabled) borderColor else disabledBorderColor),
    content: @Composable RowScope.() -> Unit
) {
    val density = LocalDensity.current
    val pencilBorder = remember { PencilBorder(density) }
    var scale by remember { mutableStateOf(1f) }
    val animatedScale by animateFloatAsState(
        targetValue = scale,
        // tween(durationMillis = 200)
    )
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect {
            if (enabled) {
                when (it) {
                    is PressInteraction.Press -> {
                        scale = 0.9f
                    }
                    is PressInteraction.Release, is PressInteraction.Cancel -> {
                        scale = 1f
                    }
                }
            }
        }
    }
    Surface(
        modifier = modifier
            .scale(animatedScale)
            .addIf(PencilUiTheme.dev.debug) {
                background(LocalPencilUiDevConfig.current.debugColor)
            }
            .padding(all = (borderWidth.value * 2).dp)
            .background(if (enabled) backgroundColor else disabledBackgroundColor, pencilBorder)
            .addIf(enabled && enableFireworkIndication) {
                indication(
                    interactionSource = interactionSource,
                    indication = remember { FireworkIndication() }
                )
            }
            .border(
                border = border,
                shape = pencilBorder
            ),
        shape = shape,
        color = colors.backgroundColor(enabled).value,
        contentColor = if (enabled) textColor else disabledTextColor,
        elevation = elevation?.elevation(enabled, interactionSource)?.value ?: 0.dp,
        indication = if (enabled) rememberRipple() else null,
        interactionSource = interactionSource,
        onClick = onClick
    ) {
        val textColorAlpha = if (enabled) textColor.alpha else disabledTextColor.alpha
        CompositionLocalProvider(LocalContentAlpha provides textColorAlpha) {
            ProvideTextStyle(
                value = MaterialTheme.typography.button
            ) {
                Row(
                    Modifier
                        .defaultMinSize(
                            minWidth = ButtonDefaults.MinWidth,
                            minHeight = ButtonDefaults.MinHeight
                        )
                        .padding(contentPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }
}