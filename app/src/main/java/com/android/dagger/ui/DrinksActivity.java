package com.android.dagger.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.dagger.R;
import com.android.dagger.databinding.ActivityDrinksBinding;
import com.android.dagger.util.Constants;

import androidx.databinding.DataBindingUtil;
import dagger.android.support.DaggerAppCompatActivity;


public class DrinksActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private Context context;
    private Activity activity;
    private ActivityDrinksBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        activity = this;
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_drinks);
        binding.listByCategory.setOnClickListener(this);
        binding.listByGlasses.setOnClickListener(this);
        binding.listByIngredients.setOnClickListener(this);
        binding.listByAlcoholic.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.list_by_category:
                startActivity(new Intent(context,CategoryListActivity.class).putExtra(Constants.CATEGORY_FIELD_NAME,Constants.PARAM_C));
                break;
            case R.id.list_by_glasses:
                startActivity(new Intent(context,CategoryListActivity.class).putExtra(Constants.CATEGORY_FIELD_NAME,Constants.PARAM_G));
                break;
            case R.id.list_by_ingredients:
                startActivity(new Intent(context,CategoryListActivity.class).putExtra(Constants.CATEGORY_FIELD_NAME,Constants.PARAM_I));
                break;
            case R.id.list_by_alcoholic:
                startActivity(new Intent(context,CategoryListActivity.class).putExtra(Constants.CATEGORY_FIELD_NAME,Constants.PARAM_A));
                break;

        }
    }
}
