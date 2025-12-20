package barmajaa.m4md24.learnjetpackcompose.learn.components.pull_to_refresh_boxes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import barmajaa.m4md24.learnjetpackcompose.learn.components.pull_to_refresh_boxes.ui.PreviewUI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PullToRefreshBoxes : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun Normal(
    modifier : Modifier = Modifier,
    items : List<String>,
    onRefresh : () -> Unit
) {
    val scope = rememberCoroutineScope()
    var items by remember {
        mutableStateOf(items)
    }
    var isRefreshing by remember {
        mutableStateOf(false)
    }

    fun RefreshItem() {
        scope.launch {
            isRefreshing = true
            onRefresh()
            delay(2000)
            items = List(30) {
                "Item ${(1 .. 100).random()}"
            }
            isRefreshing = false
        }
    }

    PullToRefreshBox(
        modifier = modifier,
        isRefreshing = isRefreshing,
        onRefresh = { RefreshItem() },
    ) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(items) { item ->
                ListItem(
                    headlineContent = { Text(text = item) }
                )
            }
        }
    }
}