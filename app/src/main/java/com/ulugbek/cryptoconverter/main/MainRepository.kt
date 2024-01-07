package com.ulugbek.cryptoconverter.main

import com.ulugbek.cryptoconverter.data.models.ExchangeResponse
import com.ulugbek.cryptoconverter.utils.Resource

interface MainRepository {

    suspend fun convertRate(
        from:String,
        to:String,
        amount:String
    ):Resource<ExchangeResponse>
}