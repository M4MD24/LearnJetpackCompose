package barmajaa.m4md24.learnjetpackcompose.learn.components.date_pickers.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.learn.components.date_pickers.Dialog
import barmajaa.m4md24.learnjetpackcompose.ui.Section
import java.text.SimpleDateFormat
import java.util.*

@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .systemBarsPadding(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            val height = 40.dp

            Section(title = "Dialog") {
                Dialog(
                    {
                        Toast.makeText(
                            context,
                            ConvertMillisToDate(it),
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    {}
                )
            }

            Spacer(modifier = Modifier.height(height))
        }
    }
}
fun ConvertMillisToDate(millis : Long?) : String? = if (millis != null) {
    val format = "yyyy-MM-dd"
    val formatter = SimpleDateFormat(
        format,
        Locale.getDefault()
    )
    val date = formatter.format(Date(millis))
    date
} else
    "Nothing to Show"