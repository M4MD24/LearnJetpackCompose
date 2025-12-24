package barmajaa.m4md24.learnjetpackcompose.learn.components.badges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import barmajaa.m4md24.learnjetpackcompose.learn.components.badges.ui.PreviewUI

class Badges : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun Normal() = BadgedBox(
    badge = {
        Badge()
    }
) {
    Icon(
        imageVector = Icons.Filled.Mail,
        contentDescription = Icons.Filled.Mail.name
    )
}