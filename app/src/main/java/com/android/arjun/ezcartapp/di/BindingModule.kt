package com.android.arjun.ezcartapp.di

import com.android.arjun.shared.data.PreferenceStorage
import com.android.arjun.shared.data.SharedPreferenceStorage
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class BindingModule {

    @Singleton
    @Binds
    abstract fun providesPreferenceStorage(s: SharedPreferenceStorage): PreferenceStorage
}