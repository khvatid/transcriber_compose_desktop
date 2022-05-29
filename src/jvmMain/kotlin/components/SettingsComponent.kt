package components

import androidx.compose.runtime.MutableState
import com.arkivanov.decompose.ComponentContext

class SettingsComponent(
    componentContext: ComponentContext,
    override val onBack: () -> Unit,
    override val onNext: () -> Unit,
    val theme: MutableState<Boolean>,
    val alwaysTop:  MutableState<Boolean>
) : ChildComponent ,ComponentContext by componentContext {



}