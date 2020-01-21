package com.android.dagger.di.modules;

import com.android.dagger.di.annotation.ViewModelKey;
import com.android.dagger.model.state.RecipeServiceInterface;
import com.android.dagger.util.Constants;
import com.android.dagger.viewmodel.RecipeCategoryFragmentViewModel;
import com.android.dagger.viewmodel.RecipeDetailDialogViewModel;
import com.android.dagger.viewmodel.RecipeActivityViewModel;

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
public abstract class RecipeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RecipeActivityViewModel.class)
    public abstract ViewModel proviewRecipeActivityViewModel (RecipeActivityViewModel recipeActivityViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RecipeCategoryFragmentViewModel.class)
    public abstract ViewModel proviewRecipeCategoryFragmentViewModel (RecipeCategoryFragmentViewModel recipeCategoryFragmentViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RecipeDetailDialogViewModel.class)
    public abstract ViewModel proviewRecipeDetailDialogViewModel (RecipeDetailDialogViewModel recipeDetailDialogViewModel);

    @Provides
    static Retrofit provideRecipeRetrofit(GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.RECIPE_BASE_URL)
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
