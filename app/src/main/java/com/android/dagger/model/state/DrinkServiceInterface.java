package com.android.dagger.model.state;

import com.android.dagger.model.entity.DrinkCategoryListModel;
import com.android.dagger.model.entity.DrinkDetailModel;
import com.android.dagger.model.entity.DrinkListModel;


import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface DrinkServiceInterface {

    @GET("list.php")
    Observable<DrinkCategoryListModel> getDrinkCategoryList(
            @QueryMap HashMap<String, String> map
    );

    @GET("filter.php")
    Observable<DrinkListModel> getDrinkList(
            @QueryMap HashMap<String, String> map
    );

    @GET("lookup.php")
    Observable<DrinkDetailModel> getDrink(
            @Query("i") String drinkId
    );
}
