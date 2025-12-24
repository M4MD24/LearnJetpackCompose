package barmajaa.m4md24.learnjetpackcompose.learn.components.switches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import barmajaa.m4md24.learnjetpackcompose.learn.components.switches.ui.PreviewUI

class Switches : ComponentActivity() {
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
    var checked by remember {
        mutableStateOf(false)
    }
    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}
@Composable
fun CustomThumb() {
    var checked by remember {
        mutableStateOf(false)
    }
    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        thumbContent = if (checked) {
            {
                Icon(
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                    imageVector = Icons.Filled.Check,
                    contentDescription = Icons.Filled.Check.name
                )
            }
        } else
            null
    )
}