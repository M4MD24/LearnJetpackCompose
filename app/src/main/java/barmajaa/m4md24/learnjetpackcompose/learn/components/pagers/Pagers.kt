package barmajaa.m4md24.learnjetpackcompose.learn.components.pagers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import barmajaa.m4md24.learnjetpackcompose.learn.components.pagers.ui.PreviewUI
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

class Pagers : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Horizontal() {
    val pagerState = rememberPagerState(pageCount = { 5 })

    HorizontalPager(
        modifier = Modifier.fillMaxWidth(),
        state = pagerState
    ) { page ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Page $page",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Infinite() {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    val pagerState = rememberPagerState(
        initialPage = Int.MAX_VALUE / 2,
        pageCount = { Int.MAX_VALUE }
    )

    HorizontalPager(state = pagerState) { page ->
        val actualPage = page % items.size
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.tertiaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = items[actualPage],
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Peek() {
    val pagerState = rememberPagerState(pageCount = { 5 })

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 64.dp),
        pageSpacing = 16.dp
    ) { page ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                Text(
                    text = "Page $page",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Scaled() {
    val pagerState = rememberPagerState(pageCount = { 5 })

    HorizontalPager(
        state = pagerState,
        pageSpacing = 16.dp,
        contentPadding = PaddingValues(horizontal = 64.dp)
    ) { page ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .graphicsLayer {
                    val pageOffset = (
                            (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                            ).absoluteValue
                    val scale = lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )

                    scaleX = scale
                    scaleY = scale
                },
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Page $page",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AutoScroll() {
    val pagerState = rememberPagerState(pageCount = { 5 })

    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            val nextPage = (pagerState.currentPage + 1) % 5
            pagerState.animateScrollToPage(nextPage)
        }
    }

    HorizontalPager(state = pagerState) { page ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.tertiaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Page $page (Auto)",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MultiItem() {
    val pagerState = rememberPagerState(pageCount = { 10 })

    HorizontalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(120.dp),
        pageSpacing = 8.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) { page ->
        Card(
            modifier = Modifier
                .width(120.dp)
                .height(160.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Item\n$page",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Fade() {
    val pagerState = rememberPagerState(pageCount = { 5 })

    HorizontalPager(state = pagerState) { page ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
                .graphicsLayer {
                    val pageOffset = (
                            (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                            ).absoluteValue
                    val alpha = lerp(
                        start = 0.3f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                    this.alpha = alpha
                },
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Page $page",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Parallax() {
    val pagerState = rememberPagerState(pageCount = { 5 })

    HorizontalPager(state = pagerState) { page ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                                )
                        translationX = pageOffset * 200f
                    }
            )
            Card(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(32.dp)
                    .size(200.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Page $page",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }
    }
}
@Composable
fun LazyRow() = LazyRow(
    contentPadding = PaddingValues(horizontal = 16.dp),
    horizontalArrangement = Arrangement.spacedBy(12.dp)
) {
    items(10) { index ->
        Card(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Item $index",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Stacked() {
    val pagerState = rememberPagerState(pageCount = { 5 })

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(32.dp)
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                                ).absoluteValue
                        val scale = lerp(0.8f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
                        val translationY = pageOffset * 50f
                        val alpha = lerp(0.5f, 1f, 1f - pageOffset.coerceIn(0f, 1f))
                        scaleX = scale
                        scaleY = scale
                        this.translationY = translationY
                        this.alpha = alpha
                    },
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Card $page",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }
    }
}