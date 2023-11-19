package dev.patogordo.rocketlaunches.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.patogordo.rocketlaunches.ui.navigation.QueryArg
import dev.patogordo.rocketlaunches.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
  var textFieldValue by remember {
    mutableStateOf("")
  }

  Column(
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 32.dp)
  ) {
    TextField(
      value = textFieldValue,
      onValueChange = {
        textFieldValue = it
      },
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(8.dp))

    Button(
      onClick = {
        navController.navigate(
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
