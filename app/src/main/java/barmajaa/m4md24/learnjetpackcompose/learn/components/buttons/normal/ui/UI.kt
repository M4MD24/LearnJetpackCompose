package barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.normal.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.normal.Elevated
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.normal.Filled
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.normal.FilledTonal
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.normal.Icon
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.normal.Outlined
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.normal.Text

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
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val height = 40.dp

            Filled()

            Spacer(modifier = Modifier.height(height))

            FilledTonal()

            Spacer(modifier = Modifier.height(height))

            Outlined()

            Spacer(modifier = Modifier.height(height))

            Elevated()

            Spacer(modifier = Modifier.height(height))

            Text()

            Spacer(modifier = Modifier.height(height))

            Icon()
        }
    }
}