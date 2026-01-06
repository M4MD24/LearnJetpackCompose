package barmajaa.m4md24.learnjetpackcompose.learn.components.grids.lazy.staggered

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.grids.lazy.normal.ui.PreviewUI

class Staggered : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun LazyVerticalStaggeredGrid() = LazyVerticalStaggeredGrid(
    modifier = Modifier,
    columns = StaggeredGridCells.Fixed(count = 5)
) {
    items(40) { index ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((60 .. 180).random().dp)
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