package barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import barmajaa.m4md24.learnjetpackcompose.R
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.ui.PreviewUI
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.ui.theme.Colorful
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.ui.theme.SimpleText

const val TEXT = "Android Apps Developer"
val textColor = Color.White
@Composable
fun GetTextColors() = listOf(
    colorResource(R.color.dark_red),
    colorResource(R.color.firebrick),
    colorResource(R.color.crimson),
    colorResource(R.color.red),
    colorResource(R.color.coral_red),
    colorResource(R.color.light_pink_red)
)

class TextAndTypography : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun SimpleText(
    text : String = "",
    color : Color
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.wrapContentHeight(),
            text = text,
            color = color,
            style = SimpleText.bodyMedium
        )
    }
}