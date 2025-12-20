package barmajaa.m4md24.learnjetpackcompose.learn.components.texts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import barmajaa.m4md24.learnjetpackcompose.learn.components.texts.ui.PreviewUI

const val NAME = "Mohamed Sadawy"
const val TEXT = "Android Apps Developer"

class Texts : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun Normal() = Box(
    modifier = Modifier,
    contentAlignment = Alignment.Center
) {
    Text(text = TEXT)
}
@Composable
fun SelectionContainer() = Box(
    modifier = Modifier,
    contentAlignment = Alignment.Center
) {
    SelectionContainer {
        Column {
            Text(text = TEXT)
            DisableSelection {
                Text(text = TEXT)
            }
        }
    }
}
@Composable
fun AnnotatedString() {
    val uriHandler = LocalUriHandler.current

    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildAnnotatedString {
                val urlText = "https://t.me/m4md24"
                val link = LinkAnnotation.Url(
                    urlText,
                    TextLinkStyles(
                        SpanStyle(
                            color = Color.Red
                        )
                    )
                ) {
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(
                        uri = url
                    )
                }

                withLink(link) {
                    append(
                        text = NAME
                    )
                }

                append(
                    text = " is $TEXT"
                )
            }
        )
    }
}