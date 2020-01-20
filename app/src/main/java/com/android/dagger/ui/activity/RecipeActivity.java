package com.android.dagger.ui.activity;

import android.os.Bundle;

import com.android.dagger.R;
import com.android.dagger.adapter.CustomPagerAdapter;
import com.android.dagger.databinding.ActivityRecipeBinding;
import com.android.dagger.model.entity.RecipeCategoryModel;
import com.android.dagger.ui.fragment.RecipeCategoryFragment;
import com.android.dagger.viewmodel.RecipeActivityViewModel;

import java.util.List;

import javax.annotation.Nullable;

import androidx.lifecycle.Observer;

public class RecipeActivity extends BaseActivity<ActivityRecipeBinding, RecipeActivityViewModel> {

    private CustomPagerAdapter pagerAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_recipe;
    }

    @Override
    public Class<RecipeActivityViewModel> getViewModel() {
        return RecipeActivityViewModel.class;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        viewModel.getProgress().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean != null && aBoolean) {
                    showProgress();
                } else {
                    hideProgress();
                }
            }
        });

        viewModel.getCategories().observe(this, new Observer<List<RecipeCategoryModel.Categories>>() {
            @Override
            public void onChanged(@Nullable List<RecipeCategoryModel.Categories> categories) {
                if (categories != null) {
                    setupViewPager(categories);
                }
            }
        });
    }

    private void setupViewPager(List<RecipeCategoryModel.Categories> categories) {
        for (RecipeCategoryModel.Categories category : categories) {
            pagerAdapter.addFragment(RecipeCategoryFragment.newInstance(category.getStrCategory()), category.getStrCategory());
        }
        binding.pagerCategory.setAdapter(pagerAdapter);
        binding.tabCategory.setupWithViewPager(binding.pagerCategory);
    }

}
