package com.example.android.lifecycleaware

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.android.lifecycleaware.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        database= Room.databaseBuilder(applicationContext,
        ContactDatabase::class.java,"contactDB").build()
        database.getDao().getContacts().observe(this, Observer {
            binding.titletext.text= it[it.size-1].name
        })

        binding.btn.setOnClickListener {
            GlobalScope.launch {
                database.getDao().insertContact(Contact(0, "PILU", "98989898"))
            }
        }

    }

}