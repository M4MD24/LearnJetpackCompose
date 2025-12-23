package barmajaa.m4md24.learnjetpackcompose.ui

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.R
import barmajaa.m4md24.learnjetpackcompose.learn.components.search_bars.SearchBars
import barmajaa.m4md24.learnjetpackcompose.learn.components.cards.Cards
import barmajaa.m4md24.learnjetpackcompose.learn.components.checkboxes.Checkboxes
import barmajaa.m4md24.learnjetpackcompose.learn.components.chips.Chips
import barmajaa.m4md24.learnjetpackcompose.learn.components.column_and_row_types.lazy.Lazy
import barmajaa.m4md24.learnjetpackcompose.learn.components.dialogs.Dialogs
import barmajaa.m4md24.learnjetpackcompose.learn.components.fields.Fields
import barmajaa.m4md24.learnjetpackcompose.learn.components.first_app.FirstApp
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.floating_action_buttons.FloatingActionButtons
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.segments.Segments
import barmajaa.m4md24.learnjetpackcompose.learn.components.images.Images
import barmajaa.m4md24.learnjetpackcompose.learn.components.layouts.Layouts
import barmajaa.m4md24.learnjetpackcompose.learn.components.menus.Menus
import barmajaa.m4md24.learnjetpackcompose.learn.components.modal_bottom_sheets.ModalBottomSheets
import barmajaa.m4md24.learnjetpackcompose.learn.components.navigation_drawers.NavigationDrawers
import barmajaa.m4md24.learnjetpackcompose.learn.components.progress_indicators.ProgressIndicators
import barmajaa.m4md24.learnjetpackcompose.learn.components.pull_to_refresh_boxes.PullToRefreshBoxes
import barmajaa.m4md24.learnjetpackcompose.learn.components.resource_access.ResourceAccess
import barmajaa.m4md24.learnjetpackcompose.learn.components.scaffolds.Scaffolds
import barmajaa.m4md24.learnjetpackcompose.learn.components.sliders.Sliders
import barmajaa.m4md24.learnjetpackcompose.learn.components.snack_bars.SnackBars
import barmajaa.m4md24.learnjetpackcompose.learn.components.text_and_typography.TextAndTypography
import barmajaa.m4md24.learnjetpackcompose.learn.components.texts.Texts
import kotlin.text.contains

sealed class ConceptItem {
    data class Single(
        val nameID : Int,
        val icon : ImageVector,
        val activityClass : Class<*>
    ) : ConceptItem()

    data class Group(
        val nameID : Int,
        val icon : ImageVector,
        val items : List<Single>
    ) : ConceptItem()

