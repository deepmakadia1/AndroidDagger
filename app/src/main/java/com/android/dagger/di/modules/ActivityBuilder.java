package com.android.dagger.di.modules;

import com.android.dagger.di.providers.DrinkCategoryFragmentProvider;
import com.android.dagger.di.providers.RecipeCategoryFragmentProvider;
import com.android.dagger.ui.activity.CategoryListActivity;
import com.android.dagger.ui.activity.DetailDrinksActivity;
import com.android.dagger.ui.activity.DetailRecipeActivity;
import com.android.dagger.ui.activity.RecipeActivity;
import com.android.dagger.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = {DrinksViewModelModule.class, DrinkCategoryFragmentProvider.class})
    abstract CategoryListActivity categoryListActivity();

    @ContributesAndroidInjector(modules = {DrinksViewModelModule.class})
    abstract DetailDrinksActivity detailDrinksActivity();

    @ContributesAndroidInjector(modules = {RecipeViewModelModule.class, RecipeCategoryFragmentProvider.class})
    abstract RecipeActivity recipeActivity();

    @ContributesAndroidInjector(modules = RecipeViewModelModule.class)
    abstract DetailRecipeActivity detailRecipeActivity();
}
