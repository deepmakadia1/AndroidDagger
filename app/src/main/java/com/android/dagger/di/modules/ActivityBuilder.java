package com.android.dagger.di.modules;

import com.android.dagger.di.modules.DrinksViewModelModule;
import com.android.dagger.ui.CategoryListActivity;
import com.android.dagger.ui.DetailDrinksActivity;
import com.android.dagger.ui.DrinkListActivity;
import com.android.dagger.ui.DrinksActivity;
import com.android.dagger.ui.FoodActivity;
import com.android.dagger.ui.MainActivity;

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

    @ContributesAndroidInjector(modules = {FoodViewModelModule.class})
    abstract FoodActivity foodActivity();
}
