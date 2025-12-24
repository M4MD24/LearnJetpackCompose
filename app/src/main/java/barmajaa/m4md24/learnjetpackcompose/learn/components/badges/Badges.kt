package barmajaa.m4md24.learnjetpackcompose.learn.components.badges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
@Composable
fun Detailed() {
    var itemCount by remember { mutableIntStateOf(999) }

    Column(
        verticalArrangement = Arrangement.spacedBy(
            space=16.dp,
            alignment =  Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BadgedBox(
            badge = {
                if (itemCount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text("$itemCount")
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping cart",
            )
        }
        Button(onClick = { itemCount++ }) {
            Text("Add item")
        }
    }
}