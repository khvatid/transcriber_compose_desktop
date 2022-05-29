package components

import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection
import java.awt.datatransfer.UnsupportedFlavorException

class TranscriberComponent(
    closeWindow: ()->Unit,
    openSettings: ()->Unit,
    componentContext: ComponentContext,
) : ChildComponent ,ComponentContext by componentContext {
    val defaultText = mutableStateOf("")
    override val onBack: () -> Unit = closeWindow
    override val onNext: () -> Unit = openSettings

    fun saveToBuffer() {
        val save = StringSelection(defaultText.value)
        clipboard.setContents(save, null)
    }

    fun pasteFromBuffer() {
        val dataFlavor = DataFlavor.stringFlavor
        try {
            val paste = clipboard.getData(dataFlavor).toString()
            defaultText.value = paste
        } catch (message: UnsupportedFlavorException) {
            println(message)
        }
    }

    fun clearText() {
        defaultText.value = ""
    }


    fun transcript() {
        var transcriptText = ""
        for (i in 0..defaultText.value.length - 1) {
            for (j in 0..rus.length) {
                if (defaultText.value[i] == eng[j]) {
                    transcriptText += rus[j]
                    break
                } else if (defaultText.value[i] == rus[j]) {
                    transcriptText += eng[j]
                    break
                }
            }
        }
        defaultText.value = transcriptText
    }

    private val clipboard = Toolkit.getDefaultToolkit().systemClipboard
    private val eng =
        "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./~!@#\$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>? –\n"
    private val rus =
        "ё1234567890-=йцукенгшщзхъ\\фывапролджэячсмитьбю.Ё!\"№;%:?*()_+ЙЦУКЕНГШЩЗХЪ/ФЫВАПРОЛДЖЭЯЧСМИТЬБЮ, –\n"

}