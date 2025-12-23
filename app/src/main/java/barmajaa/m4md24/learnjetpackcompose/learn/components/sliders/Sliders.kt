package barmajaa.m4md24.learnjetpackcompose.learn.components.sliders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
            steps = 9,
            valueRange = 0f .. 100f
        )
        Text(text = sliderPosition.toString())
    }
}
@Composable
fun Range() {
    var sliderPosition by remember { mutableStateOf(20f .. 80f) }
    Column {
        RangeSlider(
            value = sliderPosition,
            steps = 9,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f .. 100f,
            onValueChangeFinished = {},
        )
        Text(text = sliderPosition.toString())
    }
}