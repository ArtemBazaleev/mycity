package com.mycity.presintation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.mycity.R

class BottomBar : LinearLayout, View.OnClickListener {

    // TODO: 16.04.2021 Сделать иконки меню, которые будут в приложении. Эти для теста
    private var map: ImageView? = null
    private var plus: ImageView? = null
    private var navigationListener: OnNavigationListener? = null

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
        plus?.setOnClickListener(this)
        map?.setOnClickListener(this)
    }

    fun setOnMapClickListener(click: () -> Unit) = map?.setOnClickListener { click.invoke() }


    fun setOnPlusClickListener(click: () -> Unit) = plus?.setOnClickListener { click.invoke() }

    fun setOnNavigationListener(listener: OnNavigationListener) {
        this.navigationListener = listener
    }

    enum class BottomIconType {
        // TODO: 16.04.2021 Указать какие будут возможный тип меню для примера:
        PLUS,
        MAP
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_plus -> {
                navigationListener?.onItemClick(BottomIconType.PLUS)
            }
            R.id.iv_map -> {
                navigationListener?.onItemClick(BottomIconType.MAP)
            }
        }
    }
}