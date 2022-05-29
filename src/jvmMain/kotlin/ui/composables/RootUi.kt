package ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

import androidx.compose.ui.window.*
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import components.RootComponent

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun RootUi(component: RootComponent) {
    Window(
        onCloseRequest = { component.onClose() },
        visible = component.isVisible.value,
        undecorated = true,
        resizable = false,
        alwaysOnTop = component.isTop.value,
        state = WindowState(
            size = DpSize(350.dp, 700.dp),
            position = WindowPosition(Alignment.BottomEnd),
        )
        ) {
        MaterialTheme{
            Children(
                component.routerState,
                modifier = Modifier.padding(bottom = 36.dp)
            ) { child -> child.instance() }
        }
    }
}