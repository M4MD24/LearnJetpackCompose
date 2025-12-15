package barmajaa.m4md24.learnjetpackcompose.concepts.dialogs.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.concepts.dialogs.Normal
import barmajaa.m4md24.learnjetpackcompose.R

@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var showDialog by remember {
                mutableStateOf(false)
            }

            Button(
                onClick = {
                    showDialog = true
                }
            ) {
                Text(text = "Show Dialog")
            }

            if (showDialog)
                Normal(
                    onDismissRequest = { showDialog = false },
                    onConfirmation = { showDialog = false },
                    painter = painterResource(R.drawable.coffee)
                )
        }
    }
}