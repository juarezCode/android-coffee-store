package com.juarez.androidcoffeestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.juarez.androidcoffeestore.ui.theme.AndroidCoffeeStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCoffeeStoreTheme {
            }
        }
    }
}
