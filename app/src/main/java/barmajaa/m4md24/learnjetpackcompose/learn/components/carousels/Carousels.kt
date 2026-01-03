package barmajaa.m4md24.learnjetpackcompose.learn.components.carousels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.carousels.ui.PreviewUI

class Carousels : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}

fun GetItems() = listOf(
    Icons.Default.LooksOne,
    Icons.Default.LooksTwo,
    Icons.Default.Looks3,
    Icons.Default.Looks4,
    Icons.Default.Looks5,
    Icons.Default.Looks6
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalMultiBrowse() {
    val items = remember {
        GetItems()
    }

    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { items.count() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 16.dp),
        preferredItemWidth = 180.dp,
        itemSpacing = 8.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) { index ->
        val item = items[index]
        Image(
            modifier = Modifier
                .height(180.dp)
                .maskClip(MaterialTheme.shapes.extraLarge),
            imageVector = item,
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalUncontained() {
    val items = remember {
        GetItems()
    }

    HorizontalUncontainedCarousel(
        state = rememberCarouselState { items.count() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 16.dp),
        itemWidth = 180.dp,
        itemSpacing = 8.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) { index ->
        val item = items[index]
        Image(
            modifier = Modifier
                .height(180.dp)
                .maskClip(MaterialTheme.shapes.extraLarge),
            imageVector = item,
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )
    }
}