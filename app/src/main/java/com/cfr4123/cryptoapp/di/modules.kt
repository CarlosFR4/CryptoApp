package com.cfr4123.cryptoapp.di

import com.cfr4123.cryptoapp.common.Constants
import com.cfr4123.cryptoapp.data.remote.CoinPaprikaApi
import com.cfr4123.cryptoapp.data.repository.CoinRepositoryImpl
import com.cfr4123.cryptoapp.domain.repository.CoinRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    single { providePaprikaApi() }
    single { provideCoinRepository(get()) }
}