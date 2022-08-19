package com.example.android.lifecycleaware

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel : ViewModel() {
    val mutableLiveData = MutableLiveData("")
}