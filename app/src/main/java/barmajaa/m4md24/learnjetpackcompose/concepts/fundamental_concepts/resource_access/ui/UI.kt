package barmajaa.m4md24.learnjetpackcompose.concepts.fundamental_concepts.resource_access.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import barmajaa.m4md24.learnjetpackcompose.concepts.fundamental_concepts.resource_access.AccessStringResource
import barmajaa.m4md24.learnjetpackcompose.concepts.fundamental_concepts.resource_access.colorID
import barmajaa.m4md24.learnjetpackcompose.concepts.fundamental_concepts.resource_access.textID

@Composable
@Preview(showBackground = true)
private fun PreviewAccessStringResource() = AccessStringResource(
    Modifier.fillMaxSize(),
    textID,
    colorID
)
@Composable
@Preview(showSystemUi = true)
private fun PreviewUI() {
    AccessStringResource(
        Modifier.fillMaxSize(),
        textID,
        colorID
    )
}