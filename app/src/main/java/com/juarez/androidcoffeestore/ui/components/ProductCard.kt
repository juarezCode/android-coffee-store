package com.juarez.androidcoffeestore.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juarez.androidcoffeestore.R
import com.juarez.androidcoffeestore.ui.theme.AndroidCoffeeStoreTheme
import com.juarez.androidcoffeestore.ui.theme.PlatziBlue
import com.juarez.androidcoffeestore.ui.theme.PlatziGreen

enum class CountryISO(val iso: String) {
    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("NIC");

    fun getBackgroundImage(): Int {
        return when (this) {
            COL -> R.drawable.co
            BRA -> R.drawable.br
            CRI -> R.drawable.ri
            NIC -> R.drawable.ni
        }
    }

    fun getCountryFlag(): Int {
        return when (this) {
            COL -> R.drawable.flagco
            BRA -> R.drawable.flagbr
            CRI -> R.drawable.flagri
            NIC -> R.drawable.flagni
        }
    }

    fun getSurface(): Color {
        return when (this) {
            COL, NIC -> PlatziBlue
            BRA, CRI -> PlatziGreen
        }
    }
}


@Composable
fun ProductCard(name: String, summary: String, price: Double, currency: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { }
            .size(480.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Image(painter = painterResource(R.drawable.co), contentDescription = null)
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = PlatziBlue.copy(0.2f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(name, style = MaterialTheme.typography.h4)
                Text(summary, style = MaterialTheme.typography.body1)
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.flagco),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                        Text(
                            text = "$ $price $currency",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.h4
                        )

                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    AndroidCoffeeStoreTheme {
        ProductCard("Cafe de colombia", "Cafe de origen de las montañas", 35.0, "USD")
    }
}