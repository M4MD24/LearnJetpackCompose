package barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.ui

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
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.ColorfulText
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.EllipsisText
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.GetTextColors
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.LONG_TEXT
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.ScrollableText
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.SimpleText
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.NORMAL_TEXT
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.textColor

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val height = 40.dp

            SimpleText(
                NORMAL_TEXT,
                textColor
            )

            Spacer(modifier = Modifier.height(height))

            ColorfulText(
                NORMAL_TEXT,
                GetTextColors()
            )

            Spacer(modifier = Modifier.height(height))

            ScrollableText(
                LONG_TEXT,
                textColor
            )

            Spacer(modifier = Modifier.height(height))

            EllipsisText(
                LONG_TEXT,
                textColor
            )
        }
    }
}