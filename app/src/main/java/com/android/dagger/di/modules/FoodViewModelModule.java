package com.android.dagger.di.modules;

import com.android.dagger.di.annotation.ViewModelKey;
import com.android.dagger.model.state.DrinkServiceInterface;
import com.android.dagger.model.state.RecipeServiceInterface;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.CategoryFragmentViewModel;
import com.android.dagger.viewmodel.DetailDrinkActivityViewModel;
import com.android.dagger.viewmodel.FoodActivityViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class FoodViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FoodActivityViewModel.class)
    public abstract ViewModel proviewFoodActivityViewModel (FoodActivityViewModel foodActivityViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CategoryFragmentViewModel.class)
    public abstract ViewModel proviewCategoryFragmentViewModel (CategoryFragmentViewModel categoryFragmentViewModel);

    @Provides
    static Retrofit provideFoodRetrofit(GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.FOOD_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();
    }

    @Provides
    static RecipeServiceInterface provideRecipeServiceInterface(Retrofit retrofit){
        return retrofit.create(RecipeServiceInterface.class);
    }

}
