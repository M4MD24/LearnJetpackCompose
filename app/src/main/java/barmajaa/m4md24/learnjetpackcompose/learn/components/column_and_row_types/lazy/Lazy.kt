package barmajaa.m4md24.learnjetpackcompose.learn.components.column_and_row_types.lazy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.column_and_row_types.lazy.ui.PreviewUI

class Lazy : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun LazyColumn() = LazyColumn(
    modifier = Modifier
) {
    items(100) { index ->
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .background(Color.Gray)
                .padding(16.dp),
            textAlign = TextAlign.Center,
            text = "${index + 1}"
        )
    }
}
@Composable
fun LazyRow() = LazyRow(
    modifier = Modifier
) {
    items(100) { index ->
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .background(Color.Gray)
                .padding(16.dp),
            textAlign = TextAlign.Center,
            text = "${index + 1}"
        )
    }
}