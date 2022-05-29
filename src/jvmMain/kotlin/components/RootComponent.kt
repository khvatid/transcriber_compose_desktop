package components

import util.Content
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.window.ApplicationScope
import util.asContent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.*
import com.arkivanov.essenty.parcelable.Parcelable
import ui.composables.SettingsUi
import ui.composables.TranscriberUi

class RootComponent(private val applicationScope: ApplicationScope,
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val router = router<RootConfiguration, Content>(
        initialConfiguration = RootConfiguration.Transcriber,
        handleBackButton = true,
        childFactory = ::createChild
    )

    val routerState = router.state
    val isVisible = mutableStateOf(true)
    val isTop = mutableStateOf(false)
    val darkTheme = mutableStateOf(false)
    fun onClose(){
        applicationScope.exitApplication()
    }
    fun openSettings(){
        router.push(RootConfiguration.Settings)
    }
    private fun createChild(configuration: RootConfiguration, componentContext: ComponentContext): Content = when (configuration) {
        is RootConfiguration.Transcriber -> transcriber(componentContext)
        is RootConfiguration.Settings -> settings(componentContext)
    }

    private fun transcriber(componentContext: ComponentContext): Content = TranscriberComponent(
        componentContext = componentContext,
        openSettings = {router.push(RootConfiguration.Settings)},
        closeWindow = {isVisible.value = false}
    ).asContent { TranscriberUi(it) }

    private fun settings(componentContext: ComponentContext): Content = SettingsComponent(
        componentContext = componentContext,
        onBack = {isVisible.value = false},
        onNext = {router.pop()},
        theme = darkTheme,
        alwaysTop = isTop
    ).asContent { SettingsUi(it) }

    sealed class RootConfiguration : Parcelable {
        object Transcriber : RootConfiguration()
        object Settings: RootConfiguration()
    }
}