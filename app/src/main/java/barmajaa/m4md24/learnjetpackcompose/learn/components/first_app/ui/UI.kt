package barmajaa.m4md24.learnjetpackcompose.learn.components.first_app.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import barmajaa.m4md24.learnjetpackcompose.learn.components.first_app.GREETING_NAME
import barmajaa.m4md24.learnjetpackcompose.learn.components.first_app.Greeting

@Composable
@Preview(showBackground = true)
private fun PreviewGreeting() = Greeting(name = GREETING_NAME)
@Composable
@Preview(showSystemUi = true)
private fun PreviewUI() {
    Greeting(name = GREETING_NAME)
}