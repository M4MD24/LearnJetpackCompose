package barmajaa.m4md24.learnjetpackcompose.ui

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.filled.Label
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.ViewQuilt
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.R
import barmajaa.m4md24.learnjetpackcompose.concepts.buttons.Buttons
import barmajaa.m4md24.learnjetpackcompose.concepts.cards.Cards
import barmajaa.m4md24.learnjetpackcompose.concepts.checkboxes.Checkboxes
import barmajaa.m4md24.learnjetpackcompose.concepts.chips.Chips
import barmajaa.m4md24.learnjetpackcompose.concepts.column_and_row_types.lazy.Lazy
import barmajaa.m4md24.learnjetpackcompose.concepts.column_and_row_types.normal.Normal
import barmajaa.m4md24.learnjetpackcompose.concepts.dialogs.Dialogs
import barmajaa.m4md24.learnjetpackcompose.concepts.fields.Fields
import barmajaa.m4md24.learnjetpackcompose.concepts.first_app.FirstApp
import barmajaa.m4md24.learnjetpackcompose.concepts.floating_action_buttons.FloatingActionButtons
import barmajaa.m4md24.learnjetpackcompose.concepts.images.Images
import barmajaa.m4md24.learnjetpackcompose.concepts.layouts.Layouts
import barmajaa.m4md24.learnjetpackcompose.concepts.menus.Menus
import barmajaa.m4md24.learnjetpackcompose.concepts.modal_bottom_sheets.ModalBottomSheets
import barmajaa.m4md24.learnjetpackcompose.concepts.navigation_drawers.NavigationDrawers
import barmajaa.m4md24.learnjetpackcompose.concepts.progress_indicators.ProgressIndicators
import barmajaa.m4md24.learnjetpackcompose.concepts.pull_to_refresh_boxes.PullToRefreshBoxes
import barmajaa.m4md24.learnjetpackcompose.concepts.resource_access.ResourceAccess
import barmajaa.m4md24.learnjetpackcompose.concepts.scaffolds.Scaffolds
import barmajaa.m4md24.learnjetpackcompose.concepts.text_and_typography.TextAndTypography
import barmajaa.m4md24.learnjetpackcompose.concepts.texts.Texts

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
}
@Composable
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
@Preview(
    name = "Dark Mode",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES, device = "spec:parent=pixel_5,orientation=landscape"
)
@Preview(
    name = "Light Mode",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO, device = "spec:parent=pixel_5,orientation=landscape"
)
@Preview(
    name = "Light Mode",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO, device = "spec:width=7680px,height=4320px,dpi=1760,orientation=landscape"
)
fun PreviewUI() {
    val conceptItems = listOf(
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
                val elevation = 10.dp
                items(conceptItems) { item ->
                    when (item) {
                        is ConceptItem.Single -> CardButton(
                            context,
                            item,
                            elevation
                        )

                        is ConceptItem.Group  -> CardGroup(
                            context,
                            item,
                            elevation
                        )
                    }
                }
            }
        }
    }
}
@Composable
private fun CardGroup(
    context : Context,
    item : ConceptItem.Group,
    elevation : Dp
) = ElevatedCard(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp),
    elevation = CardDefaults.elevatedCardElevation(elevation)
) {
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.icon.name
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = stringResource(item.nameID),
                style = MaterialTheme.typography.titleMedium
            )
        }

        HorizontalDivider()

        item.items.forEach { subItem ->
            CardButton(
                context,
                subItem,
                elevation
            )
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
        .padding(horizontal = 20.dp)
        .clickable {
            context.startActivity(
                Intent(context, item.activityClass)
            )
        },
    elevation = CardDefaults.elevatedCardElevation(elevation)
) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(20.dp),
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