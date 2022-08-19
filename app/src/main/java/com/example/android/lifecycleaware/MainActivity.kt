package com.example.android.lifecycleaware

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    private val textView:TextView
    get() = findViewById(R.id.quote)

    private val editText:EditText
    get() = findViewById(R.id.edittext)

    private val button:Button
    get() = findViewById(R.id.button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.liveData.observe(this, Observer {
            //change anything if factlivedata changes
            textView.text=it
        })
        button.setOnClickListener {
            mainViewModel.updateLiveData(editText.text.toString())
        }
    }

}