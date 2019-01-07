package com.vivaclub.ffzandbetterttv;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static android.content.Context.MODE_PRIVATE;

public class User {
    private String Login;
    private String Display_name;
    private String Token;
    private String Email;
    private String Profile_image_url;
    private int id;

    public String getNickname() {
        return Login;
    }
    public String getToken() {
        return Token;
    }
    public void setNickname(String nickname) {
        Login = nickname;
    }
    public void setToken(String token) {
        Token = token;
    }
    public User(String getToken, Context context){
        SharedPreferences loadToken = context.getSharedPreferences(Constant.SAVE_FILE_NAME,Context.MODE_PRIVATE);
        String token = loadToken.getString("Token","");
        if(token.equals("")) {
            Token = getToken.substring(getToken.indexOf("=")+1, getToken.indexOf("&"));
            ConnectToTwitch connectToTwitch = new ConnectToTwitch(Constant.URL_TWITCH_HELIX_USERS,Token);
            connectToTwitch.start();
            try {
                connectToTwitch.join();
            }catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
            if(connectToTwitch.getResponseCode()==200){
                try {
                    JSONObject userInfo = new JSONObject(new JSONObject(connectToTwitch.getJsonInputString()).getJSONArray("data").get(0).toString());
                    id = userInfo.getInt("id");
                    Login = userInfo.getString("login");
                    Display_name = userInfo.getString("display_name");
                    Email = userInfo.getString("email");
                    Profile_image_url = userInfo.getString("profile_image_url");

                    SharedPreferences saveToken = context.getSharedPreferences(Constant.SAVE_FILE_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editSave = saveToken.edit();
                    editSave.putInt("id", id);
                    editSave.putString("Login", Login);
                    editSave.putString("Display_name", Display_name);
                    editSave.putString("Email", Email);
                    editSave.putString("Profile_image_url", Profile_image_url);
                    editSave.putString("Token", Token);
                    editSave.commit();
                }
                catch (JSONException e){
                    System.out.println("JSONException");
                }
            }
            else {
                //Обработка ошибок 400, ... и т.д
            }
        }
        else{
            id = loadToken.getInt("id",0);
            Login = loadToken.getString("Login","");
            Display_name = loadToken.getString("Display_name","");
            Email = loadToken.getString("Email","");
            Profile_image_url = loadToken.getString("Profile_image_url","");
            Token = token;
        }
    }
}
