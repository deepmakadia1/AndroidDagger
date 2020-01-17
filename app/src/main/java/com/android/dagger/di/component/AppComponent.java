package com.android.dagger.di.component;

import android.app.Application;

import com.android.dagger.BaseApplication;
import com.android.dagger.di.modules.ActivityBuilder;
import com.android.dagger.di.modules.AppModule;
import com.android.dagger.di.modules.ViewModelFactoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        AppModule.class,
        ViewModelFactoryModule.class
})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
