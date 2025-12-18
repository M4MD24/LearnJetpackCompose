package barmajaa.m4md24.learnjetpackcompose.concepts.progress_indicators

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import barmajaa.m4md24.learnjetpackcompose.concepts.navigation_drawers.ui.PreviewUI
import kotlinx.coroutines.delay

class NavigationDrawers : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun CircularIndeterminate() = CircularProgressIndicator()
@Composable
fun CircularDeterminate() {
    var progress by remember {
        mutableFloatStateOf(0f)
    }
    LaunchedEffect(Unit) {
        while (true) {
            delay(50)
            progress = (progress + 0.01f).coerceAtMost(1f)
            if (progress >= 1f) progress = 0f
        }
    }
    CircularProgressIndicator(
        progress = { progress },
        modifier = Modifier,
        color = ProgressIndicatorDefaults.circularColor,
        strokeWidth = ProgressIndicatorDefaults.CircularStrokeWidth,
        trackColor = ProgressIndicatorDefaults.circularIndeterminateTrackColor,
        strokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap,
    )
    Text("${(progress * 100).toInt()}%")
}
@Composable
fun LinearIndeterminate() = LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
@Composable
fun LinearDeterminate() {
    var progress by remember {
        mutableFloatStateOf(0f)
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(50)
            progress = (progress + 0.01f).coerceAtMost(1f)
            if (progress >= 1f) progress = 0f
        }
    }

    LinearProgressIndicator(
        progress = { progress },
        modifier = Modifier.fillMaxWidth(),
        color = ProgressIndicatorDefaults.linearColor,
        trackColor = ProgressIndicatorDefaults.linearTrackColor,
        strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
    )
    Text("${(progress * 100).toInt()}%")
}