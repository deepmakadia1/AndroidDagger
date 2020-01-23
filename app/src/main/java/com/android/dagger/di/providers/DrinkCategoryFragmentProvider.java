package com.android.dagger.di.providers;

import com.android.dagger.di.modules.DrinkCategoryFragmentModule;
import com.android.dagger.ui.fragment.DrinkCategoryFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DrinkCategoryFragmentProvider {

    @ContributesAndroidInjector(modules = {DrinkCategoryFragmentModule.class})
    abstract DrinkCategoryFragment drinkCategoryFragment();

}
