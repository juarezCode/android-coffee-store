package com.juarez.androidcoffeestore.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.juarez.androidcoffeestore.ui.components.*
import com.juarez.androidcoffeestore.ui.theme.AndroidCoffeeStoreTheme

@Composable
fun FeedScreen(navController: NavController) {
    val list = listOf<CountryISO>(
        CountryISO.COL, CountryISO.BRA, CountryISO.NIC, CountryISO.CRI
    )

    Scaffold(
        topBar = { CustomAppBar("Coffee Store") },
        content = {

            AndroidCoffeeStoreTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        item {
                            Column {
                                TitleText(title = "Bienvenido")
                                BodyText(body = "Lorem imsum")
                            }
                        }
                        items(list) { country ->
                            ProductCard(
                                name = "Cafe de colombia",
                                summary = "summary",
                                price = 35.0,
                                currency = "USD",
                                country = country
                            ) {
                                navController.navigate("detail/${country.iso}") {
                                    launchSingleTop = true
                                }
                            }
                        }
                    }
                }
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    FeedScreen(navController)
}