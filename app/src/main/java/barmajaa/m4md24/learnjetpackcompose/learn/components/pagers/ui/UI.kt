package barmajaa.m4md24.learnjetpackcompose.learn.components.pagers.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.pagers.Horizontal
import barmajaa.m4md24.learnjetpackcompose.learn.components.pagers.Infinite
import barmajaa.m4md24.learnjetpackcompose.learn.components.pagers.Peek
import barmajaa.m4md24.learnjetpackcompose.ui.Section

@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
    Box(
        modifier = Modifier.fillMaxSize(),
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

            Section(title = "Horizontal") {
                Horizontal()
            }

            Spacer(modifier = Modifier.height(height))

            Section(title = "Infinite") {
                Infinite()
            }

            Spacer(modifier = Modifier.height(height))

            Section(title = "Peek") {
                Peek()
            }

            Spacer(modifier = Modifier.height(height))
        }
    }
}