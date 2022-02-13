package com.github.theapache64.paperui.common

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
import com.github.theapache64.paperui.PaperButton
import com.github.theapache64.paperui.PaperText
import com.github.theapache64.paperui.PaperTextField
import com.github.theapache64.paperui.PaperUiTheme

@Composable
fun CommonDemo() {
    PaperUiTheme {
        LazyColumn(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                PaperText("Paper UI Demo")
            }

            items(1) {
                var value by rememberSaveable { mutableStateOf("") }
                PaperTextField(
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
                    repeat(3) {
                        PaperButton(
                            onClick = {

                            },
                            text = "Button $it"
                        )
                    }
                }
            }
        }
    }
}
