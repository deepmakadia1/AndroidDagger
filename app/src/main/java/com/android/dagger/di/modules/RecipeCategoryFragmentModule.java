package com.android.dagger.di.modules;

import com.android.dagger.adapter.RecipeListAdapter;
import com.android.dagger.ui.fragment.RecipeCategoryFragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;

@Module
public class RecipeCategoryFragmentModule {

    @Provides
    RecipeListAdapter providerRecipeListAdapter(RecipeCategoryFragment recipeCategoryFragment) {
        return new RecipeListAdapter(recipeCategoryFragment.getFragmentManager());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(RecipeCategoryFragment recipeCategoryFragment) {
        return new LinearLayoutManager(recipeCategoryFragment.getContext());
    }

}
