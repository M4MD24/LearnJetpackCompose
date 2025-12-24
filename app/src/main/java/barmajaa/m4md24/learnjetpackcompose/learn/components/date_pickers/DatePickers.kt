package barmajaa.m4md24.learnjetpackcompose.learn.components.date_pickers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.*
import androidx.compose.runtime.*
import barmajaa.m4md24.learnjetpackcompose.learn.components.date_pickers.ui.PreviewUI

class DatePickers : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@Composable
fun Dialog(
    onDateSelected : (Long?) -> Unit,
    onDismiss : () -> Unit
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

    if (showDialog) {
        val datePickerState = rememberDatePickerState()

        DatePickerDialog(
            onDismissRequest = {
                showDialog = false
                onDismiss
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        onDateSelected(datePickerState.selectedDateMillis)
                        onDismiss
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        onDismiss
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}