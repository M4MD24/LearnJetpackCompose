package barmajaa.m4md24.learnjetpackcompose.learn.components.column_and_row_types.normal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.column_and_row_types.normal.ui.PreviewUI

class Normal : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}

val margin = 5.dp
val padding = 40.dp
val spaceBetween = 10.dp
@Composable
private fun Texts() {
    Text("First")
    Text("Second")
    Text("Third")
}
@Composable
fun NormalColumn() = Column(
    modifier = Modifier
        .padding(margin)/*padding*/
        .background(Color.Red)
        .padding(padding)/*margin*/,
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(spaceBetween)
) {
    Texts()
}
@Composable
fun NormalRow() = Row(
    modifier = Modifier
        .padding(margin)/*padding*/
        .background(Color.Green)
        .padding(padding)/*margin*/,
    horizontalArrangement = Arrangement.spacedBy(spaceBetween),
    verticalAlignment = Alignment.CenterVertically
) {
    Texts()
}