    data class GroupGroup(
        val nameID : Int,
        val icon : ImageVector,
        val items : List<ConceptItem>
    ) : ConceptItem()
}
@Composable
private fun getConceptItems() : List<ConceptItem.GroupGroup> {
    val learnConceptItems = listOf(
        ConceptItem.Single(R.string.title_activity_first_app, Icons.Default.Home, FirstApp::class.java),
        ConceptItem.Single(R.string.title_activity_resource_access, Icons.Default.Folder, ResourceAccess::class.java),
        ConceptItem.Single(R.string.title_activity_text_and_typography, Icons.Default.TextFields, TextAndTypography::class.java),
        ConceptItem.Single(R.string.title_activity_fields, Icons.Default.Edit, Fields::class.java),
        ConceptItem.Single(R.string.title_activity_texts, Icons.AutoMirrored.Filled.Article, Texts::class.java),
        ConceptItem.Group(
            R.string.title_concept_buttons,
            Icons.Default.TouchApp,
            listOf(
                ConceptItem.Single(R.string.title_activity_normal, Icons.Default.TouchApp, barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.normal.Normal::class.java),
                ConceptItem.Single(R.string.title_activity_floating_action_buttons, Icons.Default.TouchApp, FloatingActionButtons::class.java),
                ConceptItem.Single(R.string.title_activity_segments, Icons.Default.TouchApp, Segments::class.java)
            )
        ),
        ConceptItem.Single(R.string.title_activity_images, Icons.Default.Image, Images::class.java),
        ConceptItem.Single(R.string.title_activity_layouts, Icons.AutoMirrored.Filled.ViewQuilt, Layouts::class.java),
        ConceptItem.Group(
            R.string.title_concept_column_and_row_types,
            Icons.Default.ViewColumn,
            listOf(
                ConceptItem.Single(R.string.title_activity_normal, Icons.Default.CropSquare, barmajaa.m4md24.learnjetpackcompose.learn.components.column_and_row_types.normal.Normal::class.java),
                ConceptItem.Single(R.string.title_activity_lazy, Icons.AutoMirrored.Filled.List, Lazy::class.java)
            )
        ),
        ConceptItem.Single(R.string.title_activity_modal_bottom_sheets, Icons.Default.SwipeUp, ModalBottomSheets::class.java),
        ConceptItem.Single(R.string.title_activity_cards, Icons.Default.CreditCard, Cards::class.java),
        ConceptItem.Single(R.string.title_activity_checkboxes, Icons.Default.CheckBox, Checkboxes::class.java),
        ConceptItem.Single(R.string.title_activity_chips, Icons.AutoMirrored.Filled.Label, Chips::class.java),
        ConceptItem.Single(R.string.title_activity_dialogs, Icons.AutoMirrored.Filled.Chat, Dialogs::class.java),
        ConceptItem.Single(R.string.title_activity_menus, Icons.Default.MoreVert, Menus::class.java),
        ConceptItem.Single(R.string.title_activity_scaffolds, Icons.Default.Dashboard, Scaffolds::class.java),
        ConceptItem.Single(R.string.title_activity_navigation_drawers, Icons.Default.Menu, NavigationDrawers::class.java),
        ConceptItem.Single(R.string.title_activity_progress_indicators, Icons.Default.Refresh, ProgressIndicators::class.java),
        ConceptItem.Single(R.string.title_activity_pull_to_refresh_boxes, Icons.Default.ArrowDownward, PullToRefreshBoxes::class.java),
        ConceptItem.Single(R.string.title_activity_search_bars, Icons.Default.Search, SearchBars::class.java),
        ConceptItem.Single(R.string.title_activity_sliders, Icons.Default.LinearScale, Sliders::class.java),
        ConceptItem.Single(R.string.title_activity_snack_bars, Icons.Default.HorizontalRule, SnackBars::class.java)
    )
    val developConceptItems : List<ConceptItem> = emptyList()

    return listOf(
        ConceptItem.GroupGroup(
            nameID = R.string.title_concept_learn,
            icon = Icons.Default.Biotech,
            items = learnConceptItems
        ),
        ConceptItem.GroupGroup(
            nameID = R.string.title_concept_develop,
            icon = Icons.Default.DeveloperMode,
            items = developConceptItems
        )
    )
}
@Preview(
    name = "Dark Mode",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Light Mode",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PreviewUI() {
    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }
    val originalConceptItems = getConceptItems()
    val currentConceptItems = remember(
        searchQuery,
        originalConceptItems
    ) {
        if (searchQuery.isEmpty())
            originalConceptItems
        else
            FilterConceptItems(
                context,
                searchQuery,
                originalConceptItems
            )
    }
    val suggestions = remember(originalConceptItems) {
        GetAllConceptNames(
            context,
            originalConceptItems
        )
    }

    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                SearchBar(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it },
                    onSearch = { searchQuery = it },
                    suggestions = suggestions
                )

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 16.dp)
                ) {
                    items(currentConceptItems) { item ->
                        CardGroupGroup(
                            context = context,
                            item = item,
                            elevation = 10.dp
                        )
                    }
                }
            }
        }
    }
}

private fun FilterConceptItems(
    context : Context,
    query : String,
    items : List<ConceptItem.GroupGroup>
) : List<ConceptItem.GroupGroup> = items.mapNotNull { groupGroup ->
    val groupGroupName = context.getString(groupGroup.nameID)
    val matchesGroupGroupName = groupGroupName.contains(
        query,
        ignoreCase = true
    )
    val filteredItems = FilterItems(
        context,
        query,
        groupGroup.items
    )
    if (matchesGroupGroupName)
        groupGroup
    else if (filteredItems.isNotEmpty())
        groupGroup.copy(items = filteredItems)
    else
        null
}

private fun FilterItems(
    context : Context,
    query : String,
    items : List<ConceptItem>
) : List<ConceptItem> = items.mapNotNull { item ->
    when (item) {
        is ConceptItem.Single     -> {
            if (context.getString(item.nameID).contains(query, ignoreCase = true))
                item
            else
                null
        }

        is ConceptItem.Group      -> {
            val filteredSubItems = item.items.filter {
                context.getString(it.nameID).contains(query, ignoreCase = true)
            }
            if (filteredSubItems.isNotEmpty())
                item.copy(items = filteredSubItems)
            else if (context.getString(item.nameID).contains(query, ignoreCase = true))
                item
            else
                null
        }

        is ConceptItem.GroupGroup -> {
            val filteredSubItems = FilterItems(
                context,
                query,
                item.items
            )
            if (filteredSubItems.isNotEmpty())
                item.copy(items = filteredSubItems)
            else if (
                context
                    .getString(item.nameID)
                    .contains(
                        query,
                        ignoreCase = true
                    )
            )
                item
            else
                null
        }
    }
}

