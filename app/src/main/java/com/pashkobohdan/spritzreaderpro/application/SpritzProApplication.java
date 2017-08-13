package com.pashkobohdan.spritzreaderpro.application;

import android.app.Application;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.pashkobohdan.spritzreaderpro.application.di.ApplicationComponent;
import com.pashkobohdan.spritzreaderpro.application.di.DaggerApplicationComponent;
import com.pashkobohdan.spritzreaderpro.application.di.modules.AppModule;
import com.pashkobohdan.spritzreaderpro.application.di.modules.DatabaseModule;

public class SpritzProApplication extends Application {

    public static SpritzProApplication INSTANCE;
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        //TODO maybe run first getApplicationComponent() here
    }

    @Override
    public void onTerminate() {
        OpenHelperManager.releaseHelper();// instead of releaseHelper
        super.onTerminate();
    }

    public ApplicationComponent getApplicationComponent() {
        if (component == null) {
            component = DaggerApplicationComponent
                    .builder()
                    .appModule(new AppModule(this))
                    .databaseModule(new DatabaseModule(this))
                    .build();
        }
        return component;
    }
}
