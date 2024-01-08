package com.ulugbek.cryptoconverter.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import com.ulugbek.cryptoconverter.utils.ConvertEvent
import com.ulugbek.cryptoconverter.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
   private val mainRepository: MainRepository
):ViewModel() {

    private val _conversion= MutableStateFlow<ConvertEvent>(ConvertEvent.Empty)
    val conversion:StateFlow<ConvertEvent> get() = _conversion


    fun getConvertrate(
        from:String,
        to:String,
        amount: String
    ){

        if(amount.isBlank()){
            return
        }

        viewModelScope.launch {
            _conversion.value=ConvertEvent.Loading
            val result=mainRepository.convertRate(from, to, amount)
            when(result){
                is Resource.Error ->
                    _conversion.value=ConvertEvent.Error(result.message)
                is Resource.Success ->{
                    result.data?.apply {
                        _conversion.value=ConvertEvent.Success(result.data)
                    }?:ConvertEvent.Error(null)
                }

            }
        }

    }


}