package com.mycity.presintation.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mycity.R
import com.mycity.presintation.base.DefConstants.defDelayBottomMenuShow
import com.mycity.presintation.widget.BottomBar


class MainActivity : AppCompatActivity() {

    private var bottomBar: BottomBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomBar = findViewById(R.id.bottom_bar)
        doDelayed(defDelayBottomMenuShow.toLong()) {
            showBottomBar()
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

    fun hideBottomBar() {
        bottomBar?.animate()
            ?.scaleX(0f)
            ?.scaleY(0f)
            ?.translationY(80.dp)
            ?.setDuration(DefConstants.defAnimationDuration.toLong())
            ?.start()
    }
}
