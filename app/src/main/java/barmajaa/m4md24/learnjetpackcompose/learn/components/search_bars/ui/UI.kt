package barmajaa.m4md24.learnjetpackcompose.learn.components.search_bars.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.search_bars.SearchBarWithSuggestions

@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }
    val allSuggestions = listOf(
        "Jetpack Compose",
        "Kotlin Coroutines",
        "Android Studio",
        "Material Design",
        "Compose Navigation",
        "State Management",
        "LazyColumn",
        "Remember"
    )
    val filteredSuggestions = if (searchQuery.isEmpty())
        allSuggestions
    else
        allSuggestions.filter {
            it.contains(
                searchQuery,
                ignoreCase = true
            )
        }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            SearchBarWithSuggestions(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = {
                    Toast.makeText(
                        context,
                        it,
                        Toast.LENGTH_SHORT
                    ).show()
                },
                suggestions = filteredSuggestions
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (searchQuery.isNotEmpty())
                Text(
                    text = "Current query: $searchQuery",
                    style = MaterialTheme.typography.bodyLarge
                )
        }
    }
}