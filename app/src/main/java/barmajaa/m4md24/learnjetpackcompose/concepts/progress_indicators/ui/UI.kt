package barmajaa.m4md24.learnjetpackcompose.concepts.progress_indicators.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import barmajaa.m4md24.learnjetpackcompose.concepts.progress_indicators.CircularDeterminate
import barmajaa.m4md24.learnjetpackcompose.concepts.progress_indicators.CircularIndeterminate
import barmajaa.m4md24.learnjetpackcompose.concepts.progress_indicators.LinearDeterminate
import barmajaa.m4md24.learnjetpackcompose.concepts.progress_indicators.LinearIndeterminate

@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
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

            Section(title = "Circular Indeterminate") { CircularIndeterminate() }

            Spacer(modifier = Modifier.height(height))

            Section(title = "Circular Determinate") { CircularDeterminate() }

            Spacer(modifier = Modifier.height(height))

            Section(title = "Linear Indeterminate") { LinearIndeterminate() }

            Spacer(modifier = Modifier.height(height))

            Section(title = "Linear Determinate") { LinearDeterminate() }
        }
    }
}
@Composable
private fun Section(
    title : String,
    content : @Composable () -> Unit
) = Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(containerColor = Color.LightGray)
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
        HorizontalDivider(
            modifier = Modifier.height(5.dp),
            color = Color.DarkGray
        )
        content()
    }
}