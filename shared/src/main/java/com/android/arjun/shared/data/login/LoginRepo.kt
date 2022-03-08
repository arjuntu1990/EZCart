package com.android.arjun.shared.data.login

import com.android.arjun.shared.api.ResultWrapper
import com.android.arjun.shared.data.LoginResp

interface LoginRepo {
    suspend fun login(userId: String, password: String): ResultWrapper<LoginResp>
}