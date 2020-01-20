package com.android.dagger.ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.android.dagger.viewmodel.factory.ViewModelProviderFactory;

import javax.annotation.Nullable;
import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<T extends ViewDataBinding, V extends ViewModel> extends DaggerAppCompatActivity {

    public abstract int getLayout();

    public abstract Class<V> getViewModel();

    public T binding;

    public V viewModel;

    private ProgressDialog progressDialog;

    @Inject
    ViewModelProviderFactory factory;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = this;
        binding = DataBindingUtil.setContentView(activity, getLayout());

        if (getViewModel() != null) {
            viewModel = ViewModelProviders.of(this,factory).get(getViewModel());
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);

    }

    public void showProgress() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    public void hideProgress() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
