package com.android.arjun.ezcartapp.utils

import androidx.annotation.MainThread
import androidx.annotation.NonNull
import androidx.lifecycle.*

import java.util.concurrent.atomic.AtomicBoolean


class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val liveDataToObserve: LiveData<T>
    private val mPending: AtomicBoolean = AtomicBoolean(false)

    init {
        val outputLiveData = MediatorLiveData<T>()
        outputLiveData.addSource(this, Observer { currentValue ->
            outputLiveData.setValue(currentValue)
            mPending.set(false)
        })
        liveDataToObserve = outputLiveData
    }

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        liveDataToObserve.observe(owner, Observer { t ->
            if (mPending.get()) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(value: T) {
        mPending.set(true)
        super.setValue(value)
    }

    override fun postValue(value: T) {
        mPending.set(true)
        super.postValue(value)
    }
}