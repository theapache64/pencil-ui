package com.github.theapache64.paperui

import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import com.github.theapache64.paperui.android.R
import java.io.File

@OptIn(ExperimentalTextApi::class)
actual fun getFont(): Font {
    return Font(R.font.sweet_heart)
}