private fun GetAllConceptNames(
    context : Context,
    items : List<ConceptItem.GroupGroup>
) : List<String> {
    val names = mutableListOf<String>()
    items.forEach { groupGroup ->
        names.add(context.getString(groupGroup.nameID))
        CollectNames(groupGroup.items, context, names)
    }
    return names.distinct()
}

private fun CollectNames(
    items : List<ConceptItem>,
    context : Context,
    names : MutableList<String>
) {
    items.forEach { item ->
        when (item) {
            is ConceptItem.Single     -> {
                names.add(context.getString(item.nameID))
            }

            is ConceptItem.Group      -> {
                names.add(context.getString(item.nameID))
                item.items.forEach {
                    names.add(context.getString(it.nameID))
                }
            }

            is ConceptItem.GroupGroup -> {
                names.add(context.getString(item.nameID))
                CollectNames(item.items, context, names)
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchBar(
    query : String,
    onQueryChange : (String) -> Unit,
    onSearch : (String) -> Unit,
    placeholder : String = "Search...",
    suggestions : List<String>
) {
    var active by remember { mutableStateOf(false) }

    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = if (active) 0.dp else 20.dp, vertical = 6.dp),
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
                    if (query.isNotEmpty()) {
                        IconButton(onClick = { onQueryChange("") }) {
                            Icon(
                                Icons.Default.Clear,
                                contentDescription = Icons.Default.Clear.name
                            )
                        }
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
            items(
                suggestions.filter {
                    it.contains(
                        query,
                        ignoreCase = true
                    )
                }
            ) { suggestion ->
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
                            Icons.Default.StarOutline,
                            contentDescription = Icons.Default.StarOutline.name
                        )
                    }
                )
            }
        }
    }
}

private fun ShowSoonToast(context : Context) = Toast.makeText(
    context,
    "Soon",
    Toast.LENGTH_SHORT
).show()
@Composable
private fun CardGroupGroup(
    context : Context,
    item : ConceptItem.GroupGroup,
    elevation : Dp
) {
    var expanded by remember { mutableStateOf(false) }

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(elevation)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TitleLine(
                nameID = item.nameID,
                icon = item.icon,
                isNullItems = item.items.isEmpty(),
                expanded = expanded,
                onExpandedChange = {
                    if (item.items.isNotEmpty())
                        expanded = it
                    else
                        ShowSoonToast(context)
                },
                padding = 20.dp
            )

            if (expanded && item.items.isNotEmpty()) {
                HorizontalDivider()

                item.items.forEach { subItem ->
                    when (subItem) {
                        is ConceptItem.Single     -> CardButton(
                            context = context,
                            item = subItem,
                            elevation = elevation - 2.dp
                        )

                        is ConceptItem.Group      -> CardGroup(
                            context = context,
                            item = subItem,
                            elevation = elevation - 2.dp
                        )

                        is ConceptItem.GroupGroup -> CardGroupGroup(
                            context = context,
                            item = subItem,
                            elevation = elevation - 2.dp
                        )
                    }
                }
            }
        }
    }
}
@Composable
private fun TitleLine(
    nameID : Int,
    icon : ImageVector,
    isNullItems : Boolean,
    expanded : Boolean,
    onExpandedChange : (Boolean) -> Unit,
    textStyle : androidx.compose.ui.text.TextStyle = MaterialTheme.typography.titleLarge,
    padding : Dp
) {
    Card(
        onClick = { onExpandedChange(!expanded) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = icon,
                contentDescription = stringResource(nameID)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(nameID),
                style = textStyle
            )
            if (!isNullItems) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .rotate(if (expanded) 180f else 0f),
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Collapse" else "Expand"
                )
            }
        }
    }
}
@Composable
private fun CardGroup(
    context : Context,
    item : ConceptItem.Group,
    elevation : Dp
) {
    var expanded by remember { mutableStateOf(false) }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        elevation = CardDefaults.elevatedCardElevation(elevation)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TitleLine(
                nameID = item.nameID,
                icon = item.icon,
                isNullItems = item.items.isEmpty(),
                expanded = expanded,
                onExpandedChange = {
                    if (item.items.isNotEmpty())
                        expanded = it
                    else
                        ShowSoonToast(context)
                },
                padding = 16.dp
            )

            if (expanded && item.items.isNotEmpty()) {
                HorizontalDivider()

                item.items.forEach { subItem ->
                    CardButton(
                        context = context,
                        item = subItem,
                        elevation = elevation - 2.dp
                    )
                }
            }
        }
    }
}
@Composable
private fun CardButton(
    context : Context,
    item : ConceptItem.Single,
    elevation : Dp
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        elevation = CardDefaults.elevatedCardElevation(elevation),
        onClick = {
            context.startActivity(Intent(context, item.activityClass))
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = item.icon,
                contentDescription = stringResource(item.nameID)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(item.nameID),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}