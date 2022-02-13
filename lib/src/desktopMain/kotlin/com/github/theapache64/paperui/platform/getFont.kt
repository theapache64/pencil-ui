package com.github.theapache64.paperui.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

@Composable
actual fun Font(res: String, weight: FontWeight, style: FontStyle): Font =
    Font("font/$res.otf", weight, style)