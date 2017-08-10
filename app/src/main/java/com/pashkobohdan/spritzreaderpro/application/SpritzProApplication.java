package com.pashkobohdan.spritzreaderpro.application;

import android.app.Application;

import com.pashkobohdan.spritzreaderpro.application.di.ApplicationComponent;
import com.pashkobohdan.spritzreaderpro.application.di.DaggerApplicationComponent;
import com.pashkobohdan.spritzreaderpro.application.di.modules.AppModule;
import com.pashkobohdan.spritzreaderpro.application.di.modules.NavigationModule;

public class SpritzProApplication extends Application {

    public static SpritzProApplication INSTANCE;
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public ApplicationComponent getApplicationComponent() {
        if (component == null) {
            component = DaggerApplicationComponent
                    .builder()
                    .appModule(new AppModule(this))
                    .navigationModule(new NavigationModule())
                    .build();
        }
        return component;
    }
}
