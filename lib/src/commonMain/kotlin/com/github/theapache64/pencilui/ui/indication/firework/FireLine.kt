package com.github.theapache64.pencilui.ui.indication.firework

import androidx.compose.ui.geometry.Offset

data class FireLine(
    val start: Offset,
    val end: Offset,
) {
    companion object {
        val Zero = FireLine(Offset.Zero, Offset.Zero)
    }
}