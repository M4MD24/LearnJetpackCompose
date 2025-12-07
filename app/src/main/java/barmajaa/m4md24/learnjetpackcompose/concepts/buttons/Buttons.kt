package barmajaa.m4md24.learnjetpackcompose.concepts.buttons

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
@Composable
fun Filled() {
    val context = LocalContext.current
    val name = "Filled"
    Button(
        onClick = {
            Toast.makeText(
                context,
                name,
                Toast.LENGTH_SHORT
            ).show()
        }
    ) {
        Text("Filled")
    }
}