package com.android.dagger.viewmodel;

import com.android.dagger.model.entity.RecipeDetailModel;
import com.android.dagger.repositories.FoodRepository;


import java.util.ArrayList;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DetailRecipeActivityViewModel extends ViewModel {

    private FoodRepository foodRepository;

    @Inject
    public DetailRecipeActivityViewModel(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public LiveData<ArrayList<RecipeDetailModel.Meals>> getMeals(String mealId){
        return foodRepository.getListMutableLiveDataMeals(mealId);
    }

    public LiveData<Boolean> getProgress(){
        return foodRepository.getMutableProgress();
    }
}
