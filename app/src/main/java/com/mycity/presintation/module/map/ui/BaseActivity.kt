package com.mycity.presintation.module.map.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.mycity.presintation.module.map.ui.navigation.NavigationController
import com.mycity.presintation.module.map.ui.navigation.Navigator

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {

    private var _binding: B? = null

    protected val binding: B?
        get() = _binding

    var navigator: Navigator? = null

    protected abstract val bindingInflater: (layoutInflater: LayoutInflater) -> B

    companion object {
        private const val TAG = "baseActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initNavigation()
    }

    private fun initNavigation() {
        navigator = NavigationController(supportFragmentManager)
    }

    private fun initView() {
        _binding = bindingInflater(layoutInflater)
        setContentView(requireNotNull(binding?.root))
    }
}