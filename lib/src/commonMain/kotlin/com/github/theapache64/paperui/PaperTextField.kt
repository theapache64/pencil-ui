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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.absoluteValue

@Composable
fun PaperTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val borderShape = remember { HandDrawnRectangleShape() }
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = borderShape
            )
            .padding(15.dp),
        textStyle = TextStyle.Default.copy(fontFamily = FontFamily(getFont()), fontSize = 40.sp)
    )
}

class HandDrawnRectangleShape : Shape {
    companion object {
        val gravityEngine = (-17..17).filter { it.absoluteValue > 1 }
        val locationEngine = (30..70)
    }

    val topGravity = gravityEngine.random().dp.value
    val rightGravity = gravityEngine.random().dp.value
    val bottomGravity = gravityEngine.random().dp.value
    val leftGravity = gravityEngine.random().dp.value

    private val topSpace = locationEngine.random()
    private val rightSpace = locationEngine.random()
    private val bottomSpace = locationEngine.random()
    private val leftSpace = locationEngine.random()

    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        return Outline.Generic(
            Path().apply {
                // move pointer to start
                moveTo(0f, 0f)

                // top border
                quadraticBezierTo(
                    (size.width * topSpace) / 100, // curve at middle
                    topGravity, // push
                    size.width,
                    0f
                )
                // right border
                quadraticBezierTo(
                    size.width + rightGravity, //  pull
                    (size.height * rightSpace) / 100, // curve at 3/4
                    size.width,
                    size.height
                )

                // bottom border
                quadraticBezierTo(
                    (size.width * bottomSpace) / 100,
                    size.height + bottomGravity, // push
                    0f,
                    size.height
                )

                // left border
                quadraticBezierTo(leftGravity, (size.height * leftSpace) / 100, 0f, 0f)
            }
        )
    }
}