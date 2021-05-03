package com.mycity.presintation.base

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.mycity.R
import com.mycity.presintation.base.DefConstants.defDelayBottomMenuShow
import com.mycity.presintation.widget.BottomBar
import com.mycity.presintation.widget.OnNavigationListener


class MainActivity : AppCompatActivity(), OnNavigationListener {

    private var bottomBar: BottomBar? = null
    var navigation: AppNavigation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLightStatusBar()
        initBottomBarSettings()
        initNavigation()
        doDelayed(defDelayBottomMenuShow.toLong()) {
            showBottomBar()
        }
    }

    private fun initBottomBarSettings() {
        bottomBar = findViewById(R.id.bottom_bar)
        bottomBar?.setOnNavigationListener(this)
    }

    private fun initNavigation() {
        navigation = AppNavigation(context = this)
        navigation?.initBase()
    }

    private fun initLightStatusBar() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            window.navigationBarColor = Color.BLACK
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
                window.statusBarColor =
                    ContextCompat.getColor(applicationContext, R.color.status_bar_semi_transparent)
            } else {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        } else {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            window.navigationBarColor = Color.TRANSPARENT
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    fun showBottomBar() {
        bottomBar?.animate()
            ?.scaleX(1f)
            ?.scaleY(1f)
            ?.translationY(0.dp)
            ?.setDuration(DefConstants.defAnimationDuration.toLong())
            ?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        navigation = null
    }

    fun hideBottomBar() {
        bottomBar?.animate()
            ?.scaleX(0f)
            ?.scaleY(0f)
            ?.translationY(80.dp)
            ?.setDuration(DefConstants.defAnimationDuration.toLong())
            ?.start()
    }

    override fun onItemClick(type: BottomBar.BottomIconType) {
        when (type) {
            BottomBar.BottomIconType.MAP -> {
                navigation?.addFragment(R.id.testFragment)
                // TODO: 16.04.2021 Replace with your own action 
            }
            BottomBar.BottomIconType.PLUS -> {
                navigation?.addFragment(R.id.testFragment)
                // TODO: 16.04.2021 Replace with your own action 
            }
        }
    }
}
