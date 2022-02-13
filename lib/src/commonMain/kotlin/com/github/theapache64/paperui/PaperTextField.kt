package com.github.theapache64.paperui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.*
import com.github.theapache64.paperui.ui.common.Fonts
import kotlin.math.absoluteValue

@Composable
fun PaperTextField(
    value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier, fontSize: TextUnit = 40.sp
) {
    val borderShape = remember { HandDrawnRectangle() }
    BasicTextField(
        value = value, onValueChange = onValueChange, modifier = modifier.border(
            width = 2.dp, color = Color.Black, shape = borderShape
        ).padding(15.dp), textStyle = TextStyle.Default.copy(
            fontFamily = Fonts.sweetHeart(), fontSize = fontSize
        )
    )
}

class HandDrawnRectangle : Shape {
    companion object {
        val curveRange = (-7..7).filter { it.absoluteValue > 1 }
        val curveAtPerc = (30..70)
    }

    val topCurveRange = curveRange.random().dp.value
    val rightCurveRange = curveRange.random().dp.value
    val bottomCurveRange = curveRange.random().dp.value
    val leftCurveRange = curveRange.random().dp.value

    private val topCurveAtPerc = curveAtPerc.random()
    private val rightCurveAtPerc = curveAtPerc.random()
    private val bottomCurveAtPerc = curveAtPerc.random()
    private val leftCurveAtPerc = curveAtPerc.random()

    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        return Outline.Generic(Path().apply {
            // move pointer to start
            moveTo(0f, 0f)

            // top border
            quadraticBezierTo(
                x1 = (size.width * topCurveAtPerc) / 100, // curve at middle
                y1 = topCurveRange, // push
                x2 = size.width, y2 = 0f
            )
            // right border
            quadraticBezierTo(
                x1 = size.width + rightCurveRange, //  pull
                y1 = (size.height * rightCurveAtPerc) / 100, // curve at 3/4
                x2 = size.width, y2 = size.height
            )

            // bottom border
            quadraticBezierTo(
                x1 = (size.width * bottomCurveAtPerc) / 100, y1 = size.height + bottomCurveRange, // push
                x2 = 0f, y2 = size.height
            )

            // left border
            quadraticBezierTo(
                x1 = leftCurveRange, y1 = (size.height * leftCurveAtPerc) / 100, x2 = 0f, y2 = 0f
            )
        })
    }
}