import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.github.theapache64.paperui.common.CommonDemo

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        CommonDemo()
    }
}