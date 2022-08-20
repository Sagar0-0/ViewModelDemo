package com.example.android.lifecycleaware

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.lifecycleaware.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val adapter = MyAdapter()
        val a = Item(1, "SAGAR")
        val b = Item(2, "AKASH")
        val c = Item(3, "PULPIT")
        val d=Item(4,"FORTH")
        val e=Item(5,"FIVE")
        adapter.submitList(listOf(a,b,c,d,e))
        binding.recyclerview.layoutManager=LinearLayoutManager(this)
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.adapter=adapter
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val f=Item(2,"NEW SAGAR")
            val g=Item(4,"NEW NAME")
            adapter.submitList(listOf(f,g))
        },4000)
    }

}