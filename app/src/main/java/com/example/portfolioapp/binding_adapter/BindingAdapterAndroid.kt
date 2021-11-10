package com.example.portfolioapp.binding_adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.portfolioapp.data.Portfolio

@BindingAdapter("androidTitle")
fun TextView.setTitleAndroid(data: Portfolio?) {
    data?.let {
        text = it.title
    }
}

@BindingAdapter("androidImage")
fun ImageView.setAndroidImage(data: Portfolio) {
    this.setImageResource(data.image)
}