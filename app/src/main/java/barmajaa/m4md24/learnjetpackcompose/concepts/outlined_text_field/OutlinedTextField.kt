package barmajaa.m4md24.learnjetpackcompose.concepts.outlined_text_field

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import barmajaa.m4md24.learnjetpackcompose.concepts.outlined_text_field.ui.PreviewUI

class OutlinedTextField : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun WithRemember() {
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
fun WithRememberSaveable() {
}