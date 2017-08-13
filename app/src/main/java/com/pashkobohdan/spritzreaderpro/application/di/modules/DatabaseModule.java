package com.pashkobohdan.spritzreaderpro.application.di.modules;

import android.app.Application;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.pashkobohdan.spritzreaderpro.application.model.database.ormlite.common.DatabaseManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    private static DatabaseManager databaseHelper;

    public DatabaseModule(Application application) {
        databaseHelper = OpenHelperManager.getHelper(application, DatabaseManager.class);
    }

    @Provides
    @Singleton
    public DatabaseManager provideDatabaseHelper() {
        return databaseHelper;
    }
}
