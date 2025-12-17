package barmajaa.m4md24.learnjetpackcompose.concepts.menus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import barmajaa.m4md24.learnjetpackcompose.concepts.menus.ui.PreviewUI

class Menus : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun Normal() {
    var expanded by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(
            onClick = { expanded = !expanded }
        ) {
            Icon(
                Icons.Default.MoreVert,
                contentDescription = Icons.Default.MoreVert.name
            )

            if (expanded) {
                val menuItemData = List(3) { index -> "Option ${index + 1}" }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }) {
                    DropdownMenuItem(
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Settings,
                                contentDescription = Icons.Filled.Settings.name
                            )
                        },
                        text = {
                            Text(text = "Settings")
                        },
                        trailingIcon = {
                            Icon(
                                Icons.Outlined.Settings,
                                contentDescription = Icons.Outlined.Settings.name
                            )
                        },
                        onClick = {}
                    )

                    HorizontalDivider()

                    menuItemData.forEach { text ->
                        DropdownMenuItem(
                            text = { Text(text) },
                            onClick = { }
                        )
                    }
                }
            }
        }
    }
}