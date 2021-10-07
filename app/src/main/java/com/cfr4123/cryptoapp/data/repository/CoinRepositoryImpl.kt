package com.cfr4123.cryptoapp.data.repository

import com.cfr4123.cryptoapp.data.remote.dto.CoinDetailDto
import com.cfr4123.cryptoapp.data.remote.dto.CoinDto
import com.cfr4123.cryptoapp.domain.repository.CoinRepository

class CoinRepositoryImpl(private val api: CoinRepository): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}