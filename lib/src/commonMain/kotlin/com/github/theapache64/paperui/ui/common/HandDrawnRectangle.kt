package com.github.theapache64.paperui.ui.common

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

internal class HandDrawnRectangle(
    density: Density
) : Shape {
    companion object {
        val curveDpRange = (-7..7).filter { it.absoluteValue > 4 }
        val curveAtPerc = (30..70)
    }

    private val topCurve = with(density) { curveDpRange.random().dp.toPx() }
    private val rightCurve = with(density) { curveDpRange.random().dp.toPx() }
    private val bottomCurve = with(density) { curveDpRange.random().dp.toPx() }
    private val leftCurve = with(density) { curveDpRange.random().dp.toPx() }

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
                x1 = ((size.width * topCurveAtPerc) / 100), // curve at middle
                y1 = topCurve, // push
                x2 = size.width,
                y2 = 0f
            )
            // right border
            quadraticBezierTo(
                x1 = size.width + rightCurve, //  pull
                y1 = (size.height * rightCurveAtPerc) / 100, // curve at 3/4
                x2 = size.width,
                y2 = size.height
            )

            // bottom border
            quadraticBezierTo(
                x1 = (size.width * bottomCurveAtPerc) / 100,
                y1 = size.height + bottomCurve, // push
                x2 = 0f,
                y2 = size.height
            )

            // left border
            quadraticBezierTo(
                x1 = leftCurve,
                y1 = (size.height * leftCurveAtPerc) / 100,
                x2 = 0f,
                y2 = 0f
            )
        })
    }
}