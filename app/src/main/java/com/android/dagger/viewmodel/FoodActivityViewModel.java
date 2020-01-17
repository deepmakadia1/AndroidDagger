package com.android.dagger.viewmodel;

import android.content.Context;

import com.android.dagger.model.entity.RecipeCategoryModel;
import com.android.dagger.repositories.FoodRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


public class FoodActivityViewModel extends ViewModel {

    private FoodRepository foodRepository;

    @Inject
    public FoodActivityViewModel(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public LiveData<List<RecipeCategoryModel.Categories>> getCategories(){
        return foodRepository.getMutableLiveDataCategories();
    }

    public LiveData<Boolean> getProgress(){
        return foodRepository.getMutableProgress();
    }

}
