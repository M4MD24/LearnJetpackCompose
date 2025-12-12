package barmajaa.m4md24.learnjetpackcompose.concepts.cards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.concepts.cards.ui.PreviewUI

class Cards : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}

val width = 200.dp
@Composable
fun Elevated() = ElevatedCard(
    modifier = Modifier
        .width(width = width),
    elevation = CardDefaults.cardElevation(
        defaultElevation = 14.dp
    )
) {
    Text(
        modifier = Modifier
            .width(width = width)
            .padding(10.dp),
        textAlign = TextAlign.Center,
        text = "Hello"
    )
}