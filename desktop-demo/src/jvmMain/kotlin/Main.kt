import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.github.theapache64.pencilui.common.CommonDemo

fun main() = application {
    Window(
        title = "Pencil UI Demo - Desktop",
        onCloseRequest = ::exitApplication,
        state = WindowState(
            width = 400.dp,
            height = 800.dp
        )
    ) {
        CommonDemo()
    }
}