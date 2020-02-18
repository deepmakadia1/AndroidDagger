package com.android.dagger.di.modules;

import com.android.dagger.adapter.RecipeListAdapter;
import com.android.dagger.di.qualifier.HorizontalLayoutQualifier;
import com.android.dagger.di.qualifier.VerticalLayoutQualifier;
import com.android.dagger.ui.fragment.DrinkCategoryFragment;
import com.android.dagger.ui.fragment.RecipeCategoryFragment;

import androidx.recyclerview.widget.GridLayoutManager;
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
    @VerticalLayoutQualifier
    GridLayoutManager provideVerticalLayoutQualifier(RecipeCategoryFragment recipeCategoryFragment){
        return new GridLayoutManager(recipeCategoryFragment.getContext(),1);
    }

    @Provides
    @HorizontalLayoutQualifier
    GridLayoutManager provideHorizontalLayoutQualifier(RecipeCategoryFragment recipeCategoryFragment){
        return new GridLayoutManager(recipeCategoryFragment.getContext(),2);
    }

}
