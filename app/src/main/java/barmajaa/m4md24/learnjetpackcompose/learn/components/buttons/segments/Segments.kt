package barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.segments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarViewDay
import androidx.compose.material.icons.filled.CalendarViewMonth
import androidx.compose.material.icons.filled.CalendarViewWeek
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.segments.ui.PreviewUI

class Segments : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun SingleSelectSegment() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf(
        "Day" to Icons.Default.CalendarViewDay,
        "Week" to Icons.Default.CalendarViewWeek,
        "Month" to Icons.Default.CalendarViewMonth
    )
    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, (label, icon) ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                label = { Text(label) },
                icon = {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = icon,
                        contentDescription = icon.name
                    )
                },
            )
        }
    }
}