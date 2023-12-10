package dev.patogordo.rocketlaunches.presentation.composables

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.OpenInNew
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import dev.patogordo.rocketlaunches.R
import dev.patogordo.rocketlaunches.domain.model.Launch
import dev.patogordo.rocketlaunches.domain.model.NewsArticle
import dev.patogordo.rocketlaunches.presentation._preview.previewLaunchData
import dev.patogordo.rocketlaunches.presentation._preview.previewNewsData
import dev.patogordo.rocketlaunches.presentation.ui.theme.Base100
import dev.patogordo.rocketlaunches.presentation.ui.theme.Base200
import dev.patogordo.rocketlaunches.presentation.ui.theme.InfoMain
import dev.patogordo.rocketlaunches.presentation.ui.theme.PrimaryDark
import dev.patogordo.rocketlaunches.presentation.ui.theme.RussoOneFontFamily
import dev.patogordo.rocketlaunches.presentation.ui.theme.SecondaryMain

@Composable
fun NewsListItem(
  newsArticle: NewsArticle,
  onItemClick: (NewsArticle) -> Unit
) {
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
              imageVector = Icons.Outlined.Newspaper,
              contentDescription = "News Paper Icon",
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
            text = newsArticle.newsSite ?: "Could not to load the News Website name",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
          )
          Spacer(modifier = Modifier.height(4.dp))
          Text(
            text = "11/19/2023, 3:55:00 AM GMT-3",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
          )
        }
      }
      Image(
        painter = if (newsArticle.imageUrl !== null)
          rememberAsyncImagePainter(newsArticle.imageUrl)
        else
          painterResource(id = R.drawable.no_image),
        contentDescription = "'No image' image",
        modifier = Modifier
          .fillMaxWidth()
          .height(200.dp)
          .background(Base100),
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
        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = newsArticle.title ?: "Could not to load the News Article title",
          color = Color.White,
          fontSize = 20.sp,
          fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
          text = newsArticle.summary ?: "Could not to load the News Article description",
          color = Color.White,
          fontSize = 16.sp,
          fontWeight = FontWeight.Normal,
        )

        Spacer(modifier = Modifier.height(12.dp))

        IconButton(
          text = "Know more",
          onClick = {
            onItemClick(newsArticle)
          },
          endIcon = Icons.Outlined.OpenInNew,
          endIconContentDescription = "Open in browser Icon"
        )
      }
    }
  }
}

@Composable
@Preview
fun PreviewNewsListItem() {
  NewsListItem(newsArticle = previewNewsData, onItemClick = {})
}
