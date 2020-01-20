package com.android.dagger.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.android.dagger.R;
import com.android.dagger.databinding.ActivityDetailDrinksBinding;
import com.android.dagger.model.entity.DrinkDetailModel;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.DetailDrinkActivityViewModel;

import java.util.ArrayList;

import javax.annotation.Nullable;

import androidx.lifecycle.Observer;

public class DetailDrinksActivity extends BaseActivity<ActivityDetailDrinksBinding, DetailDrinkActivityViewModel> {

    @Override
    public int getLayout() {
        return R.layout.activity_detail_drinks;
    }

    @Override
    public Class<DetailDrinkActivityViewModel> getViewModel() {
        return DetailDrinkActivityViewModel.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel.getProcess().observe(this, new Observer<Boolean>() {
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

        viewModel.getDrink(getIntent().getStringExtra(Constants.DRINK_ID)).observe(this, new Observer<ArrayList<DrinkDetailModel.Drink>>() {
            @Override
            public void onChanged(@Nullable ArrayList<DrinkDetailModel.Drink> drinks) {
                if (drinks != null) {
                    binding.setDrink(drinks.get(0));
                }
            }
        });

    }
}
