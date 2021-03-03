package com.marik.getphotos.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marik.getphotos.core.domain.GetWeather
import com.marik.getphotos.core.model.Weather
import kotlinx.coroutines.launch

class LoginViewModel(private val getWeather: GetWeather) : ViewModel() {
    private var weather = MutableLiveData<Weather>().apply {
        viewModelScope.launch {
            value = getWeather()
        }
    }

    fun onEnterButtonClick(): Weather {
        return weather.value!!
    }
}