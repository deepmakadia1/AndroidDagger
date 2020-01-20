package com.android.dagger.di.providers;

import com.android.dagger.di.annotation.ViewModelKey;
import com.android.dagger.ui.fragment.CategoryFragment;
import com.android.dagger.viewmodel.CategoryFragmentViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class CategoryFragmentProvider {

    @ContributesAndroidInjector
    abstract CategoryFragment contributeCategoryFragment();

}
