package com.github.theapache64.pencilui.ui.indication.firework

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector4D
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class FireworkIndication : Indication {
    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        var curve by remember { mutableStateOf(0) }
        val animatedCurve by animateIntAsState(curve)
        val animatedLines = remember<List<Animatable<FireLine, AnimationVector4D>>> {
            mutableListOf<Animatable<FireLine, AnimationVector4D>>().apply {
                // Building fire lines
                repeat(6) {
                    add(
                        Animatable(
                            initialValue = FireLine.Zero,
                            typeConverter = fireLineConverter
                        )
                    )
                }
            }
        }

        LaunchedEffect(interactionSource) {
            interactionSource.interactions.collect {
                when (it) {
                    is PressInteraction.Press -> {
                        val startPosition = it.pressPosition
                        val angleDiff = 360 / animatedLines.size
                        var angle = 0
                        val radius = 50 // TODO: Should be min(width, height)
                        launch {
                            // Animating fire lines for press action
                            for (line in animatedLines) {
                                val lineAngle = (angle * PI) / 180
                                launch {
                                    line.snapTo(FireLine(startPosition, startPosition))
                                    curve = radius / 5
                                    val endPosition = Offset(
                                        // Finding end coordinate for the given radian
                                        x = startPosition.x + radius * sin(lineAngle).toFloat(),
                                        y = startPosition.y - radius * cos(lineAngle).toFloat(),
                                    )
                                    line.animateTo(FireLine(startPosition, endPosition))
                                }
                                angle += angleDiff
                            }
                        }
                    }

                    is PressInteraction.Release, is PressInteraction.Cancel -> {
                        curve = 0
                        // Animating fire lines for release/cancel action
                        for (line in animatedLines) {
                            launch {
                                line.animateTo(
                                    FireLine(
                                        line.value.end,
                                        line.value.end
                                    ),
                                )
                            }
                        }
                    }
                }
            }
        }
        return remember(animatedLines, animatedCurve) {
            FireworkIndicationInstance(
                animatedLines,
                animatedCurve
            )
        }
    }
}


class FireworkIndicationInstance(
    private val lines: List<Animatable<FireLine, AnimationVector4D>>,
    private val curve: Int,
) : IndicationInstance {
    override fun ContentDrawScope.drawIndication() {
        drawContent()
        for (line in lines) {
            drawPath(
                path = Path().apply {
                    // move pointer to start
                    moveTo(line.value.start.x, line.value.start.y)

                    val curveOffset = if (curve != 0) {
                        Offset(
                            x = (line.value.start.x * 0.9f) + curve,
                            y = (line.value.start.y * 0.9f) - curve
                        )
                    } else {
                        Offset(
                            x = line.value.end.x,
                            y = line.value.end.y
                        )
                    }

                    quadraticBezierTo(
                        x1 = curveOffset.x,
                        y1 = curveOffset.y,
                        x2 = line.value.end.x,
                        y2 = line.value.end.y
                    )
                },
                color = Color.Black.copy(alpha = 0.5f),
                style = Stroke(width = 2f)
            )

            if (curve != 0) {
                drawCircle(
                    color = Color.Gray,
                    radius = 1f,
                    center = line.value.end
                )
            }
        }
    }
}
