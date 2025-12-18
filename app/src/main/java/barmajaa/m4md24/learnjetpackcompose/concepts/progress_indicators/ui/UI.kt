package barmajaa.m4md24.learnjetpackcompose.concepts.progress_indicators.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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