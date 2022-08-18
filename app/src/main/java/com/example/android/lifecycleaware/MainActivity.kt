package com.example.android.lifecycleaware

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(){
    lateinit var mainViewModel: MainViewModel
    private val quoteText: TextView
        get() = findViewById(R.id.quote)
    private val authorText: TextView
        get() = findViewById(R.id.author)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel= ViewModelProvider(this,MainViewModelFactory(application))[MainViewModel::class.java]

        setQuote(mainViewModel.getQuote())
    }
    fun setQuote(quote: Quote){
        quoteText.text=quote.text
        authorText.text=quote.author
    }

    fun showPrev(view: View) {setQuote(mainViewModel.showPrev())}
    fun showNext(view: View) {setQuote(mainViewModel.showNext())}

}