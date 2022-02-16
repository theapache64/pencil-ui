package com.github.theapache64.pencilui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.theapache64.pencilui.ui.PencilButton
import com.github.theapache64.pencilui.ui.PencilText
import com.github.theapache64.pencilui.ui.PencilTextField
import com.github.theapache64.pencilui.ui.PencilUiTheme
import com.github.theapache64.pencilui.ui.common.PencilUiDevConfig

@Composable
fun CommonDemo() {
    PencilUiTheme(
        devConfig = PencilUiDevConfig(debug = false)
    ) {
        LazyColumn(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                PencilText("Pencil UI Demo")
            }

            items(1) {
                var value by rememberSaveable { mutableStateOf("") }
                PencilTextField(
                    value = value,
                    onValueChange = {
                        value = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    PencilButton(
                        onClick = {},
                        text = "Normal Button"
                    )

                    PencilButton(
                        onClick = {},
                        text = "Disabled Button",
                        enabled = false
                    )
                }
            }
        }
    }
}
