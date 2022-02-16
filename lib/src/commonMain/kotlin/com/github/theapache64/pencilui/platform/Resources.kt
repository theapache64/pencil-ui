package com.github.theapache64.pencilui.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
expect fun Font(res: String, weight: FontWeight, style: FontStyle): Font