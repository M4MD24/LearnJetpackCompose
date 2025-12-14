package barmajaa.m4md24.learnjetpackcompose.concepts.images

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.R

@Composable
fun GetColors() = listOf(
    colorResource(R.color.dark_red),
    colorResource(R.color.firebrick),
    colorResource(R.color.crimson),
    colorResource(R.color.red),
    colorResource(R.color.coral_red),
    colorResource(R.color.light_pink_red)
)

class Images : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}
@Composable
fun Normal() {
    val borderWidth = 4.dp
    val colors = GetColors()
    val borderColors = remember {
        Brush.sweepGradient(
            colors
        )
    }
    Image(
        painter = painterResource(R.drawable.coffee),
        contentDescription = "Coffee",
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(400.dp).border(
            BorderStroke(
                width = borderWidth,
                brush = borderColors
            )
        ),
        alignment = Alignment.Center,
        colorFilter = ColorFilter.colorMatrix(
            ColorMatrix().apply {
                setToSaturation(0.0F)
            }
        )
    )
}