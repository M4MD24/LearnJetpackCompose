package barmajaa.m4md24.learnjetpackcompose.concepts.progress_indicators

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import barmajaa.m4md24.learnjetpackcompose.concepts.navigation_drawers.ui.PreviewUI

class NavigationDrawers : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}