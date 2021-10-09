package com.cfr4123.cryptoapp.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cfr4123.cryptoapp.common.Constants
import com.cfr4123.cryptoapp.common.Resource
import com.cfr4123.cryptoapp.domain.use_cases.get_coin.GetCoinUseCase
import com.cfr4123.cryptoapp.domain.use_cases.get_coins.GetCoinsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CoinDetailViewModel(
    private val getCoinUseCase: GetCoinUseCase,
    safeStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> get() = _state

    init {
        safeStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getCoin(it)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        CoinDetailState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}