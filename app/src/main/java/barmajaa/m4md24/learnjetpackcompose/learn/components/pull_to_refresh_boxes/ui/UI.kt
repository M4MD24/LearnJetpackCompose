package barmajaa.m4md24.learnjetpackcompose.learn.components.pull_to_refresh_boxes.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.DURATION_TOAST
import barmajaa.m4md24.learnjetpackcompose.learn.components.pull_to_refresh_boxes.Normal

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
                .wrapContentSize(),
            verticalArrangement = Arrangement.Center
        ) {
            var items by remember {
                mutableStateOf(List(30) {
                    "Item ${it + 1}"
                })
            }
            Normal(
                modifier = Modifier,
                items = items,
                onRefresh = {
                    Toast.makeText(
                        context,
                        "Refreshing",
                        DURATION_TOAST
                    ).show()
                }
            )
        }
    }
}