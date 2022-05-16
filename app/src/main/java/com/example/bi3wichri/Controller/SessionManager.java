package com.example.bi3wichri.Controller;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        sharedPreferences=context.getSharedPreferences("appKey",0);
        editor=sharedPreferences.edit();
        editor.apply();
    }

    public void setLogin(boolean log){
        editor.putBoolean("KEY_LOGIN",log);
        editor.commit();
    }

    public boolean getLogin(){
        return sharedPreferences.getBoolean("KEY_LOGIN",false);
    }

    public void setLogin_U(String login){
        editor.putString("KEY_LOGIN_U",login);
        editor.apply();
    }

    public String getLogin_U(){
        return sharedPreferences.getString("KEY_LOGIN_U","");
    }

    public void setName_U(String name){
        editor.putString("KEY_NAME_U",name);
        editor.apply();
    }

    public String getName_U(){
        return sharedPreferences.getString("KEY_NAME_U","");
    }

    public void setID_U(int id){
        editor.putInt("KEY_ID",id);
        editor.apply();
    }
    public int getID_U(){
        return sharedPreferences.getInt("KEY_ID",0);
    }

}
