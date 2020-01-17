package com.android.dagger.di.modules;

import com.android.dagger.viewmodel.factory.ViewModelProviderFactory;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindFactory(ViewModelProviderFactory viewModelProviderFactory);


}
