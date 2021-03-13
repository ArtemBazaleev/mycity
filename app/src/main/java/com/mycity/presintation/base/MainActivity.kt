package com.mycity.presintation.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.mycity.R
import com.mycity.presintation.module.map.ui.fragment.GoogleMapFragment
import com.mycity.presintation.module.map.ui.fragment.MapsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
