package me.rustam.compose.common

import androidx.compose.material.AmbientContentAlpha
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.text.TextStyle


@Composable
fun applyTextStyle(
    textStyle: TextStyle,
    alpha: Float = ContentAlpha.high,
    text: @Composable () -> Unit
): @Composable () -> Unit {
    return (@Composable {
        Providers(AmbientContentAlpha provides alpha) {
            ProvideTextStyle(textStyle, text)
        }
    })
}

