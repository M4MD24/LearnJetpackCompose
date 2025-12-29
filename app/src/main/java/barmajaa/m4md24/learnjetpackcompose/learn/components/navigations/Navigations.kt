package barmajaa.m4md24.learnjetpackcompose.learn.components.navigations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import barmajaa.m4md24.learnjetpackcompose.learn.components.navigations.ui.PreviewUI

class Navigations : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}