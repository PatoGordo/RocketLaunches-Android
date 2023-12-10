package dev.patogordo.rocketlaunches.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import dev.patogordo.rocketlaunches.R
import dev.patogordo.rocketlaunches.presentation.ui.theme.Base300
import dev.patogordo.rocketlaunches.presentation.ui.theme.PrimaryMain
import dev.patogordo.rocketlaunches.presentation.ui.theme.SecondaryDark

@Composable
fun Loading(
  hint: String = "Launching..."
) {
  Column (
    modifier = Modifier
      .fillMaxSize()
      .background(Base300)
      .offset(0.dp, 0.dp)
      .zIndex(1000f),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    val composition by rememberLottieComposition(
      LottieCompositionSpec.RawRes(R.raw.loading)
    )

    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(Base300)
        .padding(16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      LottieAnimation(
        composition,
        modifier = Modifier
          .width(120.dp)
          .align(Alignment.CenterHorizontally)
          .height(120.dp),
        iterations = LottieConstants.IterateForever,
      )

      Spacer(modifier = Modifier.height(16.dp))

      Text(
        text = hint,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = SecondaryDark
      )
    }

  }
}

@Preview
@Composable
fun PreviewLoading() {
  Box(
    modifier = Modifier
      .fillMaxSize()
  ) {
    Loading()
  }
}