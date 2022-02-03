package com.mycity.presintation.module.map.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions

fun View.visible() {
    if (visibility != View.VISIBLE)
        visibility = View.VISIBLE
}

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.invisible() {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
}

fun ImageView.loadImage(url: String?) {
    url?.let { urlNotNull ->
        Glide.with(this.context)
            .load(urlNotNull)
            .into(this)
    }
}

fun ImageView.loadImage(
    url: String?,
    listener: RequestListener<Drawable>
) {
    url?.let {
        Glide.with(this.context)
            .asDrawable()
            .load(it)
            .listener(listener)
            .into(this)
    }
}

fun ImageView.loadCircleImage(url: String?) {
    url?.let {
        Glide.with(this.context)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
    }
}

fun ImageView.loadCircleImage(
    url: String?,
    listener: RequestListener<Drawable>
) {
    url?.let {
        Glide.with(this.context)
            .asDrawable()
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .listener(listener)
            .into(this)
    }
}

fun Context.toast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
