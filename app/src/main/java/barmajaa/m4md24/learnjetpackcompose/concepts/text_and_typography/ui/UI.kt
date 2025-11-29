package barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.ColorfulText
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.GetTextColors
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.SimpleText
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.TEXT
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.textColor

@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ColorfulText(
            TEXT,
            GetTextColors()
        )

        SimpleText(
            TEXT,
            textColor
        )
    }
}