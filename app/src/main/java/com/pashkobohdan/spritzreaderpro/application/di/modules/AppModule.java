package com.pashkobohdan.spritzreaderpro.application.di.modules;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.pashkobohdan.spritzreaderpro.application.mvp.bookList.BookListPresenter;
import com.pashkobohdan.spritzreaderpro.application.ui.activities.TitleChangeableActivity;
import com.pashkobohdan.spritzreaderpro.application.ui.common.EmptyActivityLifecycleCallbacks;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context applicationContext;

    public AppModule(Application application) {
        applicationContext = application;
        application.registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
            @Override
            public void onActivityStarted(Activity activity) {
                applicationContext = activity;
            }
        });
    }

    @Provides
    public Context provideContext() {
        return applicationContext;
    }

    @Provides
    public BookListPresenter provideBookListPresenter() {
        return new BookListPresenter();
    }

    @Provides
    public TitleChangeableActivity provideTitleChangeableActivity() {
        return (TitleChangeableActivity) applicationContext;
    }
}
