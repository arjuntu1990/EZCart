package com.android.arjun.shared.data

import androidx.annotation.WorkerThread
import com.android.arjun.shared.api.ResultWrapper
import com.android.arjun.shared.util.NetworkUtils
import retrofit2.Response
import java.net.SocketTimeoutException

abstract class RemoteRepository constructor(private val networkUtils: NetworkUtils) {
    @WorkerThread
    suspend fun <T : Any> execute(call: suspend () -> Response<T>): ResultWrapper<T> {
        return if (networkUtils.hasInternetConnection()) try {
            val response = call.invoke()
            if (response.isSuccessful) {
                ResultWrapper.Success(response.body()!!)
            } else {
                ResultWrapper.Error(Exception(response.message()))
            }
        } catch (s: SocketTimeoutException) {
            ResultWrapper.Error(Exception("Sever not responding"))
        } catch (e: Exception) {
            ResultWrapper.Error(e)
        } else {
            ResultWrapper.Error(Exception("No Internet connection"))
        }
    }
}