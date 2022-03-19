package com.juarez.androidcoffeestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.juarez.androidcoffeestore.ui.components.CountryISO
import com.juarez.androidcoffeestore.ui.screen.DetailScreen
import com.juarez.androidcoffeestore.ui.screen.FeedScreen
import com.juarez.androidcoffeestore.ui.theme.AndroidCoffeeStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHost()
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    AndroidCoffeeStoreTheme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController, startDestination = "feed") {
                composable(route = "feed") {
                    FeedScreen(navController)
                }
                composable(route = "detail/{countryIso}") { backEStackEntry ->
                    val conutryIsoString =
                        backEStackEntry.arguments?.getString("countryIso") ?: "COL"
                    val countryIso = CountryISO.valueOf(conutryIsoString)
                    DetailScreen(navController, countryIso)
                }
            }
        }
    }

}
