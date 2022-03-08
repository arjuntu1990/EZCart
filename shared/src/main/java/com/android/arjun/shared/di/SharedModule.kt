package com.android.arjun.shared.di

import android.app.Application
import com.android.arjun.shared.BuildConfig
import com.android.arjun.shared.api.DataSourceApi
import com.android.arjun.shared.data.list.ListRepo
import com.android.arjun.shared.data.login.LoginRepo
import com.android.arjun.shared.db.AppDatabase
import com.android.arjun.shared.data.DefaultRepo
import com.android.arjun.shared.util.NetworkUtils
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class SharedModule {
    @Provides
    @Singleton
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        if (BuildConfig.DEBUG)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()
        else
            return OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun providesGson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun providesHttpRequestHandler(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): DataSourceApi = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .baseUrl(BuildConfig.BASE_URL)
        .build().create(DataSourceApi::class.java)


}