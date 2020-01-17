package com.android.dagger.ui;

import android.content.Context;
import android.os.Bundle;

import com.android.dagger.R;
import com.android.dagger.adapter.DrinksListAdapter;
import com.android.dagger.databinding.ActivityDrinkListBinding;
import com.android.dagger.model.entity.DrinkListModel;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.DrinkListActivityViewModel;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Nullable;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

public class DrinkListActivity extends BaseActivity<ActivityDrinkListBinding, DrinkListActivityViewModel> {

    private HashMap<String, String> map = new HashMap<>();
    private Context context;

    @Override
    public int getLayout() {
        return R.layout.activity_drink_list;
    }

    @Override
    public Class<DrinkListActivityViewModel> getViewModel() {
        return DrinkListActivityViewModel.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        viewModel.getProsess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean != null && aBoolean) {
                    showProgress();
                } else {
                    hideProgress();
                }
            }
        });

        map.clear();
        map.put(getIntent().getStringExtra(Constants.CATEGORY_FIELD_NAME),getIntent().getStringExtra(Constants.FILTER_NAME));
        viewModel.getDrinks(map).observe(this, new Observer<ArrayList<DrinkListModel.Drinks>>() {
            @Override
            public void onChanged(@Nullable ArrayList<DrinkListModel.Drinks> drinks) {
                setRecyclerView(drinks);
            }
        });

    }

    private void setRecyclerView(ArrayList<DrinkListModel.Drinks> drinks) {

        DrinksListAdapter drinksListAdapter =  new DrinksListAdapter(context,drinks);
        binding.listDrinks.setLayoutManager(new LinearLayoutManager(context));
        binding.listDrinks.setAdapter(drinksListAdapter);

    }
}
