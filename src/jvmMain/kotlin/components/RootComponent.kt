package components

import util.Content
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.window.ApplicationScope
import util.asContent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.push
import com.arkivanov.decompose.router.router
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.parcelable.Parcelable
import ui.composables.SettingsUi
import ui.composables.TranscriberUi

class RootComponent(private val applicationScope: ApplicationScope,
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val router = router<RootConfiguration, Content>(
        initialConfiguration = RootConfiguration.Transcriber,
        childFactory = ::createChild
    )

    val routerState = router.state
    val isVisible = mutableStateOf(true)
    val darkTheme = mutableStateOf(false)
    fun onClose(){
        applicationScope.exitApplication()
    }
    fun openSettings(){
        router.push(RootConfiguration.Settings)
    }
    private fun createChild(configuration: RootConfiguration, componentContext: ComponentContext): Content = when (configuration) {
        is RootConfiguration.Transcriber -> transcriber()
        is RootConfiguration.Settings -> settings()
    }

    private fun transcriber(): Content = TranscriberComponent(
        componentContext = childContext(
            key = "Transcriber",
            lifecycle = LifecycleRegistry()
        )
    ).asContent { TranscriberUi(it) }

    private fun settings(): Content = SettingsComponent(
        componentContext = childContext(
            key = "Settings",
            lifecycle = LifecycleRegistry()
        ),
        onClose = {router.pop()},
        changeTheme = {darkTheme.value = !darkTheme.value}
    ).asContent { SettingsUi(it) }

    sealed class RootConfiguration : Parcelable {
        object Transcriber : RootConfiguration()
        object Settings: RootConfiguration()
    }
}