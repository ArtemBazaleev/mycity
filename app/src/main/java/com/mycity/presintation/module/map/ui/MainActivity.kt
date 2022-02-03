package com.mycity.presintation.module.map.ui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import com.mycity.App
import com.mycity.R
import com.mycity.databinding.ActivityMainBinding
import com.mycity.presintation.base.DefConstants
import com.mycity.presintation.base.doDelayed
import com.mycity.presintation.base.dp
import com.mycity.presintation.module.map.ui.navigation.setUpWithNavController

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (layoutInflater: LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.actSubComponent?.inject(this)
        initLightStatusBar()
        setUpWithBottomNav()
        doDelayed(1500) {
            showBottomBar()
        }
    }

    private fun setUpWithBottomNav() {
        setUpWithNavController(binding?.bottomBar, navigator.getController())
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

    private fun showBottomBar() {
        binding?.bottomBar?.animate()
            ?.scaleX(1f)
            ?.scaleY(1f)
            ?.translationY(0.dp)
            ?.setDuration(DefConstants.defAnimationDuration.toLong())
            ?.start()
    }

    private fun hideBottomBar() {
        binding?.bottomBar?.animate()
            ?.scaleX(0f)
            ?.scaleY(0f)
            ?.translationY(80.dp)
            ?.setDuration(DefConstants.defAnimationDuration.toLong())
            ?.start()
    }
}
