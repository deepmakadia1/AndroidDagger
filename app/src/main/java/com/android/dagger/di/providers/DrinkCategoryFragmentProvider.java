package com.android.dagger.di.providers;

import com.android.dagger.ui.fragment.DrinkCategoryFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DrinkCategoryFragmentProvider {

    @ContributesAndroidInjector(modules = {RecipeDetailDialogProvider.class})
    abstract DrinkCategoryFragment drinkCategoryFragment();

}
