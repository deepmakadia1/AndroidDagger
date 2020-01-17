package com.android.dagger.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.annotation.Nullable;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<T extends ViewDataBinding, V extends ViewModel> extends DaggerFragment {

    public abstract int getLayout();

    public abstract Class<V> getViewModel();

    public abstract void onCreateView();

    public T binding;

    public V viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false);

        if (getViewModel() != null) {
            viewModel = ViewModelProviders.of(this).get(getViewModel());
        }

        onCreateView();

        return binding.getRoot();
    }
}
