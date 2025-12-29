package barmajaa.m4md24.learnjetpackcompose.learn.components.navigations.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import barmajaa.m4md24.learnjetpackcompose.learn.components.navigations.ui.pages.Page1
import barmajaa.m4md24.learnjetpackcompose.learn.components.navigations.ui.pages.Page2
import barmajaa.m4md24.learnjetpackcompose.learn.components.navigations.ui.pages.Page3

@Composable
@Preview(showSystemUi = true)
fun PreviewUI() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "page1"
    ) {
        composable("page1") { Page1(navController) }
        composable("page2") { Page2(navController) }
        composable("page3") { Page3(navController) }
    }
}