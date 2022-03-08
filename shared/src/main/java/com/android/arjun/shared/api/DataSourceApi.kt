package com.android.arjun.shared.api

import com.android.arjun.shared.data.CartResp
import com.android.arjun.shared.data.LoginResp
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface DataSourceApi {

    @FormUrlEncoded
    @POST("/login")
    suspend fun login(@Field("user_id") user_id:String,
                      @Field("user_id") password:String): Response<LoginResp>

    @GET("/cart")
    suspend fun cart(): Response<CartResp>
}