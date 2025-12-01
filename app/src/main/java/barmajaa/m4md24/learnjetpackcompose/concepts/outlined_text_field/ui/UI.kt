package barmajaa.m4md24.learnjetpackcompose.concepts.outlined_text_field.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.concepts.outlined_text_field.WithRemember
import barmajaa.m4md24.learnjetpackcompose.concepts.outlined_text_field.WithRememberSaveable

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

            WithRemember()

            Spacer(modifier = Modifier.height(height))

            WithRememberSaveable()
        }
    }
}