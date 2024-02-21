package com.lennyrbriones.horoscopeapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.lennyrbriones.horoscopeapp.domain.model.PredictionModel

data class PredictionResponse(
    @SerializedName ("date") val date:String,
    @SerializedName ("horoscope") val horoscope:String,
    @SerializedName ("sign") val sign:String //security
)
{
    fun toDomain():PredictionModel{
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
            )
    }
}