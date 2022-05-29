package components

import com.arkivanov.decompose.ComponentContext

interface ChildComponent : ComponentContext {
    val onBack : () -> Unit
    val onNext : () -> Unit
}