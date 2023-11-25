package dev.patogordo.rocketlaunches.ui.screen.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.patogordo.rocketlaunches.ui.screen.QueryArg
import dev.patogordo.rocketlaunches.ui.screen.Screen
import dev.patogordo.rocketlaunches.ui.theme.Base100
import dev.patogordo.rocketlaunches.ui.theme.Base200
import dev.patogordo.rocketlaunches.ui.theme.Base300
import dev.patogordo.rocketlaunches.ui.theme.BaseAlt
import dev.patogordo.rocketlaunches.ui.theme.RocketLaunchesTheme
import dev.patogordo.rocketlaunches.ui.theme.SecondaryMain


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController?) {
  var textFieldValue by remember {
    mutableStateOf("")
  }

  Column(
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
      .background(Base300)
      .fillMaxSize()
      .padding(horizontal = 32.dp)
  )  {
    OutlinedTextField(
      value = textFieldValue,
      label = {
        Text("Your name")
      },
      onValueChange = {
        textFieldValue = it
      },
      modifier = Modifier
        .fillMaxWidth(),
      colors = TextFieldDefaults.outlinedTextFieldColors(
        containerColor = Base200,
        cursorColor = SecondaryMain,
        focusedBorderColor = SecondaryMain,
        focusedLabelColor = SecondaryMain,
        unfocusedBorderColor = Color.Transparent
      ),
      singleLine = true,
      shape = RoundedCornerShape(8.dp)
    )

    Spacer(modifier = Modifier.height(8.dp))

    Button(
      onClick = {
        navController?.navigate(
          Screen.DetailScreen.withQueryArgs(
            QueryArg("name", textFieldValue)
          )
        )
      },
      modifier = Modifier.align(Alignment.End)
    ) {
      Text(text = "Go to DetailScreen")
    }
  }
}

@Preview
@Composable
fun HomeScreenPreview() {
  HomeScreen(navController = null)
}
