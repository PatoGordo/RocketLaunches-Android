package dev.patogordo.rocketlaunches.presentation.screen.news_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.patogordo.rocketlaunches.R
import dev.patogordo.rocketlaunches.presentation.composables.BottomNavigationBar
import dev.patogordo.rocketlaunches.presentation.composables.Loading
import dev.patogordo.rocketlaunches.presentation.composables.NewsListItem
import dev.patogordo.rocketlaunches.presentation.screen.Screen
import dev.patogordo.rocketlaunches.presentation.screen.news_screen.states.NewsListState
import dev.patogordo.rocketlaunches.presentation.ui.theme.ErrorMain

@Composable
fun NewsScreen(
  navController: NavController = rememberNavController(),
  state: State<NewsListState>,
  openURLInBrowser: (uri: String) -> Unit
) {
  val state = state.value

  if (state.isLoading) {
    Loading("Loading news...")
  }

  BottomNavigationBar(
    navController = navController,
    activeItem = Screen.NewsScreen,
  ) {
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 24.dp)
    ) {
      item {
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

        Spacer(modifier = Modifier.height(24.dp))

        Text(
          text = "   Latest News   ",
          color = Color.White,
          fontSize = 24.sp,
          fontWeight = FontWeight.Bold,
          textAlign = TextAlign.Center,
          modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(24.dp))
      }

      items(state.news) { newsArticle ->
        NewsListItem(
          newsArticle = newsArticle,
          onItemClick = {
            openURLInBrowser(it.url ?: "https://rocketlaunches.app")
          }
        )

        Spacer(modifier = Modifier.height(16.dp))
      }

      item {
        if (state.error.isNotBlank()) {
          Text(
            text = state.error,
            color = ErrorMain,
            textAlign = TextAlign.Center,
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 16.dp)
          )
        }

        Spacer(modifier = Modifier.height(it))
      }
    }
  }
}
