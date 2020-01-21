package com.android.dagger.viewmodel;

import com.android.dagger.model.entity.RecipeDetailModel;
import com.android.dagger.repositories.RecipeRepository;


import java.util.ArrayList;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RecipeDetailDialogViewModel extends ViewModel {

    private RecipeRepository recipeRepository;

    @Inject
    RecipeDetailDialogViewModel(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public LiveData<ArrayList<RecipeDetailModel.Meals>> getMeals(String mealId){
        return recipeRepository.getListMutableLiveDataMeals(mealId);
    }

    public LiveData<Boolean> getProgress(){
        return recipeRepository.getMutableProgress();
    }
}
