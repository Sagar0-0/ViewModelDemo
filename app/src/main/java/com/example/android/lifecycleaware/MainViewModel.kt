package com.example.android.lifecycleaware

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context: Context) : ViewModel() {
    private var quoteList: Array<Quote> = emptyArray()
    private var index = 0

    init {
        quoteList = loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quote>::class.java)
    }
    fun getQuote():Quote=quoteList[index]

    fun showNext(): Quote {
        if(index==quoteList.size-1)index=-1
        index++
        return quoteList[index]
    }
    fun showPrev(): Quote {
        if(index==0)index=quoteList.size
        index--
        return quoteList[index]
    }
}