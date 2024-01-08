package com.ulugbek.cryptoconverter.data

import com.ulugbek.cryptoconverter.data.models.ExchangeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ConverterAPI {

    @GET("convert")
    @Headers("apikey:0rp0QvwO7InqH1TlC0EKMgb402sNmXuo")
    suspend fun converterRate(
        @Query("from") from :String,
        @Query("to") to :String,
        @Query("amount") amount :String,
    ):Response<ExchangeResponse>
}