package com.ulugbek.cryptoconverter.main

import com.ulugbek.cryptoconverter.data.ConverterAPI
import com.ulugbek.cryptoconverter.data.models.ExchangeResponse
import com.ulugbek.cryptoconverter.utils.Resource
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor (
    private val api:ConverterAPI
):MainRepository {
    override suspend fun convertRate(
        from: String,
        to: String,
        amount: String
    ): Resource<ExchangeResponse> {

        return try {
            val response=api.converterRate(from,to, amount)
            if(response.isSuccessful && response.body()!=null){
                Resource.Success(response.body())
            }else{
                Resource.Error(response.message())
            }
        }catch (e:Exception){
            Resource.Error(e.message)
        }
    }
}