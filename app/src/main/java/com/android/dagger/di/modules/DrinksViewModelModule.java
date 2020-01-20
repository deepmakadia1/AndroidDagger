package com.android.dagger.di.modules;

import com.android.dagger.di.annotation.ViewModelKey;
import com.android.dagger.model.state.DrinkServiceInterface;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.DetailDrinkActivityViewModel;
import com.android.dagger.viewmodel.DrinkCategoryListViewModel;
import com.android.dagger.viewmodel.DrinkListFragmentViewModel;

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
public abstract class DrinksViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DrinkCategoryListViewModel.class)
    public abstract ViewModel proviewCategoryListViewModel (DrinkCategoryListViewModel drinkCategoryListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DrinkListFragmentViewModel.class)
    public abstract ViewModel proviewDrinkListFragmentViewModel (DrinkListFragmentViewModel drinkListFragmentViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DetailDrinkActivityViewModel.class)
    public abstract ViewModel proviewDetailDrinkActivityViewModel (DetailDrinkActivityViewModel detailDrinkActivityViewModel);


    @Provides
    static Retrofit provideDrinkRetrofit(GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.DRINK_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();
    }

    @Provides
    static DrinkServiceInterface provideDrinkServiceInterface(Retrofit retrofit){
        return retrofit.create(DrinkServiceInterface.class);
    }

}
