package com.android.dagger.viewmodel;


import com.android.dagger.model.entity.DrinkListModel;
import com.android.dagger.repositories.DrinkRepository;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DrinkListActivityViewModel extends ViewModel {

    private DrinkRepository drinkRepository;

    @Inject
    public DrinkListActivityViewModel(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public LiveData<ArrayList<DrinkListModel.Drinks>> getDrinks(HashMap<String, String> map){
        return drinkRepository.getListMutableLiveDataDrinks(map);
    }

    public LiveData<Boolean> getProsess(){
        return drinkRepository.getMutableProgress();
    }

}
