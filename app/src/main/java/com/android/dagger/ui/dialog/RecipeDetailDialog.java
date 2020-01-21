package com.android.dagger.ui.dialog;

import android.os.Bundle;
import android.view.View;

import com.android.dagger.R;
import com.android.dagger.databinding.DialogDetailRecipeBinding;
import com.android.dagger.model.entity.RecipeDetailModel;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.RecipeDetailDialogViewModel;

import java.util.ArrayList;

import javax.annotation.Nullable;

import androidx.lifecycle.Observer;

public class RecipeDetailDialog extends BaseDialog<DialogDetailRecipeBinding, RecipeDetailDialogViewModel> {

    public static RecipeDetailDialog newInstance(String mealId) {
        RecipeDetailDialog dialog = new RecipeDetailDialog();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.MEAL_ID, mealId);
        dialog.setArguments(bundle);
        return dialog;
    }


    @Override
    public int getLayout() {
        return R.layout.dialog_detail_recipe;
    }

    @Override
    public Class<RecipeDetailDialogViewModel> getViewModel() {
        return RecipeDetailDialogViewModel.class;
    }

    @Override
    public void onCreateView() {
        if (getArguments() != null) {
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

            viewModel.getMeals(getArguments().getString(Constants.MEAL_ID)).observe(this, new Observer<ArrayList<RecipeDetailModel.Meals>>() {
                @Override
                public void onChanged(@Nullable ArrayList<RecipeDetailModel.Meals> meals) {
                    if (meals != null) {
                        binding.setMeal(meals.get(0));
                    }
                }
            });
        }
    }


}
