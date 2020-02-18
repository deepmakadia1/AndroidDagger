package com.android.dagger.di.modules;

import com.android.dagger.adapter.RecipeListAdapter;
import com.android.dagger.di.qualifier.HorizontalLayoutQualifier;
import com.android.dagger.di.qualifier.VerticalLayoutQualifier;
import com.android.dagger.ui.fragment.RecipeCategoryFragment;
import com.android.dagger.util.Constants;

import androidx.recyclerview.widget.GridLayoutManager;
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
    GridLayoutManager provideVerticalLayoutQualifier(RecipeCategoryFragment recipeCategoryFragment) {
        return new GridLayoutManager(recipeCategoryFragment.getContext(), Constants.SPAN_VERTICAL);
    }

    @Provides
    @HorizontalLayoutQualifier
    GridLayoutManager provideHorizontalLayoutQualifier(RecipeCategoryFragment recipeCategoryFragment) {
        return new GridLayoutManager(recipeCategoryFragment.getContext(), Constants.SPAN_HORIZONTAL);
    }

}
