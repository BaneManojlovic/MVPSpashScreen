package com.bitnovisad.mvpspashscreen.login.view;

public interface IntLoginFragmentView {

    void successfullLogin(String message);
    void failedLogin(String message);
    void openHomeFragment();
    void openSignUpFragment();
}
