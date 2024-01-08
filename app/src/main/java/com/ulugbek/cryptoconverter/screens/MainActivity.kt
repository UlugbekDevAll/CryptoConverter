package com.ulugbek.cryptoconverter.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ulugbek.cryptoconverter.R

import com.ulugbek.cryptoconverter.main.MainViewModel
import com.ulugbek.cryptoconverter.utils.ConvertEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getConvertrate("USD", "UZS", "20")
        lifecycleScope.launchWhenCreated {
            viewModel.conversion.collectLatest {
                when (it) {
                    ConvertEvent.Empty -> Unit
                    is ConvertEvent.Error -> Log.d("TAG", "onCreate: ${it.errorMessage} ")
                    ConvertEvent.Loading -> Unit
                    is ConvertEvent.Success -> Log.d("TAG", "onCreate: ${it.result}")
                }
            }
        }


    }
}