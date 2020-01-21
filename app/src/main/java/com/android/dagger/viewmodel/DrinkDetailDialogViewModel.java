package com.android.dagger.viewmodel;


import com.android.dagger.model.entity.DrinkDetailModel;
import com.android.dagger.repositories.DrinkRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DrinkDetailDialogViewModel extends ViewModel {

    private DrinkRepository drinkRepository;

    @Inject
    DrinkDetailDialogViewModel(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public LiveData<ArrayList<DrinkDetailModel.Drink>> getDrink (String mealId){
        return drinkRepository.getListMutableLiveDataDrink(mealId);
    }

    public LiveData<Boolean> getProcess(){
        return drinkRepository.getMutableProgress();
    }
}
