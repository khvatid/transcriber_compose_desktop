package components

import com.arkivanov.decompose.ComponentContext

class SettingsComponent(
    componentContext: ComponentContext,
    val onClose: () -> Unit,
    val changeTheme: () -> Unit,
) : ComponentContext by componentContext {


}