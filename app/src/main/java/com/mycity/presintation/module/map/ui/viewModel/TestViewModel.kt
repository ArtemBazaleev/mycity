package com.mycity.presintation.module.map.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Continuation
import com.mycity.App
import com.mycity.presintation.module.map.ui.navigation.Navigator
import kotlinx.coroutines.*
import javax.inject.Inject

class TestViewModel : ViewModel() {

    private var job: Job? = null
    private var mContinuation: Continuation<String, Any>? = null

    @Inject
    lateinit var navigator: Navigator

    init {
        App.actSubComponent?.inject(this)
//        job = viewModelScope.launch(Dispatchers.IO) {
//
//            delay(100)
//
//            withContext(Dispatchers.Main) {
//            }
//        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}