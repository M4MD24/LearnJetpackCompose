package barmajaa.m4md24.learnjetpackcompose.learn.components.texts.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.texts.AnnotatedString
import barmajaa.m4md24.learnjetpackcompose.learn.components.texts.Normal
import barmajaa.m4md24.learnjetpackcompose.learn.components.texts.SelectionContainer

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

            Normal()

            Spacer(modifier = Modifier.height(height))

            SelectionContainer()

            Spacer(modifier = Modifier.height(height))

            AnnotatedString()
        }
    }
}