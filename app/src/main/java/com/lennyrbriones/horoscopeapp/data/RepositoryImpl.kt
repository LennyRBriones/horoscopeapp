package com.lennyrbriones.horoscopeapp.data

import android.util.Log
import com.lennyrbriones.horoscopeapp.data.network.HoroscopeApiService
import com.lennyrbriones.horoscopeapp.data.network.response.PredictionResponse
import com.lennyrbriones.horoscopeapp.domain.Repository
import com.lennyrbriones.horoscopeapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String):PredictionModel? {
        //Petition to Retrofit
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Lenn", "There's an error ${it.message}") }
        return null

    }
}