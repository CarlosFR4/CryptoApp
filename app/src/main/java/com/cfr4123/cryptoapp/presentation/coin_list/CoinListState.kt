package com.cfr4123.cryptoapp.presentation.coin_list

import com.cfr4123.cryptoapp.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
