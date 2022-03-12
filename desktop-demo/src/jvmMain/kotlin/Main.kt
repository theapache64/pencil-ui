import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.github.theapache64.pencilui.common.CommonDemo
import kotlinx.coroutines.*

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

suspend fun mains(args: Array<String>) {
    CoroutineScope(Dispatchers.IO).launch {
        val firstJob = Job()
        launch(firstJob) {
            println("Starting first task")
            repeat(3) {
                launch {
                    delay(3000)
                    println("Finished task $it")
                    if(it==2){
                        firstJob.complete()
                    }
                }
            }
        }
        println("Waiting for tasks to finish")
        firstJob.join()
        launch {
            println("I am second task")
        }
    }.join()
}
