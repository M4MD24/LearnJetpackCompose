package barmajaa.m4md24.learnjetpackcompose.concepts.fields

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import barmajaa.m4md24.learnjetpackcompose.concepts.fields.ui.PreviewUI
import barmajaa.m4md24.learnjetpackcompose.R

@Composable
fun GetTextColors() = listOf(
    colorResource(R.color.dark_red),
    colorResource(R.color.firebrick),
    colorResource(R.color.crimson),
    colorResource(R.color.red),
    colorResource(R.color.coral_red),
    colorResource(R.color.light_pink_red)
)

class Field : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun OutlinedTextField() {
    var text by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text(text = "Name")
            }
        )
    }
}
@Composable
fun TextField() {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    val colors = GetTextColors()
    val brush = remember {
        Brush.linearGradient(
            colors = colors
        )
    }
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            textStyle = TextStyle(
                brush = brush
            ),
            visualTransformation = PasswordVisualTransformation('*'),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
    }
}