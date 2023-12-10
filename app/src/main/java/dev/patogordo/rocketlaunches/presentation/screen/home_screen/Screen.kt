package dev.patogordo.rocketlaunches.presentation.screen.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.patogordo.rocketlaunches.R
import dev.patogordo.rocketlaunches.presentation.composables.BottomNavigationBar
import dev.patogordo.rocketlaunches.presentation.composables.LaunchListItem
import dev.patogordo.rocketlaunches.presentation.composables.Loading
import dev.patogordo.rocketlaunches.presentation.composables.NewsListItem
import dev.patogordo.rocketlaunches.presentation.screen.Screen
import dev.patogordo.rocketlaunches.presentation.ui.theme.Base300
import dev.patogordo.rocketlaunches.presentation.ui.theme.ErrorMain

@Composable
fun HomeScreen(
  navController: NavController? = null,
  viewModel: HomeViewModel = hiltViewModel()
) {
  val launchState = viewModel.launchState.value
  val newsState = viewModel.newsState.value

  if (launchState.isLoading || newsState.isLoading ) {
    Loading("Loading...")
  }

  BottomNavigationBar(
    navController = navController ?: rememberNavController(),
    activeItem = Screen.HomeScreen,
  ) {
    Column(
      modifier = Modifier
        .background(Base300)
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    )  {
      Spacer(modifier = Modifier.height(24.dp))

      Image(
        painter = painterResource(
          id = R.drawable.rocketlaunches_logo_landscape
        ),
        contentDescription = "Rocket Launches Logo",
        modifier = Modifier
          .fillMaxWidth()
          .height(45.dp),
      )

      Column (
        modifier = Modifier
          .fillMaxWidth()
          .padding(24.dp)
      ) {
        Text(
          text = "   Next Launch   ",
          color = Color.White,
          fontSize = 24.sp,
          fontWeight = FontWeight.Bold,
          textAlign = TextAlign.Center,
          modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (launchState.launches.isNotEmpty()) {
          LaunchListItem(
            launch = launchState.launches.first(),
            onItemClick = {
              navController?.navigate(
                Screen.LaunchDetailScreen.withPositionalArgs(
                  launchState.launches.first().id.toString()
                )
              )
            }
          )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
          text = "   Breaking News   ",
          color = Color.White,
          fontSize = 24.sp,
          fontWeight = FontWeight.Bold,
          textAlign = TextAlign.Center,
          modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (newsState.news.isNotEmpty()) {
          NewsListItem(
            newsArticle = newsState.news.first(),
            onItemClick = { newsArticle ->
              viewModel.openURLInBrowser(newsArticle.url)
            }
          )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (launchState.error.isNotBlank()) {
          Text(
            text = launchState.error,
            color = ErrorMain,
            textAlign = TextAlign.Center,
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 16.dp)
              .align(Alignment.CenterHorizontally)
          )
        }

        if (newsState.error.isNotBlank()) {
          Text(
            text = newsState.error,
            color = ErrorMain,
            textAlign = TextAlign.Center,
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 16.dp)
              .align(Alignment.CenterHorizontally)
          )
        }
      }

      Spacer(modifier = Modifier.height(it))
    }
  }
}

