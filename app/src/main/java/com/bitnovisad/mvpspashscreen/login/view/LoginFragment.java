package com.bitnovisad.mvpspashscreen.login.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bitnovisad.mvpspashscreen.R;
import com.bitnovisad.mvpspashscreen.home.view.HomeScreenFragment;
import com.bitnovisad.mvpspashscreen.login.presenter.IntLoginPresenter;
import com.bitnovisad.mvpspashscreen.login.presenter.LoginPresenter;
import com.bitnovisad.mvpspashscreen.signup.view.SignUpFragment;

public class LoginFragment extends Fragment implements IntLoginFragmentView{

    EditText edtUsername, edtPassword;
    Button btnLogin, btnSignUp;
    IntLoginPresenter loginPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_fragment, container, false);

        //initialize data
        edtUsername = (EditText) v.findViewById(R.id.userNameField);
        edtPassword = (EditText) v.findViewById(R.id.userPasswordField);
        btnLogin = (Button) v.findViewById(R.id.btnLogin);
        btnSignUp = (Button) v.findViewById(R.id.btnSignUp);

        //initialize new login presenter object
        loginPresenter = new LoginPresenter(this);

        //event onclick listener for Login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.handleLogin(edtUsername.getText().toString(), edtPassword.getText().toString());
            }
        });

        //event onclick listener for Signup button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpFragment();
            }
        });

        return v;
    }

    //show message if login pass
    @Override
    public void successfullLogin(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    //show message if login fail
    @Override
    public void failedLogin(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    //opens home fragment if login pass
    @Override
    public void openHomeFragment() {
        // Begin the transaction
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_placeholder, new HomeScreenFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        ft.addToBackStack(null);
        ft.commit();
    }

    //opens signup fragment
    @Override
    public void openSignUpFragment(){
        // Begin the transaction
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_placeholder, new SignUpFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        ft.addToBackStack(null);
        ft.commit();
    }
}
