package com.pashkobohdan.spritzreaderpro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

import static com.pashkobohdan.spritzreaderpro.Screen.DETAILS_SCREEN;
import static com.pashkobohdan.spritzreaderpro.Screen.LIST_SCREEN;

public class MainActivity extends AppCompatActivity {

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.main_container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch(screenKey) {
                case LIST_SCREEN:
                    //return ListFragment.getNewInstance(data);//TODO
                case DETAILS_SCREEN:
                    //return DetailsFragment.getNewInstance(data);//TODO
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
        SpritzProApplication.INSTANCE.getNavigatorHolder().setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SpritzProApplication.INSTANCE.getNavigatorHolder().removeNavigator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
