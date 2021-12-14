package com.example.bazaarandroid.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var currentPosition: Int = 0

    init {
        Log.d("xxx", "MainViewModel constructor")
    }
}