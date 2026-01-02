package barmajaa.m4md24.learnjetpackcompose.learn.components.chips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Event
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import barmajaa.m4md24.learnjetpackcompose.learn.components.chips.ui.PreviewUI

class Chips : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun Input() {
    var enable by remember {
        mutableStateOf(false)
    }
    InputChip(
        label = {
            Text(text = "Email")
        },
        avatar = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email Icon"
            )
            Modifier.size(InputChipDefaults.AvatarSize)
        },
        trailingIcon = {
            Icon(
                imageVector = if (enable)
                    Icons.Filled.Check
                else
                    Icons.Filled.Close,
                contentDescription = "Selected Check"
            )
            Modifier.size(InputChipDefaults.AvatarSize)
        },
        selected = enable,
        onClick = {
            enable = !enable
        }
    )
}
@Composable
fun Assist() {
    AssistChip(
        label = { Text("Add to calendar") },
        onClick = { },
        leadingIcon = {
            Icon(
                modifier = Modifier.size(InputChipDefaults.AvatarSize),
                imageVector = Icons.Filled.Event,
                contentDescription = null
            )
        }
    )
}
@Composable
fun Filter() {
    var enable by remember {
        mutableStateOf(false)
    }
    FilterChip(
        label = { Text(text = "Under %50") },
        selected = enable,
        onClick = { enable = !enable },
        leadingIcon = {
            Modifier.size(InputChipDefaults.AvatarSize)
            Icon(
                imageVector = if (enable)
                    Icons.Filled.Check
                else
                    Icons.Filled.Close,
                contentDescription = "Selected Check"
            )
        },
    )
}
@Composable
fun Suggestion() {
    SuggestionChip(
        label = { Text(text = "Makkah") },
        onClick = { }
    )
}