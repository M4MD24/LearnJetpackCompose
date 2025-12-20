package barmajaa.m4md24.learnjetpackcompose.ui

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.widget.Toast
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
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.Buttons
import barmajaa.m4md24.learnjetpackcompose.learn.components.cards.Cards
import barmajaa.m4md24.learnjetpackcompose.learn.components.checkboxes.Checkboxes
import barmajaa.m4md24.learnjetpackcompose.learn.components.chips.Chips
import barmajaa.m4md24.learnjetpackcompose.learn.components.column_and_row_types.lazy.Lazy
import barmajaa.m4md24.learnjetpackcompose.learn.components.column_and_row_types.normal.Normal
import barmajaa.m4md24.learnjetpackcompose.learn.components.dialogs.Dialogs
import barmajaa.m4md24.learnjetpackcompose.learn.components.fields.Fields
import barmajaa.m4md24.learnjetpackcompose.learn.components.first_app.FirstApp
import barmajaa.m4md24.learnjetpackcompose.learn.components.floating_action_buttons.FloatingActionButtons
import barmajaa.m4md24.learnjetpackcompose.learn.components.images.Images
import barmajaa.m4md24.learnjetpackcompose.learn.components.layouts.Layouts
import barmajaa.m4md24.learnjetpackcompose.learn.components.menus.Menus
import barmajaa.m4md24.learnjetpackcompose.learn.components.modal_bottom_sheets.ModalBottomSheets
import barmajaa.m4md24.learnjetpackcompose.learn.components.navigation_drawers.NavigationDrawers
import barmajaa.m4md24.learnjetpackcompose.learn.components.progress_indicators.ProgressIndicators
import barmajaa.m4md24.learnjetpackcompose.learn.components.pull_to_refresh_boxes.PullToRefreshBoxes
import barmajaa.m4md24.learnjetpackcompose.learn.components.resource_access.ResourceAccess
import barmajaa.m4md24.learnjetpackcompose.learn.components.scaffolds.Scaffolds
import barmajaa.m4md24.learnjetpackcompose.learn.components.text_and_typography.TextAndTypography
import barmajaa.m4md24.learnjetpackcompose.learn.components.texts.Texts

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
    val learnConceptItems = listOf(
        ConceptItem.Single(R.string.title_activity_first_app, Icons.Default.Home, FirstApp::class.java),
        ConceptItem.Single(R.string.title_activity_resource_access, Icons.Default.Folder, ResourceAccess::class.java),
        ConceptItem.Single(R.string.title_activity_text_and_typography, Icons.Default.TextFields, TextAndTypography::class.java),
        ConceptItem.Single(R.string.title_activity_fields, Icons.Default.Edit, Fields::class.java),
        ConceptItem.Single(R.string.title_activity_texts, Icons.AutoMirrored.Filled.Article, Texts::class.java),
        ConceptItem.Single(R.string.title_activity_buttons, Icons.Default.TouchApp, Buttons::class.java),
        ConceptItem.Single(R.string.title_activity_images, Icons.Default.Image, Images::class.java),
        ConceptItem.Single(R.string.title_activity_layouts, Icons.AutoMirrored.Filled.ViewQuilt, Layouts::class.java),
        ConceptItem.Group(
            nameID = R.string.title_concept_column_and_row_types,
            icon = Icons.Default.ViewColumn,
            items = listOf(
                ConceptItem.Single(R.string.title_activity_normal, Icons.Default.CropSquare, Normal::class.java),
                ConceptItem.Single(R.string.title_activity_lazy, Icons.AutoMirrored.Filled.List, Lazy::class.java)
            )
        ),
        ConceptItem.Single(R.string.title_activity_modal_bottom_sheets, Icons.Default.SwipeUp, ModalBottomSheets::class.java),
        ConceptItem.Single(R.string.title_activity_cards, Icons.Default.CreditCard, Cards::class.java),
        ConceptItem.Single(R.string.title_activity_checkboxes, Icons.Default.CheckBox, Checkboxes::class.java),
        ConceptItem.Single(R.string.title_activity_chips, Icons.AutoMirrored.Filled.Label, Chips::class.java),
        ConceptItem.Single(R.string.title_activity_dialogs, Icons.AutoMirrored.Filled.Chat, Dialogs::class.java),
        ConceptItem.Single(R.string.title_activity_floating_action_buttons, Icons.Default.TouchApp, FloatingActionButtons::class.java),
        ConceptItem.Single(R.string.title_activity_menus, Icons.Default.MoreVert, Menus::class.java),
        ConceptItem.Single(R.string.title_activity_scaffolds, Icons.Default.Dashboard, Scaffolds::class.java),
        ConceptItem.Single(R.string.title_activity_navigation_drawers, Icons.Default.Menu, NavigationDrawers::class.java),
        ConceptItem.Single(R.string.title_activity_progress_indicators, Icons.Default.Refresh, ProgressIndicators::class.java),
        ConceptItem.Single(R.string.title_activity_pull_to_refresh_boxes, Icons.Default.ArrowDownward, PullToRefreshBoxes::class.java)
    )
    val developConceptItems : List<ConceptItem> = listOf()
    val conceptItems = listOf(
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
    val context = LocalContext.current
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme())
            darkColorScheme()
        else
            lightColorScheme()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(vertical = 20.dp)
            ) {
                items(conceptItems) { item ->
                    CardGroupGroup(
                        context,
                        item,
                        10.dp
                    )
                }
            }
        }
    }
}

