package barmajaa.m4md24.learnjetpackcompose.concepts.floating_action_buttons

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.concepts.buttons.DURATION_TOAST
import barmajaa.m4md24.learnjetpackcompose.concepts.floating_action_buttons.ui.PreviewUI

class FloatingActionButtons : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun Small() {
    val context = LocalContext.current
    SmallFloatingActionButton(
        onClick = {
            Toast.makeText(
                context,
                "Email",
                DURATION_TOAST
            ).show()
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Email,
            contentDescription = "Selected Check"
        )
    }
}
@Composable
fun Normal() {
    val context = LocalContext.current
    FloatingActionButton(
        onClick = {
            Toast.makeText(
                context,
                "Email",
                DURATION_TOAST
            ).show()
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Email,
            contentDescription = "Selected Check"
        )
    }
}