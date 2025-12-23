package barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.segments.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.segments.SingleSelectSegment
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
            Section(title = "Single-Select") { SingleSelectSegment() }
        }
    }
}