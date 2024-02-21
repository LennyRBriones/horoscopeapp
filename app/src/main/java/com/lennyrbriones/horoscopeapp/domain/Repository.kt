package com.lennyrbriones.horoscopeapp.domain

import com.lennyrbriones.horoscopeapp.data.network.response.PredictionResponse
import com.lennyrbriones.horoscopeapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}