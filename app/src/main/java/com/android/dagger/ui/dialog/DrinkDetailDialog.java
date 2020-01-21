package com.android.dagger.ui.dialog;

import android.os.Bundle;
import android.view.View;

import com.android.dagger.R;
import com.android.dagger.databinding.DialogDetailDrinkBinding;
import com.android.dagger.model.entity.DrinkDetailModel;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.DrinkDetailDialogViewModel;

import java.util.ArrayList;

import javax.annotation.Nullable;

import androidx.lifecycle.Observer;

public class DrinkDetailDialog extends BaseDialog<DialogDetailDrinkBinding, DrinkDetailDialogViewModel> {

    public static DrinkDetailDialog newInstance(String drinkId) {
        DrinkDetailDialog dialog = new DrinkDetailDialog();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DRINK_ID, drinkId);
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public int getLayout() {
        return R.layout.dialog_detail_drink;
    }

    @Override
    public Class<DrinkDetailDialogViewModel> getViewModel() {
        return DrinkDetailDialogViewModel.class;
    }

    @Override
    public void onCreateView() {
        if (getArguments() != null) {
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

            viewModel.getDrink(getArguments().getString(Constants.DRINK_ID)).observe(this, new Observer<ArrayList<DrinkDetailModel.Drink>>() {
                @Override
                public void onChanged(@Nullable ArrayList<DrinkDetailModel.Drink> drinks) {
                    if (drinks != null) {
                        binding.setDrink(drinks.get(0));
                    }
                }
            });
        }
    }
}
