package barmajaa.m4md24.learnjetpackcompose.concepts.first_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

const val GREETING_NAME = "Jetpack Compose"

class FirstApp : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Greeting(
                name = GREETING_NAME
            )
        }
    }
}
@Composable
fun Greeting(name : String = "") = Text("Hello $name!")