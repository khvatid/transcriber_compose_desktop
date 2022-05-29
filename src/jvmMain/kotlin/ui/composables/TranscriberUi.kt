package ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import components.TranscriberComponent
import util.IconRes

@Composable
fun TranscriberUi(component: TranscriberComponent) {

    Scaffold(
        topBar= { TopBarUi(component) }
    ){
        Column(modifier = Modifier.padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween) {
            Box(modifier = Modifier.weight(6.2f)){
                OutlinedTextField(
                    value = component.defaultText.value,
                    onValueChange = {component.defaultText.value = it},
                    label = { Text("Количество символов ${component.defaultText.value.length}")},
                    modifier = Modifier.fillMaxSize())
            }
            Row(modifier = Modifier.fillMaxWidth().weight(0.8f).padding(top = 10.dp)){
                OutlinedButton(onClick = {component.transcript()}){
                    Text("Выполнить")
                }
                Spacer(Modifier.weight(1f,true))
                IconButton(onClick = {component.pasteFromBuffer()}){
                    IconRes.paste()
                }
                IconButton(onClick = {component.saveToBuffer()}){
                    IconRes.copy()
                }
                IconButton(onClick = {component.clearText()}){
                    IconRes.trash()
                }
            }
        }
    }
}