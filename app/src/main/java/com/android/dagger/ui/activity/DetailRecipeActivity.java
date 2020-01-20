package com.android.dagger.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.android.dagger.R;
import com.android.dagger.databinding.ActivityDetailRecipeBinding;
import com.android.dagger.model.entity.RecipeDetailModel;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.DetailRecipeActivityViewModel;

import java.util.ArrayList;

import javax.annotation.Nullable;

import androidx.lifecycle.Observer;

public class DetailRecipeActivity extends BaseActivity<ActivityDetailRecipeBinding, DetailRecipeActivityViewModel> {

    @Override
    public int getLayout() {
        return R.layout.activity_detail_recipe;
    }

    @Override
    public Class<DetailRecipeActivityViewModel> getViewModel() {
        return DetailRecipeActivityViewModel.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel.getProgress().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean != null && aBoolean) {
                    binding.scrollView.setVisibility(View.GONE);
                    binding.progress.setVisibility(View.VISIBLE);
                } else {
                    binding.scrollView.setVisibility(View.VISIBLE);
                    binding.progress.setVisibility(View.GONE);
                }
            }
        });

        viewModel.getMeals(getIntent().getStringExtra(Constants.MEAL_ID)).observe(this, new Observer<ArrayList<RecipeDetailModel.Meals>>() {
            @Override
            public void onChanged(@Nullable ArrayList<RecipeDetailModel.Meals> meals) {
                if (meals != null) {
                    binding.setMeal(meals.get(0));
                }
            }
        });


    }
}
