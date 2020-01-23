package com.android.dagger.di.providers;

import com.android.dagger.di.modules.RecipeCategoryFragmentModule;
import com.android.dagger.ui.fragment.RecipeCategoryFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RecipeCategoryFragmentProvider {

    @ContributesAndroidInjector(modules = {RecipeCategoryFragmentModule.class})
    abstract RecipeCategoryFragment contributeCategoryFragment();

}
