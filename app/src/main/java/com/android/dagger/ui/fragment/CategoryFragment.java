package com.android.dagger.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.android.dagger.R;
import com.android.dagger.adapter.RecipeListAdapter;
import com.android.dagger.databinding.FragmentCategoryBinding;
import com.android.dagger.model.entity.RecipeModel;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.CategoryFragmentViewModel;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class CategoryFragment extends BaseFragment<FragmentCategoryBinding, CategoryFragmentViewModel>{

    private Context context;

    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance(String categoryName) {
        CategoryFragment categoryFragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(Constants.CATEGORY_NAME, categoryName);
        categoryFragment.setArguments(args);
        return categoryFragment;
    }


    @Override
    public int getLayout() {
        return R.layout.fragment_category;
    }

    @Override
    public Class<CategoryFragmentViewModel> getViewModel() {
        return CategoryFragmentViewModel.class;
    }


    @Override
    public void onCreateView() {

        String categoryName = getArguments() != null ? getArguments().getString(Constants.CATEGORY_NAME) : null;

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

        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(context, recipes);
        binding.listRecipe.setLayoutManager(new LinearLayoutManager(context));
        binding.listRecipe.setAdapter(recipeListAdapter);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