private fun SoonToast(context : Context) = Toast.makeText(
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        elevation = CardDefaults.elevatedCardElevation(elevation)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TitleLine(
                item.nameID,
                item.icon,
                item.items.isEmpty(),
                expanded,
                {
                    if (item.items.isNotEmpty())
                        expanded = it
                    else
                        SoonToast(context)
                },
                padding = 20.dp
            )

            if (expanded) {
                HorizontalDivider()

                item.items.forEach { subItem ->
                    when (subItem) {
                        is ConceptItem.Single -> CardButton(
                            context,
                            subItem,
                            elevation - 2.dp
                        )

                        is ConceptItem.Group -> CardGroup(
                            context,
                            subItem,
                            elevation - 2.dp
                        )

                        is ConceptItem.GroupGroup -> CardGroupGroup(
                            context,
                            subItem,
                            elevation - 2.dp
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
        onClick = {
            onExpandedChange(!expanded)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.weight(0.1F),
                imageVector = icon,
                contentDescription = icon.name
            )
            Spacer(modifier = Modifier.weight(0.025F))
            Text(
                modifier = Modifier.weight(0.8F),
                text = stringResource(nameID),
                style = textStyle
            )
            if (!isNullItems)
                Icon(
                    modifier = Modifier
                        .weight(0.1F)
                        .rotate(if (expanded) 180f else 0f),
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Close" else "Open"
                )
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
                item.nameID,
                item.icon,
                item.items.isEmpty(),
                expanded,
                {
                    if (item.items.isNotEmpty())
                        expanded = it
                    else
                        SoonToast(context)
                },
                padding = 16.dp
            )

            if (expanded) {
                HorizontalDivider()

                item.items.forEach { subItem ->
                    CardButton(
                        context,
                        subItem,
                        elevation - 2.dp
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
) = ElevatedCard(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 4.dp),
    elevation = CardDefaults.elevatedCardElevation(elevation),
    onClick = {
        context.startActivity(
            Intent(context, item.activityClass)
        )
    }
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.weight(0.1F),
            imageVector = item.icon,
            contentDescription = item.icon.name
        )
        Spacer(modifier = Modifier.weight(0.025F))
        Text(
            modifier = Modifier.weight(0.8F),
            text = stringResource(item.nameID),
            style = MaterialTheme.typography.titleMedium
        )
    }
}