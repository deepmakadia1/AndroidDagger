package com.android.dagger.di.modules;

import com.android.dagger.di.providers.CategoryFragmentProvider;
import com.android.dagger.ui.activity.CategoryListActivity;
import com.android.dagger.ui.activity.DetailDrinksActivity;
import com.android.dagger.ui.activity.DetailRecipeActivity;
import com.android.dagger.ui.activity.DrinkListActivity;
import com.android.dagger.ui.activity.DrinksActivity;
import com.android.dagger.ui.activity.FoodActivity;
import com.android.dagger.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract DrinksActivity drinksActivity();

    @ContributesAndroidInjector(modules = {DrinksViewModelModule.class})
    abstract CategoryListActivity categoryListActivity();

    @ContributesAndroidInjector(modules = {DrinksViewModelModule.class})
    abstract DrinkListActivity drinkListActivity();

    @ContributesAndroidInjector(modules = {DrinksViewModelModule.class})
    abstract DetailDrinksActivity detailDrinksActivity();

    @ContributesAndroidInjector(modules = {FoodViewModelModule.class, CategoryFragmentProvider.class})
    abstract FoodActivity foodActivity();

    @ContributesAndroidInjector(modules = FoodViewModelModule.class)
    abstract DetailRecipeActivity detailRecipeActivity();
}
