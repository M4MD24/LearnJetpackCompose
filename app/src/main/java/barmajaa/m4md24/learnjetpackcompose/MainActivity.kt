package barmajaa.m4md24.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import barmajaa.m4md24.learnjetpackcompose.ui.PreviewUI
import barmajaa.m4md24.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnJetpackComposeTheme {
                PreviewUI()
            }
        }
    }
}