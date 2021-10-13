package com.cfr4123.cryptoapp.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.cfr4123.cryptoapp.common.Constants
import com.cfr4123.cryptoapp.presentation.coin_detail.CoinDetailScreen
import com.cfr4123.cryptoapp.presentation.coin_list.CoinListScreen
import com.cfr4123.cryptoapp.presentation.ui.CryptoAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CryptoAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(route = Screen.CoinListScreen.route) { CoinListScreen(navController) }
                        composable(route = Screen.CoinDetailScreen.route + "/{${Constants.PARAM_COIN_ID}}") {
                            CoinDetailScreen(it.arguments)
                        }
                    }
                }
            }
        }
    }
}