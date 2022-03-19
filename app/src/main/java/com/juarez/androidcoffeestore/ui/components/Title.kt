package com.juarez.androidcoffeestore.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.juarez.androidcoffeestore.ui.theme.AndroidCoffeeStoreTheme

@Composable
fun TitleText(title: String) {
    Text(title, style = MaterialTheme.typography.h3)
}

@Preview(showBackground = true)
@Composable
fun TitleTextPreview() {
    AndroidCoffeeStoreTheme {
        TitleText("my title")
    }
}