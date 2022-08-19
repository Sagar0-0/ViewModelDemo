package com.example.android.lifecycleaware

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFromUrl")
fun ImageView.x(url:String){
    Glide.with(this.context).load(url).into(this)
}