package barmajaa.m4md24.learnjetpackcompose.concepts.layouts

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
import barmajaa.m4md24.learnjetpackcompose.concepts.layouts.ui.PreviewUI

class Layouts : ComponentActivity() {
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
val space = 10.dp
@Composable
fun Column() = Column(
    modifier = Modifier
        .padding(margin)/*padding*/
        .background(Color.Red)
        .padding(padding)/*margin*/,
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(space)
) {
    Text("First")
    Text("Second")
    Text("Third")
}
@Composable
fun Row() = Row(
    modifier = Modifier
        .padding(margin)/*padding*/
        .background(Color.Green)
        .padding(padding)/*margin*/,
    horizontalArrangement = Arrangement.spacedBy(space),
    verticalAlignment = Alignment.CenterVertically
) {
    Text("First")
    Text("Second")
    Text("Third")
}