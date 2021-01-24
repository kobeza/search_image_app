package com.kobeza.core.ba

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageAdapter {

    @BindingAdapter("app:link")
    @JvmStatic
    fun loadImage(view: ImageView, link: String) {

        if (link.isNotEmpty()) {
            Glide.with(view).load(link)
                .into(view)
        }
    }
}