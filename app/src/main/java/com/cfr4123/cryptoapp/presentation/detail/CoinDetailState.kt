package com.cfr4123.cryptoapp.presentation.detail

import com.cfr4123.cryptoapp.domain.models.Coin
import com.cfr4123.cryptoapp.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
