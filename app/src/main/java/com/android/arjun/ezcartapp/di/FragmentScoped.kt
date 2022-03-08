package com.android.arjun.ezcartapp.di

import javax.inject.Scope
import kotlin.annotation.Retention
import kotlin.annotation.Target

@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class FragmentScoped
