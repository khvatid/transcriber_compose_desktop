package ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.SettingsComponent

@Composable
fun SettingsUi(component: SettingsComponent) {
    Scaffold(
        topBar = { TopBarUi(component) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Закрепить поверх экранов")
                Switch(checked = component.alwaysTop.value, onCheckedChange = { component.alwaysTop.value = it })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Темная тема")
                Switch(checked = component.theme.value, onCheckedChange = { component.theme.value = it })
            }
        }
    }
}