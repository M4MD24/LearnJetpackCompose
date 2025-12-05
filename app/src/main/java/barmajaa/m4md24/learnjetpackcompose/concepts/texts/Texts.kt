package barmajaa.m4md24.learnjetpackcompose.concepts.texts

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
import barmajaa.m4md24.learnjetpackcompose.concepts.texts.ui.PreviewUI

const val TEXT = "I'm Android Apps Developer"

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
fun Normal() {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text = TEXT)
    }
}
@Composable
fun SelectionContainer() {
    Box(
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
}