package barmajaa.m4md24.learnjetpackcompose.concepts.resource_access.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import barmajaa.m4md24.learnjetpackcompose.concepts.resource_access.AccessDrawableResource
import barmajaa.m4md24.learnjetpackcompose.concepts.resource_access.AccessStringResource
import barmajaa.m4md24.learnjetpackcompose.concepts.resource_access.colorID
import barmajaa.m4md24.learnjetpackcompose.concepts.resource_access.painterID
import barmajaa.m4md24.learnjetpackcompose.concepts.resource_access.textID

@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AccessDrawableResource(
            Modifier.fillMaxSize(),
            painterID
        )
        AccessStringResource(
            Modifier.fillMaxSize(),
            textID,
            colorID
        )
    }
}