package com.android.arjun.ezcartapp.di

import com.android.arjun.ezcartapp.ui.auth.AuthActivity
import com.android.arjun.ezcartapp.ui.auth.login.LoginModule
import com.android.arjun.ezcartapp.ui.home.HomeActivity
import com.android.arjun.ezcartapp.ui.home.HomeModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    /*@ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    internal abstract fun contributeAuthActivity() : AuthActivity*/

    /*java.lang.IllegalArgumentException: No injector factory bound for Class<com.android.arjun.ezcartapp.ui.home.HomeActivity>*/
    @ContributesAndroidInjector(modules = [HomeModule::class])
    internal abstract fun contributeHomeActivity() : HomeActivity
}