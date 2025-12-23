package barmajaa.m4md24.learnjetpackcompose.learn.components.snack_bars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HorizontalRule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import barmajaa.m4md24.learnjetpackcompose.learn.components.snack_bars.ui.PreviewUI
import kotlinx.coroutines.launch

class SnackBars : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun Normal() {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = {
                    Icon(
                        Icons.Filled.HorizontalRule,
                        contentDescription = Icons.Filled.HorizontalRule.name
                    )
                },
                text = { Text("Show SnackBar") },
                onClick = {
                    scope.launch {
                        val result = snackBarHostState.showSnackbar(
                            message = "Message",
                            actionLabel = "ActionLabel",
                            duration = SnackbarDuration.Indefinite
                        )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {}
                            SnackbarResult.Dismissed       -> {}
                        }
                    }
                }
            )
        }
    ) {
    }
}