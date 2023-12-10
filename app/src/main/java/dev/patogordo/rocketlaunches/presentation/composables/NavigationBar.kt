package dev.patogordo.rocketlaunches.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import dev.patogordo.rocketlaunches.presentation.screen.Screen
import dev.patogordo.rocketlaunches.presentation.screen.bottomNavigationBarItems
import dev.patogordo.rocketlaunches.presentation.ui.theme.BaseAlt
import dev.patogordo.rocketlaunches.presentation.ui.theme.SecondaryMain

@Composable
fun BottomNavigationBar(
  navController: NavController,
  activeItem: Screen,
  content: @Composable (paddingBottom: Dp) -> Unit,
) {
  Scaffold(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Transparent),
    bottomBar = {
      Surface (
        modifier = Modifier
          .fillMaxWidth()
          .padding(32.dp)
          .background(Color.Transparent)
          .zIndex(999f),
        color = Color.Transparent
      ) {
        Surface (
          shape = RoundedCornerShape(9999.dp),
          modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(Color.Transparent),
          color = Color.Transparent
        ) {
          Row (
            modifier = Modifier
              .fillMaxWidth()
              .fillMaxHeight()
              .background(BaseAlt),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
          ) {
            bottomNavigationBarItems.forEach { item ->
              Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                  .fillMaxSize()
                  .weight(1f)
                  .clickable {
                    navController.navigate(item.route)
                  }
              ) {
                val isCurrentRoute = activeItem.route == item.route

                Icon(
                  imageVector = if (isCurrentRoute)
                    item.activeIcon
                  else
                    item.defaultIcon,
                  contentDescription = "${item.title} page Icon",
                  modifier = Modifier
                    .size(24.dp),
                  tint = if (isCurrentRoute)
                    SecondaryMain
                  else
                    Color.White
                )

                Text(
                  text = item.title,
                  fontSize = 10.sp,
                  color = if (isCurrentRoute)
                    SecondaryMain
                  else
                    Color.White
                )
              }
            }
          }
        }
      }
    },
  ) { paddingValues ->
    Column (
      modifier = Modifier.fillMaxSize()
    ) {
      val paddingBottom = paddingValues.calculateBottomPadding()

      content(
        paddingBottom
      )
    }
  }
}

@Preview
@Composable
fun PreviewNavigationBar() {
  Surface (
    modifier = Modifier
      .fillMaxSize()
      .padding(24.dp)
  ) {
    NavigationBar {}
  }
}
