package com.bitnovisad.mvpspashscreen.main.view;

import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bitnovisad.mvpspashscreen.R;
import com.bitnovisad.mvpspashscreen.login.view.LoginFragment;

public class MainActivity extends AppCompatActivity implements IntMainActivityView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //calling for opening of login fragemnt
        openLoginFragment();
    }

    @Override
    public void openLoginFragment() {
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_placeholder, new LoginFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        ft.commit();
    }
}
