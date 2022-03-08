package com.android.arjun.ezcartapp.ui.home

import androidx.lifecycle.ViewModel
import com.android.arjun.ezcartapp.di.FragmentScoped
import com.android.arjun.ezcartapp.di.ViewModelKey
import com.android.arjun.ezcartapp.ui.home.details.DetailsFragment
import com.android.arjun.ezcartapp.ui.home.details.DetailsViewModel
import com.android.arjun.ezcartapp.ui.home.list.ListFragment
import com.android.arjun.ezcartapp.ui.home.list.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class HomeModule {

//    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeListFragment(): ListFragment

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel): ViewModel

//    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeDetailsFragment(): DetailsFragment

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindLoginViewModel(detailsViewModel: DetailsViewModel): ViewModel
}