package com.mycity.presintation.module.map.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Continuation
import kotlinx.coroutines.*

class TestViewModel : ViewModel() {

    private var job: Job? = null
    private var mContinuation: Continuation<String, Any>? = null

    init {
        job = viewModelScope.launch(Dispatchers.IO) {

            delay(200)

            withContext(Dispatchers.Main) {

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}