package barmajaa.m4md24.learnjetpackcompose.learn.components.carousels.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.carousels.HorizontalMultiBrowse
import barmajaa.m4md24.learnjetpackcompose.learn.components.carousels.HorizontalUncontained
import barmajaa.m4md24.learnjetpackcompose.ui.Section

@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .systemBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val height = 40.dp

            Section(title = "HorizontalMultiBrowse") {
                HorizontalMultiBrowse()
            }

            Spacer(modifier = Modifier.height(height))

            Section(title = "HorizontalUncontained") {
                HorizontalUncontained()
            }
        }
    }
}