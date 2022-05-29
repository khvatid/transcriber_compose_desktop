package ui.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.ComponentContext
import components.ChildComponent
import components.RootComponent
import components.SettingsComponent
import util.IconRes

@Composable
fun TopBarUi(component: ChildComponent) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(
            onClick = {component.onNext()}) {
            if ( component is SettingsComponent) IconRes.back()
            else IconRes.settings()
        }
        Text(
            text = "ɯlʞɾ|ABC",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = { component.onBack() }) {
            IconRes.close()
        }
    }


}