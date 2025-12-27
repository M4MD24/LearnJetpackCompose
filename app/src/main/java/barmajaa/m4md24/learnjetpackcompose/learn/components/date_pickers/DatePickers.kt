package barmajaa.m4md24.learnjetpackcompose.learn.components.date_pickers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
fun Range(
    onDateRangeSelected : (Pair<Long?, Long?>) -> Unit,
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
        val dateRangePickerState = rememberDateRangePickerState()

        DatePickerDialog(
            onDismissRequest = {
                showDialog = false
                onDismiss()
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        onDateRangeSelected(
                            Pair(
                                dateRangePickerState.selectedStartDateMillis,
                                dateRangePickerState.selectedEndDateMillis
                            )
                        )
                        onDismiss()
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        onDismiss()
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DateRangePicker(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                state = dateRangePickerState,
                title = {
                    Text(
                        text = "Select date range"
                    )
                },
                showModeToggle = true
            )
        }
    }
}
@Composable
fun NormalDatePicker(
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
                onDismiss()
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        onDateSelected(datePickerState.selectedDateMillis)
                        onDismiss()
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        onDismiss()
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