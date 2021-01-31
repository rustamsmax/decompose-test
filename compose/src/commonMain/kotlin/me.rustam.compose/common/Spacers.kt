package me.rustam.compose.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val defaultSpace = 4.dp

@Composable
fun VerticalSpacer(height: Dp = defaultSpace) {
   Spacer(modifier = Modifier.height(height))
}

@Composable
fun HorizontalSpacer(width: Dp = defaultSpace){
   Spacer(modifier = Modifier.width(width))
}