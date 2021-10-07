package com.cfr4123.cryptoapp.domain.repository

import com.cfr4123.cryptoapp.data.remote.dto.CoinDetailDto
import com.cfr4123.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}