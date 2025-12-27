package barmajaa.m4md24.learnjetpackcompose.learn.components.time_pickers.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.isPm
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.time_pickers.Normal
import barmajaa.m4md24.learnjetpackcompose.ui.Section
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .systemBarsPadding(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Section(title = "Normal") {
                Normal(
                    {
                        val time = LocalTime.of(
                            it.hour,
                            it.minute
                        )
                        val formatter = DateTimeFormatter.ofPattern("hh:mm a")
                        val formattedTime = time.format(formatter)

                        Toast.makeText(
                            context,
                            "Selected time: $formattedTime",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    {}
                )
            }
        }
    }
}