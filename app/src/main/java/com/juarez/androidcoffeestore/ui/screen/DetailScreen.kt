package com.juarez.androidcoffeestore.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.juarez.androidcoffeestore.ui.components.CountryISO
import com.juarez.androidcoffeestore.ui.components.CustomAppBar

@Composable
fun DetailScreen(navController: NavController, countryIso: CountryISO) {

    Scaffold(
        topBar = {
            CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
                navController.navigate("feed") {
                    popUpTo("feed")
                }
            }
        },
        content = {
            Column {
                Text(
                    text = "soy un producto de ${countryIso.iso}",
                    style = MaterialTheme.typography.h3
                )
                Button(onClick = {
                    navController.navigate("feed") {
                        popUpTo("feed")
                    }
                }) {
                    Text(text = "Volver")
                }
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val navController = rememberNavController()
    DetailScreen(navController, CountryISO.BRA)
}