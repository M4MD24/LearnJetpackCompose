package barmajaa.m4md24.learnjetpackcompose.learn.components.time_pickers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Keyboard
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import barmajaa.m4md24.learnjetpackcompose.learn.components.time_pickers.ui.PreviewUI
import java.util.*

class TimePickers : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalTimePicker(
    onConfirm : (TimePickerState) -> Unit,
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
        var toggle by remember {
            mutableStateOf(true)
        }
        val currentTime = Calendar.getInstance()
        val timePickerState = rememberTimePickerState(
            initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
            initialMinute = currentTime.get(Calendar.MINUTE),
            is24Hour = false,
        )
        Dialog(
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            ),
            onDismissRequest = {
                showDialog = false
                onDismiss()
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                var toggleIcon = Icons.Default.AccessTime
                if (toggle) {
                    TimePicker(state = timePickerState)
                    toggleIcon = Icons.Default.AccessTime
                } else {
                    TimeInput(state = timePickerState)
                    toggleIcon = Icons.Default.Keyboard
                }
                Row {
                    IconButton(
                        onClick = {
                            toggle = !toggle
                        }
                    ) {
                        Icon(
                            imageVector = toggleIcon,
                            contentDescription = toggleIcon.name,
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.7F))
                    Button(
                        onClick = {
                            showDialog = false
                            onDismiss()
                        }
                    ) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.weight(0.1F))
                    Button(
                        onClick = {
                            showDialog = false
                            onConfirm(timePickerState)
                        }
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }
}