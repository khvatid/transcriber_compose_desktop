package util

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import org.jetbrains.skia.Image
import java.io.File

object IconRes {
    private const val path = "src/jvmMain/resources/icons/"

    @Composable
    fun process(
        tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
        modifier: Modifier = Modifier.size(24.dp),
    ) {
        val iconPath = "ic_process.svg"
        Icon(
            painter = loadSvgPainter(File(path + iconPath), LocalDensity.current),
            contentDescription = "Add",
            modifier = modifier,
            tint = tint
        )
    }
    @Composable
    fun copy(
        tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
        modifier: Modifier = Modifier.size(24.dp),
    ) {
        val iconPath = "ic_copy.svg"
        Icon(
            painter = loadSvgPainter(File(path + iconPath), LocalDensity.current),
            contentDescription = "Copy",
            modifier = modifier,
            tint = tint
        )
    }
    @Composable
    fun paste(
        tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
        modifier: Modifier = Modifier.size(24.dp),
    ) {
        val iconPath = "ic_paste.svg"
        Icon(
            painter = loadSvgPainter(File(path + iconPath), LocalDensity.current),
            contentDescription = "Paste",
            modifier = modifier,
            tint = tint
        )
    }
    @Composable
    fun trash(
        tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
        modifier: Modifier = Modifier.size(24.dp),
    ) {
        val iconPath = "ic_trash.svg"
        Icon(
            painter = loadSvgPainter(File(path + iconPath), LocalDensity.current),
            contentDescription = "trash",
            modifier = modifier,
            tint = tint
        )
    }
    @Composable
    fun moon(
        tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
        modifier: Modifier = Modifier.size(24.dp),
    ) {
        val iconPath = "ic_moon.svg"
        Icon(
            painter = loadSvgPainter(File(path + iconPath), LocalDensity.current),
            contentDescription = "Add",
            modifier = modifier,
            tint = tint
        )
    }
    @Composable
    fun sun(
        tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
        modifier: Modifier = Modifier.size(24.dp),
    ) {
        val iconPath = "ic_sun.svg"
        Icon(
            painter = loadSvgPainter(File(path + iconPath), LocalDensity.current),
            contentDescription = "sun",
            modifier = modifier,
            tint = tint
        )
    }
    @Composable
    fun close(
        tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
        modifier: Modifier = Modifier.size(24.dp),
    ) {
        val iconPath = "ic_close.svg"
        Icon(
            painter = loadSvgPainter(File(path + iconPath), LocalDensity.current),
            contentDescription = "close",
            modifier = modifier,
            tint = tint
        )
    }
    @Composable
    fun settings(
        tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
        modifier: Modifier = Modifier.size(24.dp),
    ) {
        val iconPath = "ic_settings.svg"
        Icon(
            painter = loadSvgPainter(File(path + iconPath), LocalDensity.current),
            contentDescription = "settings",
            modifier = modifier,
            tint = tint
        )
    }

    @Composable
    fun back(
        tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
        modifier: Modifier = Modifier.size(24.dp),
    ) {
        val iconPath = "ic_back.svg"
        Icon(
            painter = loadSvgPainter(File(path + iconPath), LocalDensity.current),
            contentDescription = "back arrow",
            modifier = modifier,
            tint = tint
        )
    }


    private fun loadSvgPainter(file: File, density: Density): Painter =
        file.inputStream().buffered().use { androidx.compose.ui.res.loadSvgPainter(it, density) }
}