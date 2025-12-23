package barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.floating_action_buttons

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
import barmajaa.m4md24.learnjetpackcompose.learn.components.buttons.floating_action_buttons.ui.PreviewUI

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
                Toast.LENGTH_SHORT
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
                Toast.LENGTH_SHORT
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
fun Large() {
    val context = LocalContext.current
    LargeFloatingActionButton(
        onClick = {
            Toast.makeText(
                context,
                "Email",
                Toast.LENGTH_SHORT
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
fun Extended() {
    val context = LocalContext.current
    ExtendedFloatingActionButton(
        onClick = {
            Toast.makeText(
                context,
                "Email",
                Toast.LENGTH_SHORT
            ).show()
        }
    ) {
        Text(
            text = "Email"
        )
        Spacer(modifier = Modifier.width(width = 30.dp))
        Icon(
            imageVector = Icons.Filled.Email,
            contentDescription = "Selected Check"
        )
    }
}