package dev.patogordo.rocketlaunches.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.patogordo.rocketlaunches.presentation.ui.theme.InfoMain

@Composable
fun IconButton(
  text: String = "Know more",
  onClick: () -> Unit = {},
  color: Color = InfoMain,
  startIcon: ImageVector = Icons.Outlined.Info,
  startIconContentDescription: String = "Info icon",
  endIcon: ImageVector = Icons.Outlined.ChevronRight,
  endIconContentDescription: String = "Next page icon",
  startIconColor: Color = Color.White,
  endIconColor: Color = Color.White,
  showStartIcon: Boolean = true,
  showEndIcon: Boolean = true,
) {
  Surface(
    shape = RoundedCornerShape(8.dp),
    color = color,
    modifier = Modifier
      .fillMaxWidth()
      .clickable {
        onClick()
      }
      .shadow(2.dp, RoundedCornerShape(8.dp)),
  ) {
    val finalText = text.uppercase()

    Row(
      modifier =
      Modifier
        .fillMaxWidth()
        .padding(
          horizontal = 16.dp,
          vertical = 12.dp
        ),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      if (showStartIcon) {
        Icon(
          imageVector = startIcon,
          contentDescription = startIconContentDescription,
          tint = startIconColor,
          modifier = Modifier.size(24.dp)
        )
      }

      Text(
        text = finalText,
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center,
      )

      if (showEndIcon) {
        Icon(
          imageVector = endIcon,
          contentDescription = endIconContentDescription,
          tint = endIconColor,
          modifier = Modifier.size(24.dp)
        )
      }
    }
  }
}

@Preview
@Composable
fun PreviewIconButton() {
  IconButton()
}
