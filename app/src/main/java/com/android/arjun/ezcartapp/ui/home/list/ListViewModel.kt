package com.android.arjun.ezcartapp.ui.home.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.arjun.ezcartapp.utils.SingleLiveEvent
import com.android.arjun.shared.api.ResultWrapper
import com.android.arjun.shared.data.list.ListRepo
import com.android.arjun.shared.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class ListViewModel @Inject constructor(@IODispatcher dispatcher: CoroutineDispatcher,
                                        repo: ListRepo) : ViewModel() {
    val loading = MutableLiveData<Boolean>()
    val toast = SingleLiveEvent<String>()
    val cartItems = repo.getLocalCartItems()

    init {
        viewModelScope.launch(dispatcher) {
            Timber.e("dispatcher %s", dispatcher)
            when (val result = repo.getCartItems()) {
                is ResultWrapper.Success -> {
                    loading.postValue(false)
                    toast.postValue(result.data ?: "")
                }
                is ResultWrapper.Error -> {
                    loading.postValue(false)
                    toast.postValue(result.e.message ?: "")
                }
                is ResultWrapper.Loading -> loading.postValue(true)
            }
        }
    }
}