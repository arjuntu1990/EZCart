package com.android.arjun.ezcartapp.di

import com.android.arjun.ezcartapp.EZCartApplication
import com.android.arjun.ezcartapp.ui.auth.login.LoginModule
import com.android.arjun.shared.di.SharedBindingModule
import com.android.arjun.shared.di.SharedModule
import com.arjuntu90.samplearchitecture.di.AppModule
import com.arjuntu90.samplearchitecture.di.CoroutineModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBindingModule::class, ViewModelModule::class, CoroutineModule::class, SharedModule::class, LoginModule::class, SharedBindingModule::class, BindingModule::class])
interface AppComponent : AndroidInjector<EZCartApplication> {
    @Component.Builder
    abstract class Builder:AndroidInjector.Builder<EZCartApplication>()
}