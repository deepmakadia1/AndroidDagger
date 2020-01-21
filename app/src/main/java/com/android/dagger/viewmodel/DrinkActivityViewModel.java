package com.android.dagger.viewmodel;

import com.android.dagger.model.entity.DrinkCategoryListModel;
import com.android.dagger.repositories.DrinkRepository;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DrinkActivityViewModel extends ViewModel {

    private DrinkRepository drinkRepository;

    @Inject
    DrinkActivityViewModel(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public LiveData<ArrayList<DrinkCategoryListModel.DrinkCategories>> getDrinksCategory(HashMap<String,String> map){
        return drinkRepository.getListMutableLiveDataDrinkCategory(map);
    }

    public LiveData<Boolean> getProgress(){
        return drinkRepository.getMutableProgress();
    }

}
