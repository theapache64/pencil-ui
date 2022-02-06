package com.github.theapache64.paperui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CommonDemo() {
    PaperUiTheme {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            var value by remember { mutableStateOf("") }
            PaperTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                modifier = Modifier.size(100.dp)
            )
        }
    }
}
