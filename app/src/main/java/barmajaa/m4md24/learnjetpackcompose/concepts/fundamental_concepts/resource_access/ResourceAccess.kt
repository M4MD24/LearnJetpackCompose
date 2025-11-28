package barmajaa.m4md24.learnjetpackcompose.concepts.fundamental_concepts.resource_access

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import barmajaa.m4md24.learnjetpackcompose.R

val textID = R.string.title_activity_resource_access
val colorID = R.color.red

class ResourceAccess : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AccessStringResource(
                Modifier.fillMaxSize(),
                textID,
                colorID
            )
        }
    }
}
@Composable
fun AccessStringResource(
    modifier : Modifier = Modifier,
    textID : Int,
    colorID : Int
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(textID),
            color = colorResource(colorID),
            textDecoration = TextDecoration.Underline
        )
    }
}