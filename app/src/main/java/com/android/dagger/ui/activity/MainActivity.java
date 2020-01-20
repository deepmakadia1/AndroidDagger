package com.android.dagger.ui.activity;

import androidx.databinding.DataBindingUtil;
import dagger.android.support.DaggerAppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.dagger.R;
import com.android.dagger.databinding.ActivityCategoryListBinding;
import com.android.dagger.databinding.ActivityMainBinding;

public class MainActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_main);

        binding.recipe.setOnClickListener(this);
        binding.drinks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.drinks:
                startActivity(new Intent(this, CategoryListActivity.class));
                break;
            case R.id.recipe:
                startActivity(new Intent(this, RecipeActivity.class));
                break;
        }
    }
}
