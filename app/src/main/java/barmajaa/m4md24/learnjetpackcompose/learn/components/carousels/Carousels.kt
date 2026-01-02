package barmajaa.m4md24.learnjetpackcompose.learn.components.carousels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.R
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

data class CarouselItem(
    val id : Int,
    @param:DrawableRes val imageResId : Int,
    val contentDescription : String
)

fun GetItems() = listOf(
    CarouselItem(0, R.drawable.coffee, "Coffee 1"),
    CarouselItem(1, R.drawable.coffee, "Coffee 2"),
    CarouselItem(2, R.drawable.coffee, "Coffee 3"),
    CarouselItem(3, R.drawable.coffee, "Coffee 4"),
    CarouselItem(4, R.drawable.coffee, "Coffee 5"),
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
            .padding(top = 16.dp, bottom = 16.dp),
        preferredItemWidth = 186.dp,
        itemSpacing = 8.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) { i ->
        val item = items[i]
        Image(
            modifier = Modifier
                .height(205.dp)
                .maskClip(MaterialTheme.shapes.extraLarge),
            painter = painterResource(id = item.imageResId),
            contentDescription = item.contentDescription,
            contentScale = ContentScale.Crop
        )
    }
}