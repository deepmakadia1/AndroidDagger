package com.android.dagger.viewmodel;

import com.android.dagger.model.entity.RecipeCategoryModel;
import com.android.dagger.repositories.RecipeRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


public class RecipeActivityViewModel extends ViewModel {

    private RecipeRepository recipeRepository;

    @Inject
    public RecipeActivityViewModel(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public LiveData<List<RecipeCategoryModel.Categories>> getCategories(){
        return recipeRepository.getMutableLiveDataCategories();
    }

    public LiveData<Boolean> getProgress(){
        return recipeRepository.getMutableProgress();
    }

}
