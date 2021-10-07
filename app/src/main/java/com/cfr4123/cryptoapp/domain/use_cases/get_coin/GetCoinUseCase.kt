package com.cfr4123.cryptoapp.domain.use_cases.get_coin

import com.cfr4123.cryptoapp.common.Resource
import com.cfr4123.cryptoapp.data.remote.dto.toCoinDetail
import com.cfr4123.cryptoapp.domain.models.CoinDetail
import com.cfr4123.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class GetCoinUseCase(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}