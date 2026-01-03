package barmajaa.m4md24.learnjetpackcompose.learn.components.pagers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.pagers.ui.PreviewUI

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