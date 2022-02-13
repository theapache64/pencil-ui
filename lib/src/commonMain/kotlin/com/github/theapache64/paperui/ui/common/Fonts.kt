package com.github.theapache64.paperui.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.github.theapache64.paperui.platform.Font

object Fonts {
    @Composable
    fun sweetHeart() = FontFamily(
        Font(
            "sweet_heart",
            FontWeight.Normal,
            FontStyle.Normal
        )
    )
}