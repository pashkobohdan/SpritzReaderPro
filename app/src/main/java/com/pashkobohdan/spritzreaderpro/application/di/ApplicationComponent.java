package com.pashkobohdan.spritzreaderpro.application.di;

import com.pashkobohdan.spritzreaderpro.application.di.modules.AppModule;
import com.pashkobohdan.spritzreaderpro.application.di.modules.NavigationModule;
import com.pashkobohdan.spritzreaderpro.application.ui.activities.MainActivity;
import com.pashkobohdan.spritzreaderpro.application.ui.fragments.book.BookListFragment;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        NavigationModule.class
})
public interface ApplicationComponent {

    void inject(MainActivity activity);

    void inject(BookListFragment fragment);
}