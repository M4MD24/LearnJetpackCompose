package barmajaa.m4md24.learnjetpackcompose.learn.components.scaffolds.navigation_bars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import barmajaa.m4md24.learnjetpackcompose.learn.components.scaffolds.navigation_bars.ui.PreviewUI

class NavigationBars : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewUI()
        }
    }
}

enum class Destination(
    val route : String,
    val icon : ImageVector,
    val label : String = route.replaceFirstChar { it.uppercase() },
    val contentDescription : String
) {
    HOME(
        route = "home",
        icon = Icons.Default.Home,
        contentDescription = "Navigate to Home"
    ),
    SEARCH(
        route = "search",
        icon = Icons.Default.Search,
        contentDescription = "Search for products"
    ),
    CART(
        route = "cart",
        icon = Icons.Default.ShoppingCart,
        contentDescription = "View shopping cart"
    ),
    PROFILE(
        route = "profile",
        icon = Icons.Default.Person,
        contentDescription = "View profile"
    )
}
@Composable
fun Normal() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                Destination.entries.forEach { destination ->
                    NavigationBarItem(
                        selected = currentRoute == destination.route,
                        onClick = {
                            if (currentRoute != destination.route)
                                navController.navigate(destination.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                        },
                        icon = {
                            Icon(
                                destination.icon,
                                contentDescription = destination.contentDescription
                            )
                        },
                        label = { Text(destination.label) }
                    )
                }
            }
        }
    ) { contentPadding ->
        AppNavHost(
            modifier = Modifier.padding(contentPadding),
            navController = navController,
            startDestination = Destination.HOME
        )
    }
}
@Composable
fun AppNavHost(
    modifier : Modifier = Modifier,
    navController : NavHostController,
    startDestination : Destination
) = NavHost(
    modifier = modifier,
    navController = navController,
    startDestination = startDestination.route
) {
    composable(Destination.HOME.route) {
        HomeScreen()
    }
    composable(Destination.SEARCH.route) {
        SearchScreen()
    }
    composable(Destination.CART.route) {
        CartScreen()
    }
    composable(Destination.PROFILE.route) {
        ProfileScreen()
    }
}
@Composable
fun HomeScreen() = Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Home Screen 🏠",
        style = MaterialTheme.typography.headlineLarge
    )
}
@Composable
fun SearchScreen() = Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Search Products 🔍",
        style = MaterialTheme.typography.headlineLarge
    )
}
@Composable
fun CartScreen() = Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "Shopping Cart 🛒",
        style = MaterialTheme.typography.headlineLarge
    )
}
@Composable
fun ProfileScreen() = Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
) {
    Text(
        text = "User Profile 👤",
        style = MaterialTheme.typography.headlineLarge
    )
}