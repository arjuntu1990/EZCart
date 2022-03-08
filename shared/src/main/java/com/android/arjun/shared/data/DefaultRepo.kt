package com.android.arjun.shared.data

import androidx.lifecycle.LiveData
import com.android.arjun.shared.api.DataSourceApi
import com.android.arjun.shared.api.ResultWrapper
import com.android.arjun.shared.data.list.ListRepo
import com.android.arjun.shared.data.login.LoginRepo
import com.android.arjun.shared.db.AppDatabase
import com.android.arjun.shared.db.CartItem
import com.android.arjun.shared.util.NetworkUtils
import timber.log.Timber
import javax.inject.Inject

class DefaultRepo @Inject constructor(
    private val dataSourceApi: DataSourceApi,
    private val appDatabase: AppDatabase,
    networkUtils: NetworkUtils
) : RemoteRepository(networkUtils), LoginRepo, ListRepo {

    override suspend fun login(userId: String, password: String): ResultWrapper<LoginResp> {
        return when (val result = execute { dataSourceApi.login(userId, password) }) {
            is ResultWrapper.Success -> ResultWrapper.Success(result.data)
            is ResultWrapper.Error -> ResultWrapper.Error(result.e)
            is ResultWrapper.Loading -> ResultWrapper.Loading
        }
    }

    override suspend fun getCartItems(): ResultWrapper<String> {
        return when (val result = execute { dataSourceApi.cart() }) {
            is ResultWrapper.Success -> {
                val r = appDatabase.cartDao().insertAll(result.data.cart)
                Timber.e("appDatabase insert %s", r.toString())
                ResultWrapper.Success(result.data.status)
            }
            is ResultWrapper.Error -> ResultWrapper.Error(result.e)
            is ResultWrapper.Loading -> ResultWrapper.Loading
        }
    }

    override fun getLocalCartItems(): LiveData<Array<CartItem>> {
        return appDatabase.cartDao().getAll()
    }
}