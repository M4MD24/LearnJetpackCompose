package barmajaa.m4md24.learnjetpackcompose.learn.animations.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.animations.InfiniteRepeatable
import barmajaa.m4md24.learnjetpackcompose.learn.animations.Spring
import barmajaa.m4md24.learnjetpackcompose.ui.Section

@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
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
            val height = 40.dp

            Section(title = "InfiniteRepeatable") {
                Box(modifier = Modifier.padding(20.dp)) {
                    InfiniteRepeatable()
                }
            }

            Spacer(modifier = Modifier.height(height))

            Section(title = "Spring") {
                Box(modifier = Modifier.padding(20.dp)) {
                    Spring()
                }
            }
        }
    }
}