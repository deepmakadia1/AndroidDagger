package com.android.dagger.model.state;


import com.android.dagger.model.entity.RecipeCategoryModel;
import com.android.dagger.model.entity.RecipeDetailModel;
import com.android.dagger.model.entity.RecipeModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeServiceInterface {

    @GET("categories.php")
    Observable<RecipeCategoryModel> getCategories();

    @GET("filter.php")
    Observable<RecipeModel> getRecipes(
            @Query("c") String categoryName
    );

    @GET("lookup.php")
    Observable<RecipeDetailModel> getMeal(
            @Query("i") String mealId
    );

}
