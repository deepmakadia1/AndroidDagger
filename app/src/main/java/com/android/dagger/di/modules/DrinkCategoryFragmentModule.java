package com.android.dagger.di.modules;

import com.android.dagger.adapter.DrinksListAdapter;
import com.android.dagger.ui.fragment.DrinkCategoryFragment;

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
    LinearLayoutManager provideLinearLayoutManager(DrinkCategoryFragment drinkCategoryFragment){
        return new LinearLayoutManager(drinkCategoryFragment.getContext());
    }

}
