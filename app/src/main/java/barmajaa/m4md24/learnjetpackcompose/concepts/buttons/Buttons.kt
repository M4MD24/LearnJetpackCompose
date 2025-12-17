package barmajaa.m4md24.learnjetpackcompose.concepts.buttons

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import barmajaa.m4md24.learnjetpackcompose.concepts.buttons.ui.PreviewUI

class Buttons : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}

const val DURATION_TOAST = Toast.LENGTH_SHORT
@Composable
fun Filled() {
    val context = LocalContext.current
    val name = "Filled"
    Button(
        onClick = {
            Toast.makeText(
                context,
                name,
                DURATION_TOAST
            ).show()
        }
    ) {
        Text(name)
    }
}
@Composable
fun FilledTonal() {
    val context = LocalContext.current
    val name = "FilledTonal"
    FilledTonalButton(
        onClick = {
            Toast.makeText(
                context,
                name,
                DURATION_TOAST
            ).show()
        }
    ) {
        Text(name)
    }
}
@Composable
fun Outlined() {
    val context = LocalContext.current
    val name = "Outlined"
    OutlinedButton(
        onClick = {
            Toast.makeText(
                context,
                name,
                DURATION_TOAST
            ).show()
        }
    ) {
        Text(name)
    }
}
@Composable
fun Elevated() {
    val context = LocalContext.current
    val name = "Elevated"
    ElevatedButton(
        onClick = {
            Toast.makeText(
                context,
                name,
                DURATION_TOAST
            ).show()
        }
    ) {
        Text(name)
    }
}
@Composable
fun Text() {
    val context = LocalContext.current
    val name = "Text"
    TextButton(
        onClick = {
            Toast.makeText(
                context,
                name,
                DURATION_TOAST
            ).show()
        }
    ) {
        Text(name)
    }
}
@Composable
fun Icon() {
    val name = "Icon"
    val context = LocalContext.current
    IconButton(
        onClick = {
            Toast.makeText(
                context,
                name,
                DURATION_TOAST
            ).show()
        }
    ) {
        Icon(
            Icons.Default.Image,
            contentDescription = name
        )
    }
}