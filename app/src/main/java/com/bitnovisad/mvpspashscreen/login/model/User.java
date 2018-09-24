package com.bitnovisad.mvpspashscreen.login.model;

import android.text.TextUtils;

public class User implements IntUser {

    private String username, password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int validateEnteredData() {

        if(TextUtils.isEmpty(getUsername()) && TextUtils.isEmpty(getPassword())){
            return 0;
        }else if(!getUsername().equals("Baki")){
            return 1;
        }else  if(getPassword().equals(" ")){
            return 2;
        }else if(getPassword().length() < 6){
            return 3;
        }else{
            return -1;
        }
    }
}
