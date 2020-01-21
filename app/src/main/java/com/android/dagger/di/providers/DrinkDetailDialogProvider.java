package com.android.dagger.di.providers;

import com.android.dagger.ui.dialog.DrinkDetailDialog;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DrinkDetailDialogProvider {

    @ContributesAndroidInjector
    abstract DrinkDetailDialog drinkDetailDialog();

}
