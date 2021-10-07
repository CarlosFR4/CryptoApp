package com.cfr4123.cryptoapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.cfr4123.cryptoapp.R
import com.cfr4123.cryptoapp.presentation.ui.CryptoAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CryptoAppTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}