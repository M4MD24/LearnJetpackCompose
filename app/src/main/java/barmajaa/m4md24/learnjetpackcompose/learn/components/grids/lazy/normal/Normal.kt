package barmajaa.m4md24.learnjetpackcompose.learn.components.grids.lazy.normal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.grids.lazy.normal.ui.PreviewUI

class Normal : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun LazyVerticalGrid() = LazyVerticalGrid(
    modifier = Modifier,
    columns = GridCells.Fixed(count = 6)
) {
    items(60) { index ->
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .padding(4.dp)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${index + 1}",
                textAlign = TextAlign.Center
            )
        }
    }
}
@Composable
fun LazyHorizontalGrid() = LazyHorizontalGrid(
    modifier = Modifier,
    rows = GridCells.Fixed(count = 6)
) {
    items(60) { index ->
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .padding(4.dp)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${index + 1}",
                textAlign = TextAlign.Center
            )
        }
    }
}