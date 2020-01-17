package com.android.dagger.repositories;

import com.android.dagger.model.entity.DrinkCategoryListModel;
import com.android.dagger.model.entity.DrinkDetailModel;
import com.android.dagger.model.entity.DrinkListModel;
import com.android.dagger.model.state.DrinkServiceInterface;
import com.android.dagger.network.RXRetroManager;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;

public class DrinkRepository {

    private ArrayList<DrinkCategoryListModel.DrinkCategories> drinksCategory;
    private MutableLiveData<ArrayList<DrinkCategoryListModel.DrinkCategories>> listMutableLiveDataDrinkCategory = new MutableLiveData<>();
    private MutableLiveData<Boolean> mutableProgress = new MutableLiveData<>();


    private DrinkServiceInterface drinkServiceInterface;


    @Inject
    public DrinkRepository(DrinkServiceInterface drinkServiceInterface) {
        this.drinkServiceInterface = drinkServiceInterface;
    }

    public MutableLiveData<ArrayList<DrinkCategoryListModel.DrinkCategories>> getListMutableLiveDataDrinkCategory(HashMap<String, String> map) {
        showProgress();

        new RXRetroManager<DrinkCategoryListModel>(){
            @Override
            protected void onSuccess(DrinkCategoryListModel Response) {
                hideProgress();
                if (Response!=null && Response.getDrinks()!= null){
                    drinksCategory = (ArrayList<DrinkCategoryListModel.DrinkCategories>) Response.getDrinks();
                    listMutableLiveDataDrinkCategory.setValue(drinksCategory);
                }
            }

            @Override
            protected void onFailure(String msg) {
                hideProgress();
            }
        }.rxSingleCall(drinkServiceInterface.getDrinkCategoryList(map));



        return listMutableLiveDataDrinkCategory;
    }

    private ArrayList<DrinkListModel.Drinks> drinks;
    private MutableLiveData<ArrayList<DrinkListModel.Drinks>> listMutableLiveDataDrinks = new MutableLiveData<>();

    public MutableLiveData<ArrayList<DrinkListModel.Drinks>> getListMutableLiveDataDrinks(HashMap<String, String> map) {

        showProgress();

        new RXRetroManager<DrinkListModel>(){
            @Override
            protected void onSuccess(DrinkListModel Response) {

                hideProgress();
                if (Response!=null && Response.getDrinks()!=null){
                    drinks = (ArrayList<DrinkListModel.Drinks>) Response.getDrinks();
                    listMutableLiveDataDrinks.setValue(drinks);
                }
            }

            @Override
            protected void onFailure(String msg) {
                hideProgress();
            }
        }.rxSingleCall(drinkServiceInterface.getDrinkList(map));



        return listMutableLiveDataDrinks;
    }

    public MutableLiveData<Boolean> getMutableProgress() {
        return mutableProgress;
    }

    private ArrayList<DrinkDetailModel.Drink> drink = new ArrayList<>();
    private MutableLiveData<ArrayList<DrinkDetailModel.Drink>> listMutableLiveDataDrink = new MutableLiveData<>();

    public MutableLiveData<ArrayList<DrinkDetailModel.Drink>> getListMutableLiveDataDrink(String drinkId) {

        showProgress();

        new RXRetroManager<DrinkDetailModel>(){
            @Override
            protected void onSuccess(DrinkDetailModel Response) {
                hideProgress();
                if (Response != null && Response.getDrinks()!=null){
                    drink = (ArrayList<DrinkDetailModel.Drink>) Response.getDrinks();
                    listMutableLiveDataDrink.setValue(drink);
                }
            }

            @Override
            protected void onFailure(String msg) {
                hideProgress();
            }
        }.rxSingleCall(drinkServiceInterface.getDrink(drinkId));

        return listMutableLiveDataDrink;
    }

    private void hideProgress() {
        mutableProgress.postValue(false);
    }

    private void showProgress() {
        mutableProgress.setValue(true);
    }
}
