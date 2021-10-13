package com.cfr4123.cryptoapp.di

import androidx.lifecycle.SavedStateHandle
import com.cfr4123.cryptoapp.common.Constants
import com.cfr4123.cryptoapp.data.remote.CoinPaprikaApi
import com.cfr4123.cryptoapp.data.repository.CoinRepositoryImpl
import com.cfr4123.cryptoapp.domain.repository.CoinRepository
import com.cfr4123.cryptoapp.domain.use_cases.get_coin.GetCoinUseCase
import com.cfr4123.cryptoapp.domain.use_cases.get_coins.GetCoinsUseCase
import com.cfr4123.cryptoapp.presentation.coin_detail.CoinDetailViewModel
import com.cfr4123.cryptoapp.presentation.coin_list.CoinListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
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

    single { GetCoinsUseCase(get()) }

    single { GetCoinUseCase(get()) }

    viewModel { CoinListViewModel(get()) }

    viewModel { params -> CoinDetailViewModel(params.get(), get()) }
}