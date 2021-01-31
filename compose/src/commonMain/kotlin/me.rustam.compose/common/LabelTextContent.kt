package me.rustam.compose.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun LabelText(text: String, label: String) = LabelText(text = text, label = label, position = LabelPosition.Bottom)

@Composable
fun LabelLeftText(text: String, label: String) = LabelText(text = text, label = label, position = LabelPosition.Left)

@Composable
fun LabelText(text: String, label: String, position: LabelPosition) {
   val styledText = applyTextStyle(
      textStyle = MaterialTheme.typography.subtitle1,
      text = { Text(text = text) }
   )
   val styledLabel = applyTextStyle(
      textStyle = MaterialTheme.typography.subtitle2,
      alpha = ContentAlpha.medium,
      text = { Text(text = label) }
   )
   when (position) {
      LabelPosition.Left -> {
         Row(verticalAlignment = Alignment.CenterVertically) {
            styledLabel()
            HorizontalSpacer()
            styledText()
         }
      }
      LabelPosition.Bottom -> {
         Column {
            styledText()
            VerticalSpacer()
            styledLabel()
         }
      }
   }

}

enum class LabelPosition {
   Left,
   Bottom
}