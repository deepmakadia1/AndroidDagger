package com.android.dagger.viewmodel;


import com.android.dagger.model.entity.RecipeModel;
import com.android.dagger.repositories.RecipeRepository;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class CategoryFragmentViewModel extends ViewModel {


    private RecipeRepository recipeRepository;

    @Inject
    public CategoryFragmentViewModel(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public LiveData<List<RecipeModel.Recipe>> getRecipeList(String categoryName){
        return recipeRepository.getMutableLiveDataRecipesList(categoryName);
    }

    public LiveData<Boolean> getProgress(){
        return recipeRepository.getMutableProgress();
    }

}
