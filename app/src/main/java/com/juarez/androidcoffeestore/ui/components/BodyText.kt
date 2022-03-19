package com.juarez.androidcoffeestore.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.juarez.androidcoffeestore.ui.theme.AndroidCoffeeStoreTheme

@Composable
fun BodyText(body: String) {
    Text(body, style = MaterialTheme.typography.body2, textAlign = TextAlign.Justify)
}

@Preview(showBackground = true)
@Composable
fun BodyTextPreview() {
    AndroidCoffeeStoreTheme {
        BodyText("Lorem ipsum")
    }
}