package com.android.dagger.di.providers;

import com.android.dagger.ui.dialog.RecipeDetailDialog;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RecipeDetailDialogProvider {

    @ContributesAndroidInjector
    abstract RecipeDetailDialog detailRecipeDialog();

}
