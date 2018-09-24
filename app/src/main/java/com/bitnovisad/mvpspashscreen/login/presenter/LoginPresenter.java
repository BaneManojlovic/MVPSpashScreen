package com.bitnovisad.mvpspashscreen.login.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.bitnovisad.mvpspashscreen.R;
import com.bitnovisad.mvpspashscreen.home.view.HomeScreenFragment;
import com.bitnovisad.mvpspashscreen.login.model.User;
import com.bitnovisad.mvpspashscreen.login.view.IntLoginFragmentView;
import com.bitnovisad.mvpspashscreen.login.view.LoginFragment;
import com.bitnovisad.mvpspashscreen.signup.view.SignUpFragment;

public class LoginPresenter implements IntLoginPresenter {

    IntLoginFragmentView loginView;

    public LoginPresenter(IntLoginFragmentView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void handleLogin(String username, String password) {

        //HomeScreenFragment selectedFragment = null;

        User user = new User(username, password);
        int loginCode = user.validateEnteredData();

        switch (loginCode){
            case 0:
                loginView.failedLogin("Fields are obligatory!");
                break;
            case 1:
                loginView.failedLogin("Wrong Username or Email");
                break;
            case 2:
                loginView.failedLogin("Password is obligatory!");
                break;
            case 3:
                loginView.failedLogin("Password must contain min 6 characters!");
                break;
                default:
                    loginView.successfullLogin("Login Success!");
                    loginView.openHomeFragment();

        }
    }



}
