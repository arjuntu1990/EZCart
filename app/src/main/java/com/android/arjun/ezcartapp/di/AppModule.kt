package com.arjuntu90.samplearchitecture.di

import android.app.Application
import android.content.Context
import com.android.arjun.ezcartapp.EZCartApplication
import com.android.arjun.shared.data.PreferenceStorage
import com.android.arjun.shared.data.SharedPreferenceStorage
import com.android.arjun.shared.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    fun providesAppContext(app: EZCartApplication): Context =
        app.applicationContext

    @Singleton
    @Provides
    fun providesAppDatabase(context: Context): AppDatabase =
        AppDatabase.buildDatabase(context)
}