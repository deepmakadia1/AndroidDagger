package com.android.dagger.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import dagger.android.support.DaggerAppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.dagger.R;
import com.android.dagger.databinding.ActivityMainBinding;

public class MainActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_main);

        binding.food.setOnClickListener(this);
        binding.drinks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.drinks:
                startActivity(new Intent(this,DrinksActivity.class));
                break;
        }
    }
}
