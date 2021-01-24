package com.kobeza.core.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel() : ViewModel(), LifecycleObserver {

    private val ioJob = Job()
    private val mainJob = Job()

    protected val mainScope = CoroutineScope(Dispatchers.Main + mainJob)
    protected val ioScope = CoroutineScope(Dispatchers.IO + ioJob)

    override fun onCleared() {
        ioJob.cancel()
        mainJob.cancel()
        super.onCleared()
    }
}