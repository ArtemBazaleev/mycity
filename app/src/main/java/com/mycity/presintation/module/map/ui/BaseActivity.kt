package com.mycity.presintation.module.map.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.mycity.App
import com.mycity.di.DaggerApplicationComponent
import com.mycity.di.actsubcomponent.ActivityModule
import com.mycity.presintation.module.map.ui.navigation.Navigator
import javax.inject.Inject

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {

    private var _binding: B? = null

    protected val binding: B?
        get() = _binding

    @Inject
    lateinit var navigator: Navigator

    protected abstract val bindingInflater: (layoutInflater: LayoutInflater) -> B

    companion object {
        private const val TAG = "baseActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initActComponent()
    }

    private fun initActComponent() {
//        App.actSubComponent = App.component.activitySubComponentBuilder()
//            .setActivityModule(ActivityModule(this))
//            .build()
        App.actSubComponent = DaggerApplicationComponent.create()
            .activitySubComponentBuilder()
            .setActivityModule(ActivityModule(this))
            .build()
    }

    private fun initView() {
        _binding = bindingInflater(layoutInflater)
        setContentView(requireNotNull(binding?.root))
    }

    override fun onDestroy() {
        super.onDestroy()
        App.actSubComponent = null
    }
}