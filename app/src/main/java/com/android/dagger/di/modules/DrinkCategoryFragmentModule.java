package com.android.dagger.di.modules;

import com.android.dagger.adapter.DrinksListAdapter;
import com.android.dagger.di.qualifier.HorizontalLayoutQualifier;
import com.android.dagger.di.qualifier.VerticalLayoutQualifier;
import com.android.dagger.ui.fragment.DrinkCategoryFragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;

@Module
public class DrinkCategoryFragmentModule {

    @Provides
    DrinksListAdapter provideDrinksListAdapter(DrinkCategoryFragment drinkCategoryFragment){
        return new DrinksListAdapter(drinkCategoryFragment.getFragmentManager());
    }

    @Provides
    @VerticalLayoutQualifier
    GridLayoutManager provideVerticalLayoutQualifier(DrinkCategoryFragment drinkCategoryFragment){
        return new GridLayoutManager(drinkCategoryFragment.getContext(),1);
    }

    @Provides
    @HorizontalLayoutQualifier
    GridLayoutManager provideHorizontalLayoutQualifier(DrinkCategoryFragment drinkCategoryFragment){
        return new GridLayoutManager(drinkCategoryFragment.getContext(),2);
    }

}
