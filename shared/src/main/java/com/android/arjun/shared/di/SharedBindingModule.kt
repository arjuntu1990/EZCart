package com.android.arjun.shared.di

import com.android.arjun.shared.api.DataSourceApi
import com.android.arjun.shared.data.DefaultRepo
import com.android.arjun.shared.data.list.ListRepo
import com.android.arjun.shared.data.login.LoginRepo
import com.android.arjun.shared.db.AppDatabase
import com.android.arjun.shared.util.NetworkUtils
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class SharedBindingModule {
    @Binds
    @Singleton
    abstract fun providesLoginRepo(
        defaultRepo: DefaultRepo
    ): LoginRepo

    @Binds
    @Singleton
    abstract fun providesListRepo(
        defaultRepo: DefaultRepo
    ): ListRepo
}