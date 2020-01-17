package com.android.dagger.viewmodel;

import com.android.dagger.model.entity.DrinkCategoryListModel;
import com.android.dagger.model.state.DrinkServiceInterface;
import com.android.dagger.network.RXRetroManager;
import com.android.dagger.repositories.DrinkRepository;
import com.android.dagger.util.Constants;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DrinkCategoryListViewModel extends ViewModel {

    DrinkRepository drinkRepository;

    @Inject
    public DrinkCategoryListViewModel(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public LiveData<ArrayList<DrinkCategoryListModel.DrinkCategories>> getDrinksCategory(HashMap<String,String> map){
        return drinkRepository.getListMutableLiveDataDrinkCategory(map);
    }

    public LiveData<Boolean> getProgress(){
        return drinkRepository.getMutableProgress();
    }

}
