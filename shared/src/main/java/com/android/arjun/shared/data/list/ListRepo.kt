package com.android.arjun.shared.data.list

import androidx.lifecycle.LiveData
import com.android.arjun.shared.api.ResultWrapper
import com.android.arjun.shared.db.CartItem

interface ListRepo {
    suspend fun getCartItems(): ResultWrapper<String>
    fun getLocalCartItems(): LiveData<Array<CartItem>>
}