package dev.patogordo.rocketlaunches.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.patogordo.rocketlaunches.R
import dev.patogordo.rocketlaunches.domain.model.Launch
import dev.patogordo.rocketlaunches.presentation._preview.previewLaunchData
import dev.patogordo.rocketlaunches.presentation.ui.theme.Base200
import dev.patogordo.rocketlaunches.presentation.ui.theme.PrimaryDark
import dev.patogordo.rocketlaunches.presentation.ui.theme.RussoOneFontFamily
import dev.patogordo.rocketlaunches.presentation.ui.theme.SecondaryMain

@Composable
fun LaunchListItem(launch: Launch, onItemClick: (Launch) -> Unit) {
  Surface(
    modifier = Modifier
      .fillMaxWidth()
      .shadow(2.dp, RoundedCornerShape(16.dp)),
    shape = RoundedCornerShape(16.dp),
    color = Color.Transparent
  ) {
    Column(modifier = Modifier
      .fillMaxWidth()
      .background(Base200)) {
      Row(
        modifier = Modifier
          .padding(16.dp)
          .background(Color.Transparent),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Surface(shape = RoundedCornerShape(9999.dp), color = PrimaryDark) {
          Box(modifier = Modifier
            .padding(8.dp)
            .background(PrimaryDark)) {
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
            text = launch.name ?: "Could not to load Launch Name",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text =
            "${launch.pad?.name ?: "n/a"}, ${launch.pad?.location?.state ?: "n/a"}, ${launch.pad?.location?.country ?: "n/a"}",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
          )
          Spacer(modifier = Modifier.height(2.dp))
          Text(
            text = "",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
          )
        }
      }
      Image(
        painter = painterResource(id = R.drawable.no_image),
        contentDescription = "'No image' image",
        modifier = Modifier
          .fillMaxWidth()
          .height(200.dp),
        contentScale = ContentScale.Crop
      )
      Spacer(modifier = Modifier.height(4.dp))
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
      ) {
        Text(
          text = "T - 00:00:00:00",
          color = SecondaryMain,
          fontSize = 24.sp,
          fontWeight = FontWeight.Normal,
          fontFamily = RussoOneFontFamily
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "Starlink-122 (7-7)",
          color = Color.White,
          fontSize = 20.sp,
          fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
          text =
          "A SpaceX Falcon 9 rocket will launch the Starlink-122 (7-7) mission on Sunday, November 19, 2023 at 6:55 AM (UTC).",
          color = Color.White,
          fontSize = 16.sp,
          fontWeight = FontWeight.Normal,
        )

        Spacer(modifier = Modifier.height(12.dp))

        IconButton(
          text = "Mission details",
          onClick = {
            onItemClick(launch)
          }
        )
      }
    }
  }
}

@Composable
@Preview
fun PreviewLaunchListItem() {
  LaunchListItem(launch = previewLaunchData, onItemClick = {})
}
