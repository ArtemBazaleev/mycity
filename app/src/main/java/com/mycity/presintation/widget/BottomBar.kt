package com.mycity.presintation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.navigation.ui.NavigationUI
import com.mycity.R

class BottomBar : LinearLayout {

    private var map: ImageView? = null
    private var plus: ImageView? = null

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        0
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init()
    }

    private fun init() {
        (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater).inflate(R.layout.layout_bottom_menu, this)
        findView()
    }

    private fun findView() {
        plus = findViewById(R.id.iv_plus)
        map = findViewById(R.id.iv_map)
    }

    fun setOnMapClickListener(click: () -> Unit) = map?.setOnClickListener { click.invoke() }


    fun setOnPlusClickListener(click: () -> Unit) = plus?.setOnClickListener { click.invoke() }

}