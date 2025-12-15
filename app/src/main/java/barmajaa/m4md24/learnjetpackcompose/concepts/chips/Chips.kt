package barmajaa.m4md24.learnjetpackcompose.concepts.chips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

class Chips : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
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