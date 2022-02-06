package com.github.theapache64.paperui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.theapache64.paperui.PaperTextField
import com.github.theapache64.paperui.PaperUiTheme

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

        Text("Hello")
    }
}
