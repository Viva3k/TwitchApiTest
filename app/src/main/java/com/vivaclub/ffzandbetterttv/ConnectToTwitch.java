package com.vivaclub.ffzandbetterttv;

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

public class ConnectToTwitch extends Thread {

    private String Token;
    private String URL;
    private Boolean Client_ID = false;
    private Boolean Authorization = true;
    private int responseCode = 200;
    private String JsonInputString;

    public ConnectToTwitch(String _url, String _Token,Boolean _Client_ID,Boolean _Authorization){
        Token = _Token;
        URL = _url;
        Client_ID = _Client_ID;
        Authorization = _Authorization;
    }
    public ConnectToTwitch(String _url, String _Token,Boolean _Authorization ){
        Token = _Token;
        URL = _url;
        Authorization = _Authorization;
    }
    public ConnectToTwitch(String _url, String _Token){
        Token = _Token;
        URL = _url;
    }
    public int getResponseCode() {
        return responseCode;
    }
    public String getJsonInputString() {
        return JsonInputString;
    }


    public void run() {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(URL);
            urlConnection = (HttpURLConnection) url.openConnection();
            if(Authorization) {
                urlConnection.setRequestProperty("Authorization", "Bearer " + Token);
            }
            if(Client_ID){
                urlConnection.setRequestProperty("Client-ID",Constant.CLIEND_ID);
            }
            if(urlConnection.getResponseCode() != 200){
                responseCode = urlConnection.getResponseCode();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(urlConnection.getInputStream())));
            String line;
            while((line = reader.readLine()) != null) {
                JsonInputString = line;
            }
        } catch (MalformedURLException E){
            System.out.println("MalformedURLException");
        } catch (IOException E){
            System.out.println("IOException");
        }finally {
            try {
                urlConnection.disconnect();
            }catch (NullPointerException e){
                System.out.println("NullPointerException");
            }
        }
    }

}
