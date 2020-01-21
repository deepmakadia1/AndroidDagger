package com.android.dagger.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.android.dagger.R;
import com.android.dagger.adapter.RecipeListAdapter;
import com.android.dagger.databinding.FragmentRecipeCategoryBinding;
import com.android.dagger.model.entity.RecipeModel;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.RecipeCategoryFragmentViewModel;

import java.util.List;

import javax.annotation.Nullable;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

public class RecipeCategoryFragment extends BaseFragment<FragmentRecipeCategoryBinding, RecipeCategoryFragmentViewModel>{

    private Context context;

    public RecipeCategoryFragment() {
        // Required empty public constructor
    }

    public static RecipeCategoryFragment newInstance(String categoryName) {
        RecipeCategoryFragment recipeCategoryFragment = new RecipeCategoryFragment();
        Bundle args = new Bundle();
        args.putString(Constants.RECIPE_CATEGORY_NAME, categoryName);
        recipeCategoryFragment.setArguments(args);
        return recipeCategoryFragment;
    }


    @Override
    public int getLayout() {
        return R.layout.fragment_recipe_category;
    }

    @Override
    public Class<RecipeCategoryFragmentViewModel> getViewModel() {
        return RecipeCategoryFragmentViewModel.class;
    }


    @Override
    public void onCreateView() {

        String categoryName = getArguments() != null ? getArguments().getString(Constants.RECIPE_CATEGORY_NAME) : null;

        viewModel.getProgress().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean != null && aBoolean) {
                    binding.listRecipe.setVisibility(View.GONE);
                    binding.progress.setVisibility(View.VISIBLE);
                } else {
                    binding.listRecipe.setVisibility(View.VISIBLE);
                    binding.progress.setVisibility(View.GONE);
                }
            }
        });

        viewModel.getRecipeList(categoryName).observe(this, new Observer<List<RecipeModel.Recipe>>() {
            @Override
            public void onChanged(@Nullable List<RecipeModel.Recipe> recipes) {
                setRecyclerView(recipes);
            }
        });

    }


    private void setRecyclerView(List<RecipeModel.Recipe> recipes) {

        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(getFragmentManager(), recipes);
        binding.listRecipe.setLayoutManager(new LinearLayoutManager(context));
        binding.listRecipe.setAdapter(recipeListAdapter);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
