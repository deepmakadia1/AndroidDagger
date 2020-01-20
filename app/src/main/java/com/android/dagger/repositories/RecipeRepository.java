package com.android.dagger.repositories;

import com.android.dagger.model.entity.RecipeCategoryModel;
import com.android.dagger.model.entity.RecipeDetailModel;
import com.android.dagger.model.entity.RecipeModel;
import com.android.dagger.model.state.RecipeServiceInterface;
import com.android.dagger.network.RXRetroManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;

public class RecipeRepository {

    //Categories list Api call
    private ArrayList<RecipeCategoryModel.Categories> categories = new ArrayList<>();
    private MutableLiveData<List<RecipeCategoryModel.Categories>> mutableLiveDataCategories = new MutableLiveData<>();
    private MutableLiveData<Boolean> mutableProgress = new MutableLiveData<>();


    private RecipeServiceInterface recipeServiceInterface;

    @Inject
    RecipeRepository(RecipeServiceInterface recipeServiceInterface) {
        this.recipeServiceInterface = recipeServiceInterface;
    }

    public MutableLiveData<List<RecipeCategoryModel.Categories>> getMutableLiveDataCategories() {
        showProgress();

        new RXRetroManager<RecipeCategoryModel>(){
            @Override
            protected void onSuccess(RecipeCategoryModel Response) {
                hideProgress();
                if (Response != null && Response.getCategories() != null) {

                    categories = (ArrayList<RecipeCategoryModel.Categories>) Response.getCategories();
                    mutableLiveDataCategories.setValue(categories);

                }
            }

            @Override
            protected void onFailure(String msg) {
                hideProgress();
            }
        }.rxSingleCall(recipeServiceInterface.getCategories());

        return mutableLiveDataCategories;
    }


    //Recipes list Api call
    private ArrayList<RecipeModel.Recipe> recipes = new ArrayList<>();
    private MutableLiveData<List<RecipeModel.Recipe>> listMutableLiveDataRecipes = new MutableLiveData<>();

    public MutableLiveData<List<RecipeModel.Recipe>> getMutableLiveDataRecipesList(String categoryName) {
        showProgress();
        new RXRetroManager<RecipeModel>(){
            @Override
            protected void onSuccess(RecipeModel Response) {
                hideProgress();
                if (Response != null && Response.getMeals() != null) {
                    recipes = (ArrayList<RecipeModel.Recipe>) Response.getMeals();
                    listMutableLiveDataRecipes.setValue(recipes);
                }
            }

            @Override
            protected void onFailure(String msg) {
                hideProgress();
            }
        }.rxSingleCall(recipeServiceInterface.getRecipes(categoryName));
        return listMutableLiveDataRecipes;
    }

    //Recipe detail call
    private ArrayList<RecipeDetailModel.Meals> meals;
    private MutableLiveData<ArrayList<RecipeDetailModel.Meals>> listMutableLiveDataMeals = new MutableLiveData<>();

    public MutableLiveData<ArrayList<RecipeDetailModel.Meals>> getListMutableLiveDataMeals(String mealId) {
        showProgress();
        new RXRetroManager<RecipeDetailModel>(){
            @Override
            protected void onSuccess(RecipeDetailModel Response) {
                hideProgress();
                if (Response != null && Response.getMeals() != null) {
                    meals = (ArrayList<RecipeDetailModel.Meals>) Response.getMeals();
                    listMutableLiveDataMeals.setValue(meals);
                }
            }

            @Override
            protected void onFailure(String msg) {
                hideProgress();
            }
        }.rxSingleCall(recipeServiceInterface.getMeal(mealId));
        return listMutableLiveDataMeals;
    }

    public MutableLiveData<Boolean> getMutableProgress() {
        return mutableProgress;
    }

    private void hideProgress() {
        mutableProgress.postValue(false);
    }

    private void showProgress() {
        mutableProgress.setValue(true);
    }

}
