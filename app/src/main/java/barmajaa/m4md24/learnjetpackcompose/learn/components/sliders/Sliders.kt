package barmajaa.m4md24.learnjetpackcompose.learn.components.sliders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import barmajaa.m4md24.learnjetpackcompose.learn.components.sliders.ui.PreviewUI

class Sliders : ComponentActivity() {
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
    var sliderPosition by remember { mutableFloatStateOf(50f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF2196F3),
                activeTrackColor = Color(0xFF4CAF50),
                inactiveTrackColor = Color(0xFFE0E0E0),
                activeTickColor = Color(0xFFFF9800),
                inactiveTickColor = Color(0xFFBDBDBD)
            ),
            steps = 9,
            valueRange = 0f .. 100f
        )
        Text(text = sliderPosition.toString())
    }
}
@Composable
fun Range() {
}