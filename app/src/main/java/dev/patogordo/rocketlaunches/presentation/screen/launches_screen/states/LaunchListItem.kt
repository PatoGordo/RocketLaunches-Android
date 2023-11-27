package dev.patogordo.rocketlaunches.presentation.screen.launches_screen.states

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.patogordo.rocketlaunches.domain.model.Launch
import dev.patogordo.rocketlaunches.presentation.screen.launches_screen._preview.previewLaunchData
import dev.patogordo.rocketlaunches.presentation.ui.theme.Base200
import dev.patogordo.rocketlaunches.presentation.ui.theme.PrimaryDark

@Composable
fun LaunchListItem(
  launch: Launch,
  onItemClick: (Launch) -> Unit
) {
  Surface(
    modifier = Modifier
      .fillMaxWidth(),
    shape = RoundedCornerShape(16.dp),
    color = Color.Transparent
  ) {
    Column (
      modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(launch) }
        .background(Base200)
    ) {
      Row (
        modifier = Modifier
          .padding(16.dp)
          .background(Color.Transparent),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Surface (
          shape = RoundedCornerShape(9999.dp),
          color = PrimaryDark
        ) {
          Box(
            modifier = Modifier
              .padding(8.dp)
              .background(PrimaryDark)
          ) {
            Icon(
              imageVector = Icons.Default.RocketLaunch,
              contentDescription = "Rocket Launch Icon",
              tint = Color.White,
              modifier = Modifier.size(38.dp)
            )
          }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.Start
        ) {
          Text(
            text = launch?.name ?: "Could not to load Launch Name",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "${launch?.pad?.name ?: "n/a"}, ${launch.pad?.location?.state ?: "n/a"}, ${launch?.pad?.location?.country ?: "n/a"}",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
          )
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = "11/19/2023, 3:55:00 AM GMT-3",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
          )
        }
      }
    }
  }
}

@Composable
@Preview
fun PreviewLaunchListItem() {
  LaunchListItem(launch = previewLaunchData, onItemClick = {})
}