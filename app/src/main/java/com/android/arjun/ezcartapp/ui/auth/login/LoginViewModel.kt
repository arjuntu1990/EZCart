package com.android.arjun.ezcartapp.ui.auth.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.arjun.ezcartapp.utils.INVALID_PASSWORD
import com.android.arjun.ezcartapp.utils.INVALID_USER_ID
import com.android.arjun.shared.api.ResultWrapper
import com.android.arjun.shared.data.LoginResp
import com.android.arjun.shared.data.PreferenceStorage
import com.android.arjun.shared.data.login.LoginRepo
import com.android.arjun.shared.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val repo: LoginRepo,
    private val preferenceStorage: PreferenceStorage
) : ViewModel() {
    var userId: String? = null
    var password: String? = null
    internal val loading = MutableLiveData<Boolean>()
    internal val loginResp = MutableLiveData<LoginResp>()
    internal val toast = MutableLiveData<String>()

    fun userLoggedIn() = preferenceStorage.loginStatus

    fun validateCredentials() {
        if (userId.isNullOrEmpty()) {
            toast.postValue(INVALID_USER_ID)
        } else if (password.isNullOrEmpty()) {
            toast.postValue(INVALID_PASSWORD)
        } else
            login()
    }

    private fun login() {
        Timber.e("userId %s", userId)
        viewModelScope.launch(dispatcher) {
            Timber.e("dispatcher %s", dispatcher)
            when (val result = repo.login(userId!!, password!!)) {
                is ResultWrapper.Success -> {
                    loading.postValue(false)
                    loginResp.postValue(result.data)
                    toast.postValue(result.data.msg)
                    preferenceStorage.loginStatus = true
                }
                is ResultWrapper.Error -> {
                    loading.postValue(false)
                    toast.postValue(result.e.message)
                }
                is ResultWrapper.Loading -> loading.postValue(true)
            }
        }
    }
}