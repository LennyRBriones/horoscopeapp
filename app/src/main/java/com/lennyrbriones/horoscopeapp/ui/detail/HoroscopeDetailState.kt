package com.lennyrbriones.horoscopeapp.ui.detail

import com.lennyrbriones.horoscopeapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState() //receiving parameters must be data class
    data class Success(val prediction:String, val sign:String, val horoscopeModel: HoroscopeModel):HoroscopeDetailState()
}