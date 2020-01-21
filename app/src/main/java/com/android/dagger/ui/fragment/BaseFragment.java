package com.android.dagger.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.dagger.viewmodel.factory.ViewModelProviderFactory;

import javax.annotation.Nullable;
import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatDialogFragment;

public abstract class BaseFragment<T extends ViewDataBinding, V extends ViewModel> extends DaggerAppCompatDialogFragment {

    public abstract int getLayout();

    public abstract Class<V> getViewModel();

    public abstract void onCreateView();

    public T binding;

    V viewModel;

    @Inject
    ViewModelProviderFactory factory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false);

        if (getViewModel() != null) {
            viewModel = ViewModelProviders.of(this,factory).get(getViewModel());
        }

        onCreateView();

        return binding.getRoot();
    }
}
