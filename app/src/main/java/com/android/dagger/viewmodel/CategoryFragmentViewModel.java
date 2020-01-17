package com.android.dagger.viewmodel;


import com.android.dagger.model.entity.RecipeModel;
import com.android.dagger.repositories.FoodRepository;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class CategoryFragmentViewModel extends ViewModel {


    private FoodRepository foodRepository;

    @Inject
    public CategoryFragmentViewModel(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public LiveData<List<RecipeModel.Recipe>> getRecipeList(String categoryName){
        return foodRepository.getMutableLiveDataRecipesList(categoryName);
    }

    public LiveData<Boolean> getProgress(){
        return foodRepository.getMutableProgress();
    }

}
