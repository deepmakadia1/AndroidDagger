package com.android.dagger.di.modules;

import com.android.dagger.di.providers.DrinkCategoryFragmentProvider;
import com.android.dagger.di.providers.DrinkDetailDialogProvider;
import com.android.dagger.di.providers.RecipeCategoryFragmentProvider;
import com.android.dagger.di.providers.RecipeDetailDialogProvider;
import com.android.dagger.ui.activity.DrinkActivity;
import com.android.dagger.ui.activity.RecipeActivity;
import com.android.dagger.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = {
            DrinksViewModelModule.class,
            DrinkCategoryFragmentProvider.class,
            DrinkDetailDialogProvider.class
    })
    abstract DrinkActivity drinkActivity();

    @ContributesAndroidInjector(modules = {
            RecipeViewModelModule.class,
            RecipeCategoryFragmentProvider.class,
            RecipeDetailDialogProvider.class
    })
    abstract RecipeActivity recipeActivity();

}
