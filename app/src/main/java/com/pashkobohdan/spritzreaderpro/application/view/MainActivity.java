package com.pashkobohdan.spritzreaderpro.application.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.pashkobohdan.spritzreaderpro.R;
import com.pashkobohdan.spritzreaderpro.application.SpritzProApplication;
import com.pashkobohdan.spritzreaderpro.application.view.book.BookListFragment;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.FragmentNavigator;

import static com.pashkobohdan.spritzreaderpro.application.view.Screen.DETAILS_SCREEN;
import static com.pashkobohdan.spritzreaderpro.application.view.Screen.LIST_SCREEN;

public class MainActivity extends AppCompatActivity {

    private Navigator navigator = new FragmentNavigator(getFragmentManager(), R.id.main_container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch(screenKey) {
                case LIST_SCREEN:
                    return BookListFragment.getNewInstance();
                case DETAILS_SCREEN:
                    //TODO
                default:
                    throw new RuntimeException("Unknown screen key!");
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
        SpritzProApplication.INSTANCE.getNavigatorHolder().setNavigator(navigator);//TODO change to injected Router
    }

    @Override
    protected void onPause() {
        super.onPause();
        SpritzProApplication.INSTANCE.getNavigatorHolder().removeNavigator();//TODO too
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
