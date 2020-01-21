package com.android.dagger.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.android.dagger.R;
import com.android.dagger.adapter.CustomPagerAdapter;
import com.android.dagger.databinding.ActivityDrinkBinding;
import com.android.dagger.model.entity.DrinkCategoryListModel;
import com.android.dagger.ui.fragment.DrinkCategoryFragment;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.DrinkActivityViewModel;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Nullable;

import androidx.lifecycle.Observer;


public class DrinkActivity extends BaseActivity<ActivityDrinkBinding, DrinkActivityViewModel> implements View.OnClickListener {

    private HashMap<String, String> map = new HashMap<>();
    private CustomPagerAdapter pagerAdapter;
    private String fieldName = "";

    @Override
    public int getLayout() {
        return R.layout.activity_drink;
    }

    @Override
    public Class<DrinkActivityViewModel> getViewModel() {
        return DrinkActivityViewModel.class;
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

        getCategories(Constants.PARAM_C);

        binding.menuSort.setClosedOnTouchOutside(true);
        binding.menuSort.setIconAnimated(false);
        setListeners();
    }

    private void setListeners() {

        binding.menuCategory.setOnClickListener(this);
        binding.menuGlasses.setOnClickListener(this);
        binding.menuIngredients.setOnClickListener(this);
        binding.menuAlcoholic.setOnClickListener(this);

    }

    private void getCategories(String name) {
        binding.menuSort.close(true);

        if (!fieldName.equals(name)) {
            fieldName = name;
            map.clear();
            map.put(fieldName, Constants.LIST);
            viewModel.getDrinksCategory(map).observe(this, new Observer<ArrayList<DrinkCategoryListModel.DrinkCategories>>() {
                @Override
                public void onChanged(@Nullable ArrayList<DrinkCategoryListModel.DrinkCategories> drinkCategories) {
                    if (drinkCategories != null) {
                        setupViewPager(drinkCategories);
                    }
                }
            });
        }

    }

    private void setupViewPager(ArrayList<DrinkCategoryListModel.DrinkCategories> drinkCategories) {

        pagerAdapter.clearList();
        for (DrinkCategoryListModel.DrinkCategories category : drinkCategories) {
            pagerAdapter.addFragment(DrinkCategoryFragment.newInstance(category.getStrData(), fieldName), category.getStrData());
        }
        binding.pagerCategory.setAdapter(pagerAdapter);
        binding.tabCategory.setupWithViewPager(binding.pagerCategory);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_category:
                getCategories(Constants.PARAM_C);
                break;
            case R.id.menu_glasses:
                getCategories(Constants.PARAM_G);
                break;
            case R.id.menu_ingredients:
                getCategories(Constants.PARAM_I);
                break;
            case R.id.menu_alcoholic:
                getCategories(Constants.PARAM_A);
                break;
        }
    }
}
