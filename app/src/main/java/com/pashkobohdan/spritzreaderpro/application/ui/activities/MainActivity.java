package com.pashkobohdan.spritzreaderpro.application.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.pashkobohdan.spritzreaderpro.R;
import com.pashkobohdan.spritzreaderpro.application.SpritzProApplication;
import com.pashkobohdan.spritzreaderpro.application.ui.common.CustomFragmentNavigator;
import com.pashkobohdan.spritzreaderpro.application.ui.fragments.book.BookListFragment;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.commands.Forward;

import static com.pashkobohdan.spritzreaderpro.application.ui.Screen.BOOK_LIST;
import static com.pashkobohdan.spritzreaderpro.application.ui.Screen.BOOK_READING;

public class MainActivity extends AppCompatActivity implements TitleChangeableActivity {

    @Inject
    NavigatorHolder navigatorHolder;
    @Inject
    Router router;

    private Navigator navigator = new CustomFragmentNavigator(getSupportFragmentManager(), R.id.main_container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case BOOK_LIST:
                    return BookListFragment.getNewInstance();
                case BOOK_READING:
                    //TODO
                default:
                    throw new IllegalArgumentException("Not supported screen: " + screenKey);
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SpritzProApplication.INSTANCE.getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            navigator.applyCommand(new Forward(BOOK_LIST, null));
        } else {
            navigator.applyCommand(new Forward(BOOK_LIST, null));
            //TODO maybe don't need this because I have a moxy (with stateStrategy)
        }
    }

    @Override
    public void setTitle(String title) {
//        TODO (now just setTitle(...) but can set to another custom header
//        setTitle(title);
    }
}
