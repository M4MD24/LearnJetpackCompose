package barmajaa.m4md24.learnjetpackcompose.concepts.check_boxes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.concepts.check_boxes.ui.PreviewUI

class Checkboxes : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun CheckBox() {
    var childCheckedStates by remember {
        mutableStateOf(listOf(false, false, false))
    }
    val parentState = when {
        childCheckedStates.all { it } -> ToggleableState.On
        childCheckedStates.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(text = "Select All")
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    childCheckedStates = childCheckedStates.map { newState }
                }
            )
        }

        childCheckedStates.forEachIndexed { index, oldChecked ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Option ${index + 1}")
                Checkbox(
                    checked = oldChecked,
                    onCheckedChange = { newChecked ->
                        childCheckedStates = childCheckedStates.toMutableList().also {
                            it[index] = newChecked
                        }
                    }
                )
            }
        }

        Text(
            text = if (childCheckedStates.all { it })
                "All Options Selected"
            else if (childCheckedStates.none { it })
                "None Options Selected"
            else
                "Options Selected",
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}