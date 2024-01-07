package com.ulugbek.cryptoconverter.utils

import com.ulugbek.cryptoconverter.data.models.ExchangeResponse

sealed class ConvertEvent {
    data class Success(val result:ExchangeResponse):ConvertEvent()
    data class Error(val errorMessage:String?):ConvertEvent()
    object Loading:ConvertEvent()
    object Empty:ConvertEvent()
}