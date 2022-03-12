package com.github.theapache64.pencilui.ui.indication.firework

import androidx.compose.animation.core.AnimationVector4D
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.ui.geometry.Offset

internal val fireLineConverter by lazy {
    TwoWayConverter<FireLine, AnimationVector4D>(
        convertFromVector = {
            FireLine(
                start = Offset(it.v1, it.v2),
                end = Offset(it.v3, it.v4)
            )
        },
        convertToVector = {
            AnimationVector4D(
                it.start.x,
                it.start.y,
                it.end.x,
                it.end.y
            )
        }
    )
}