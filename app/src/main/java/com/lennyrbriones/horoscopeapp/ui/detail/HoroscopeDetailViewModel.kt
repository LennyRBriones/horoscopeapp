package com.lennyrbriones.horoscopeapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lennyrbriones.horoscopeapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import java.security.CodeSigner
import javax.inject.Inject


@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    fun getHoroscope(sign: String) {
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.Loading
            // Primary Thread
            val result =
                withContext(Dispatchers.IO) { getPredictionUseCase(sign) } //Secondary thread
            if (result != null) {
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign)
                //Primary Thread
            } else {
                _state.value =
                    HoroscopeDetailState.Error("An Error has occurred, pleas try again later")
            }
        }
    }
}