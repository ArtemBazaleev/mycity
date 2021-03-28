package com.mycity.presintation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import com.mycity.R

class BottomBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var map: ImageView? = null
    private var plus: ImageView? = null

    init {
        (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater).inflate(R.layout.layout_bottom_menu, this)
        plus = findViewById(R.id.iv_plus)
        map = findViewById(R.id.iv_map)
    }

    fun setOnMapClickListener(click: () -> Unit) = map?.setOnClickListener { click.invoke() }


    fun setOnPlusClickListener(click: () -> Unit) = plus?.setOnClickListener { click.invoke() }

}