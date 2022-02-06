import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.github.theapache64.paperui.common.CommonDemo

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = WindowState(
            width = 400.dp,
            height = 800.dp
        )
    ) {
        CommonDemo()
    }
}