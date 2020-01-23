package com.android.dagger.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.View;

import com.android.dagger.R;
import com.android.dagger.adapter.DrinksListAdapter;
import com.android.dagger.databinding.FragmentDrinkCategoryBinding;
import com.android.dagger.model.entity.DrinkListModel;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.DrinkCategoryFragmentViewModel;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Nullable;
import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrinkCategoryFragment extends BaseFragment<FragmentDrinkCategoryBinding, DrinkCategoryFragmentViewModel> {

    private HashMap<String,String> map = new HashMap<>();

    @Inject
    DrinksListAdapter drinksListAdapter;

    @Inject
    LinearLayoutManager linearLayoutManager;

    public static DrinkCategoryFragment newInstance(String categoryName,String categoryFieldName) {
        DrinkCategoryFragment drinkCategoryFragment = new DrinkCategoryFragment();
        Bundle args = new Bundle();
        args.putString(Constants.DRINK_CATEGORY_NAME, categoryName);
        args.putString(Constants.CATEGORY_FIELD_NAME, categoryFieldName);
        drinkCategoryFragment.setArguments(args);
        return drinkCategoryFragment;
    }

    public DrinkCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayout() {
        return R.layout.fragment_drink_category;
    }

    @Override
    public Class<DrinkCategoryFragmentViewModel> getViewModel() {
        return DrinkCategoryFragmentViewModel.class;
    }

    @Override
    public void onCreateView() {

        String categoryName = getArguments() != null ? getArguments().getString(Constants.DRINK_CATEGORY_NAME) : null;
        String categoryFieldName = getArguments() != null ? getArguments().getString(Constants.CATEGORY_FIELD_NAME) : null;
        setRecyclerView();
        viewModel.getProsess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean != null && aBoolean) {
                    binding.listDrinks.setVisibility(View.GONE);
                    binding.progress.setVisibility(View.VISIBLE);
                } else {
                    binding.listDrinks.setVisibility(View.VISIBLE);
                    binding.progress.setVisibility(View.GONE);
                }
            }
        });

        map.clear();
        map.put(categoryFieldName,categoryName);
        viewModel.getDrinks(map).observe(this, new Observer<ArrayList<DrinkListModel.Drinks>>() {
            @Override
            public void onChanged(@Nullable ArrayList<DrinkListModel.Drinks> drinks) {
                drinksListAdapter.addItems(drinks);
            }
        });

    }

    private void setRecyclerView() {

        binding.listDrinks.setLayoutManager(linearLayoutManager);
        binding.listDrinks.setAdapter(drinksListAdapter);

    }
}
