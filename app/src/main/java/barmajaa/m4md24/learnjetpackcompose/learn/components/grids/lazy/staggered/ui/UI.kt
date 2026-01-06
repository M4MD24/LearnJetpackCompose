package barmajaa.m4md24.learnjetpackcompose.learn.components.grids.lazy.staggered.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.grids.lazy.staggered.LazyHorizontalStaggeredGrid
import barmajaa.m4md24.learnjetpackcompose.learn.components.grids.lazy.staggered.LazyVerticalStaggeredGrid

@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val height = 40.dp

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                LazyVerticalStaggeredGrid()
            }

            Spacer(modifier = Modifier.height(height))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                LazyHorizontalStaggeredGrid()
            }
        }
    }
}