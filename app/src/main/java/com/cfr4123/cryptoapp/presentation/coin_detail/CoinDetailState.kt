package com.cfr4123.cryptoapp.presentation.coin_detail

import com.cfr4123.cryptoapp.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
