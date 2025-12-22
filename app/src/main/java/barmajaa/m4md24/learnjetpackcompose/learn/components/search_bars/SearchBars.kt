package barmajaa.m4md24.learnjetpackcompose.learn.components.search_bars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.search_bars.ui.PreviewUI

class SearchBars : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarWithSuggestions(
    query : String,
    onQueryChange : (String) -> Unit,
    onSearch : (String) -> Unit,
    placeholder : String = "Search...",
    suggestions : List<String>
) {
    var active by remember { mutableStateOf(false) }

    SearchBar(
        modifier = Modifier.fillMaxWidth(),
        inputField = {
            SearchBarDefaults.InputField(
                query = query,
                onQueryChange = onQueryChange,
                onSearch = {
                    active = false
                    onSearch(it)
                },
                expanded = active,
                onExpandedChange = { active = it },
                placeholder = { Text(placeholder) },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = Icons.Default.Search.name
                    )
                },
                trailingIcon = {
                    if (query.isNotEmpty())
                        IconButton(onClick = { onQueryChange("") }) {
                            Icon(
                                Icons.Default.Clear,
                                contentDescription = Icons.Default.Clear.name
                            )
                        }
                }
            )
        },
        expanded = active,
        onExpandedChange = { active = it }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(suggestions) { suggestion ->
                ListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onQueryChange(suggestion)
                            active = false
                            onSearch(suggestion)
                        },
                    headlineContent = { Text(suggestion) },
                    leadingContent = {
                        Icon(
                            Icons.Default.History,
                            contentDescription = Icons.Default.History.name
                        )
                    }
                )
            }
        }
    }
}